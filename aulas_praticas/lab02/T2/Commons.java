package lab01;

public class Commons {
    public static boolean fitInBounds(int row, int col, int rowSize, int wordLength, Direction direction) {
        int rowComp = row + 1;
        int colComp = col + 1;
        return switch (direction) {
            case UP:
                yield rowComp >= wordLength;
            case UP_RIGHT:
                yield rowComp >= wordLength && colComp <= rowSize - wordLength;
            case RIGHT:
                yield colComp <= rowSize - wordLength;
            case DOWN_RIGHT:
                yield rowComp <= rowSize - wordLength && colComp <= rowSize - wordLength;
            case DOWN:
                yield rowComp <= rowSize - wordLength;
            case DOWN_LEFT:
                yield rowComp <= rowSize - wordLength && colComp >= wordLength;
            case LEFT:
                yield colComp >= wordLength;
            case UP_LEFT:
                yield rowComp >= wordLength && colComp >= wordLength;
        };
    }

    public static boolean checkWord(String[] problem, String word, int row, int col, Direction direction) {
        int rowSize = problem[0].length();
        int wordLength = word.length();
        if (fitInBounds(row, col, rowSize, wordLength, direction)) {
            for (int i = 0; i < wordLength; i++) {
                if (Character.toLowerCase(problem[row].charAt(col)) != word.charAt(i)) {
                    return false;
                }
                int[] iterDirection = directionIter(direction);
                row += iterDirection[0];
                col += iterDirection[1];
            }
            return true;
        }
        return false;
    }

    public static int[] directionIter(Direction direction) {
        // Row and column iteration vector, according to direction
        return switch (direction) {
            case UP -> new int[] { -1, 0 };
            case UP_RIGHT -> new int[] { -1, 1 };
            case RIGHT -> new int[] { 0, 1 };
            case DOWN_RIGHT -> new int[] { 1, 1 };
            case DOWN -> new int[] { 1, 0 };
            case DOWN_LEFT -> new int[] { 1, -1 };
            case LEFT -> new int[] { 0, -1 };
            case UP_LEFT -> new int[] { -1, -1 };
        };
    }

}
