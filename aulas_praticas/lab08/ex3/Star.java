import java.awt.*;
import startypes.StarType;

public class Star {

    private int x;
    private int y;
    private StarType startype;

    public Star(int x, int y, StarType startype) {
        this.x = x;
        this.y = y;
        this.startype = startype;
    }

    public void draw(Graphics g) {
        g.setColor(this.startype.getColor());
        g.fillOval(this.x, this.y , this.startype.getSize(), this.startype.getSize());
    } 
}