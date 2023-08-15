package Ex1;

public class PlasticBag extends Container{

    Portion portion;

    public PlasticBag(Portion portion) {
        this.portion = portion;
    }

    @Override
    public String toString() {
        return "PlasticBag with portion = " + this.portion;
    }
}