public class Bebida extends Produtos{

    String name;
    double weight, totalweight;

    public Bebida(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double getweight(){
        return this.weight;
    }

    @Override
    public void draw(){
        String output = "Bedida '" + name + "' - Weight: " + weight;
        System.out.println(indent.toString() + output);
    }
}
