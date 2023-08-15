package Ex2;

public class SpongeCakeBuilder implements CakeBuilder{
    
    private Cake cake;

    public void setCakeShape(Shape shape) {
        this.cake.setShape(shape);
    }

    public void addCakeLayer(){
        this.cake.getNumCakeLayers();
    }

    public void addCreamLayer(){
        this.cake.setMidLayerCream(Cream.Red_Berries);
    }

    public void addTopLayer() {
        this.cake.setTopLayerCream(Cream.Whipped_Cream);
    }

    public void addTopping() {
        this.cake.setTopping(Topping.Fruit);
    }

    public void addMessage(String m) {
        this.cake.setMessage(m);
    }

    public void createCake(){
        this.cake = new Cake("Sponge");
    }

    public Cake getCake() {
        return cake;
    }
    
}
