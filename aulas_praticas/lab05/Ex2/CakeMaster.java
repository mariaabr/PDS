package Ex2;

public class CakeMaster {

    private CakeBuilder cake;

    public void setCakeBuilder(CakeBuilder builder) {
        this.cake = builder;
    }

    public void createCake(String string) {

        cake.createCake();
        cake.addMessage(string);
        //update restantes características do bolo que dependerão do tipo de bolo escolhido
        cake.addCreamLayer();
        cake.addTopLayer();
        cake.addTopping();
    }

    public void createCake(Shape shape, int i, String string) {
        
        cake.createCake();
        cake.setCakeShape(shape);
        cake.getCake().setNumCakeLayers(i);
        cake.addMessage(string);
        //update restantes características do bolo
        cake.addCreamLayer();
        cake.addTopLayer();
        cake.addTopping();
    }

    public void createCake(int i, String string) {

        cake.createCake();
        cake.getCake().setNumCakeLayers(i);
        cake.addMessage(string);
        //update restantes características do bolo
        cake.addCreamLayer();
        cake.addTopLayer();
        cake.addTopping();

    }

    public Cake getCake() {
        return cake.getCake();
    }

    @Override
    public String toString() {
        return "CakeMaster [cake=" + cake + "]";
    }
}
