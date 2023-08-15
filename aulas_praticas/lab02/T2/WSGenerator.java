package lab01;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WSGenerator {
    public static void main(String[] args) {
        ArrayList<String> wordLines = new ArrayList<>();
        int size = -1;
        boolean save = false;
        String saveFile = "";
        for (String arg : args) {
            if (arg.equals("-i")) {
                String file = Arrays.asList(args).get(Arrays.asList(args).indexOf(arg) + 1);
                if (new File(file).exists()) {
                    try {
                        Scanner sc = new Scanner(new FileReader(file));
                        while (sc.hasNextLine()) {
                            wordLines.add(sc.nextLine());
                        }
                        sc.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Cannot read file");
                    }
                } else {
                    System.out.println("File does not exist");
                }
            }
            if (arg.equals("-s")) {
                size = Integer.parseInt(Arrays.asList(args).get(Arrays.asList(args).indexOf(arg) + 1));
            }
            if (arg.equals("-o")) {
                save = true;
                saveFile = Arrays.asList(args).get(Arrays.asList(args).indexOf(arg) + 1);
            }
        }
        if (size == -1) {
            System.out.println("Size not given");
            return;
        }
        ArrayList<String> words = new ArrayList<>();
        for (String line : wordLines) {
            words.addAll(Arrays.asList(line.split("([; ,])")));
        }
        String[] wordsArr = new String[words.size()];
        wordsArr = words.toArray(wordsArr);
        String[] problem = tryGenerate(size, wordsArr, 0);
        printProblem(problem);
        if (save) {
            saveProblem(problem, wordsArr, saveFile);
        }
    }

    private static String[] tryGenerate(int size, String[] words, int tries) {
        String[] problem;
        try {
            do {
                problem = generate(size, words);
            } while (Validator.validate(problem));
        } catch (IllegalArgumentException e) {
            System.out.println("Given size is invalid.");
            return new String[0];
        } catch (IllegalCallerException e) {
            System.out.println("Trying again...");
            if (tries > 100) {
                System.out.println("Too many tries, giving up.");
                return new String[0];
            }
            return tryGenerate(size, words, tries + 1);
        }
        return problem;
    }

    private static void printProblem(String[] problem) {
        for (String row : problem) {
            System.out.println(row);
        }
    }

    private static void saveProblem(String[] problem, String[] words, String file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (String row : problem) {
                writer.println(row);
            }
            for (String word : words) {
                writer.print(word.toLowerCase() + ",");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save problem");
        }
    }

    private static String[] generate(int size, String[] words) {
        String[] problem = new String[size];
        for (int i = 0; i < size; i++) {
            problem[i] = "";
            for (int j = 0; j < size; j++) {
                problem[i] += "_";
            }
        }
        // https://stackoverflow.com/questions/18885656/java-sort-a-list-of-words-by-length-then-by-alphabetical-order
        Collections.sort(Arrays.asList(words), new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2.length() - s1.length());
            }
        });
        for (String word : words) {
            // get all possible placements for word
            ArrayList<Solution> possibilities = placements(problem, word);
            // if no placement is possible, throw exception
            if (possibilities.size() == 0) {
                throw new IllegalCallerException("No placement possible");
            }
            Random rand = new Random();
            // choose random placement
            int randIndex = rand.nextInt(possibilities.size());
            Solution solution = possibilities.get(randIndex);
            int[] directionIter = Commons.directionIter(solution.direction);
            // place word
            for (int i = 0; i < word.length(); i++) {
                int row = solution.line + i * directionIter[0];
                int col = solution.column + i * directionIter[1];
                problem[row] = problem[row].substring(0, col) + Character.toUpperCase(word.charAt(i))
                        + problem[row].substring(col + 1);
            }
        }
        // https://stackoverflow.com/questions/52657252/changing-characters-in-a-string-in-java
        StringBuilder br = new StringBuilder();
        // replace all placeholders with random letters
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (problem[i].charAt(j) == '_') {
                    Random rand = new Random();
                    br.append((char) (rand.nextInt(26) + 'A'));
                } else {
                    br.append(problem[i].charAt(j));
                }
            }
        }
        // return string array
        String[] result = new String[size];
        for (int i = 0; i < size * size; i = i + size) {
            result[i / size] = br.substring(i, i + size);
        }
        return result;
    }

    private static ArrayList<Solution> placements(String[] problem, String word) {
        ArrayList<Solution> possibilities = new ArrayList<>();
        int rowSize = problem[0].length();
        // for every row
        for (int row = 0; row < rowSize; row++) {
            // for every column
            for (int col = 0; col < rowSize; col++) {
                // for every direction
                for (Direction direction : Direction.values()) {
                    int[] directionIter = Commons.directionIter(direction);
                    // check if word fits
                    if (Commons.fitInBounds(row, col, rowSize, word.length(), direction)) {
                        // assume placement is valid
                        boolean valid = true;
                        // for every letter in word
                        for (int i = 0; i < word.length(); i++) {
                            // if char has already been placed and doesn't match word char
                            if (problem[row].charAt(col + directionIter[1] * i) != '_'
                                    && problem[row].charAt(col + directionIter[1] * i) != word.charAt(i)) {
                                // break
                                valid = false;
                                break;
                            }

                        }
                        // if placement is valid, add to possibilities
                        if (valid) {
                            possibilities.add(new Solution(row, col, direction, word));
                        }
                    }
                }
            }
        }
        return possibilities;
    }
}