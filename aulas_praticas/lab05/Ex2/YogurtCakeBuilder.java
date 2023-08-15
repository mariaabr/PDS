package Ex2;

public class YogurtCakeBuilder implements CakeBuilder {

    private Cake cake;

    public void setCakeShape(Shape shape) {
        this.cake.setShape(shape);
    }

    public void addCakeLayer(){
        this.cake.getNumCakeLayers();
    }

    public void addCreamLayer(){
        this.cake.setMidLayerCream(Cream.Vanilla);
    }

    public void addTopLayer() {
        this.cake.setTopLayerCream(Cream.Red_Berries);
    }

    public void addTopping() {
        this.cake.setTopping(Topping.Chocolate);
    }

    public void addMessage(String m) {
        this.cake.setMessage(m);
    }

    public void createCake(){
        this.cake = new Cake("Yogurt");
    }

    public Cake getCake() {
        return cake;
    }
    
}
