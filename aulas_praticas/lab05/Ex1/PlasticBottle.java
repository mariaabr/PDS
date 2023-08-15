

package Ex1;

public class PlasticBottle extends Container {

    Portion portion;
    
    public PlasticBottle(Portion portion) {
        this.portion = portion;
    }

    @Override
    public String toString() {
        return "PlasticBottle with portion = " + this.portion;
    }
}
