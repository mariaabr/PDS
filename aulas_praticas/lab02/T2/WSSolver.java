package lab01;

import java.io.FileReader;
import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class WSSolver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(args[0]));
        ArrayList<String> problem = new ArrayList<>();
        while (sc.hasNextLine()) {
            problem.add(sc.nextLine());
        }
        if (Validator.validate(problem.toArray(new String[0]))) {
            System.out.println("Valid problem was given, solving...");
        } else {
            System.out.println("Invalid problem was given");
            return;
        }
        sc.close();
        ArrayList<Solution> solutions = solve(problem.toArray(new String[0]));
        for (Solution solution : solutions) {
            System.out.printf("%-12s\t%2d\t\t%2d, %2d\t%s\n", solution.word, solution.word.length(), solution.line,
                    solution.column, solution.direction);
        }
        printSolution(problem.toArray(new String[0]), solutions);
    }

    public static ArrayList<Solution> solve(String[] problem) {
        ArrayList<Solution> solutions = new ArrayList<>();
        for (String word : getWords(problem)) {
            for (int row = 0; row < problem[0].length(); row++) {
                for (int col = 0; col < problem[0].length(); col++) {
                    for (Direction direction : Direction.values()) {
                        if (Commons.checkWord(problem, word, row, col, direction)) {
                            solutions.add(new Solution(row + 1, col + 1, direction, word));
                        }
                    }
                }
            }
        }
        return solutions;
    }

    public static ArrayList<String> getWords(String[] problem) {
        int rowSize = problem[0].length();
        ArrayList<String> words = new ArrayList<>();
        for (int wordLine = rowSize; wordLine < problem.length; wordLine++) {
            words.addAll(Arrays.asList(problem[wordLine].split("([; ,])")));
        }
        return words;
    }

    public static void printSolution(String[] problem, ArrayList<Solution> solution) {
        String[][] problemList = new String[problem[0].length()][problem[0].length()];
        // chck chars that belong to solutions
        for (Solution sol : solution) {
            for (int i = 0; i < sol.word.length(); i++) {
                int[] iterDirection = Commons.directionIter(sol.direction);
                problemList[sol.line - 1 + iterDirection[0] * i][sol.column - 1 + iterDirection[1] * i] = Character
                        .toString(sol.word.charAt(i));
            }
        }
        for (String[] strings : problemList) {
            for (int j = 0; j < problemList.length; j++) {
                if (strings[j] == null) {
                    System.out.print(".");
                } else {
                    System.out.print(strings[j].toUpperCase());
                }
            }
            System.out.println();
        }
    }
}
