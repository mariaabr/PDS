package Ex1;

public class TermicBottle extends Container {

    Portion portion;

    public TermicBottle(Portion portion) {
        this.portion = portion;
    }

    @Override
    public String toString() {
        return "TermicBottle with portion = " + this.portion;
    }
}