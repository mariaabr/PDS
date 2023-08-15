package Ex2;

public class Cake {

    private Shape shape = Shape.Circle;
    private String cakeLayer;
    private int numCakeLayers = 1;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    //métodos get and set para atualizar e ir buscar informação
    public Cake(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumCakeLayers() {
        return numCakeLayers;
    }

    public String getCakeLayer() {
        return cakeLayer;
    }

    public Cream getMidLayerCream() {
        return midLayerCream;
    }

    public Cream getTopLayerCream() {
        return topLayerCream;
    }

    public Topping getTopping() {
        return topping;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        
        //string builder para construir o output consoante as características do bolo
        StringBuilder output = new StringBuilder();

        output.append(cakeLayer + " with " + numCakeLayers + " layers");
        if (midLayerCream != null) {
            output.append(" and " + midLayerCream + " cream");
        }
        if (topLayerCream != null) {
            output.append(", topped with " + topLayerCream + " cream");
        }
        if (topping != null) {
            output.append(" and " + topping);
        }
        if (message != null) {
            output.append(". Message says: " + message + ".");
        }

        return output.toString();
    }

}
