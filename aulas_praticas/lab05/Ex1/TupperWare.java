package Ex1;

public class TupperWare extends Container {

    Portion portion;
    
    public TupperWare(Portion portion) {
        this.portion = portion;
    }

    @Override
    public String toString() {
        return "TupperWare with portion = " + this.portion;
    }
    
    
}