package lab01;

public class Solution {
    public int line;
    public int column;
    public Direction direction;
    public String word;

    public Solution(int srow, int scol, Direction direction, String word) {
        this.line = srow;
        this.column = scol;
        this.direction = direction;
        this.word = word;
    }
}
