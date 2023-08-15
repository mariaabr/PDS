package Ex2;

public class ChocolateCakeBuilder implements CakeBuilder {

    private Cake cake;

    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    public void addCakeLayer(){
        cake.getNumCakeLayers();
    }

    public void addCreamLayer(){
        this.cake.setMidLayerCream(null);
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
        if (cake == null){
            cake = new Cake("Soft chocolate");
        }
    }

    public Cake getCake() {
        return cake;
    }
    
}
