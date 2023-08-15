package lab01;

import java.util.Arrays;
import java.util.ArrayList;

public class Validator {
    static private final int maxSize = 40;

    // Checks word grid size and squareness
    private static boolean puzzleFormat(String[] problem) {
        int rowSize = problem[0].length();
        if (problem.length != rowSize) {
            return true;
        }
        if (rowSize > maxSize) {
            throw new IllegalArgumentException("Puzzle size is too large");
        }
        return Arrays.stream(problem).anyMatch(line -> line.length() > maxSize);
    }

    private static boolean puzzleCapitalized(String[] problem) {
        if (puzzleFormat(problem)) {
            return false;
        }
        int rowSize = problem[0].length();
        for (int i = rowSize - 1; i >= 0; i--) {
            if (problem[i].chars().anyMatch(Character::isLowerCase)) {
                return false;
            }
        }
        return true;
    }

    private static boolean wordsNotCapitalized(String[] problem) {
        if (puzzleFormat(problem)) {
            return false;
        }
        int rowSize = problem[0].length();
        for (int wordLine = rowSize; wordLine < problem.length; wordLine++) {
            if (problem[wordLine].chars().allMatch(Character::isUpperCase)) {
                return false;
            }
        }
        return true;
    }

    private static boolean wordsAreValidCharacters(String[] problem) {
        if (puzzleFormat(problem)) {
            return false;
        }
        int rowSize = problem[0].length();
        for (int i = rowSize - 1; i >= 0; i--) {
            if (problem[i].chars().anyMatch(c -> !Character.isLetter(c))) {
                if (problem[i].chars().anyMatch(c -> c != ' ' || c != ';' || c != ',')) {
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    private static boolean notEmpty(String[] problem) {
        return Arrays.stream(problem).anyMatch(line -> line.length() == 0);
    }

    private static boolean minSize(String[] problem) {
        if (puzzleFormat(problem)) {
            return false;
        }
        ArrayList<String> words = WSSolver.getWords(problem);
        for (String word : words) {
            if (word.length() < 3) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<String> removeInvalidWords(ArrayList<String> words) {
        for (String comparator : words) {
            for (String compared : words) {
                if (comparator.equals(compared)) {
                    continue;
                }
                if (comparator.contains(compared)) {
                    words.remove(compared);
                }
            }
        }
        return words;
    }

    public static boolean validate(String[] problem) {
        if (notEmpty(problem)) {
            return false;
        }
        if (puzzleCapitalized(problem)) {
            return false;
        }
        if (wordsNotCapitalized(problem)) {
            return false;
        }
        if (wordsAreValidCharacters(problem)) {
            return false;
        }
        return !minSize(problem);
    }
}