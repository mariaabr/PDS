public class Doce extends Produtos {
    
    String name;
    double weight, totalweight;

    public Doce(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double getweight(){
        return this.weight;
    }

    @Override
    public void draw(){
        String output = "Doce '" + name + "' - Weight: " + weight;
        System.out.println(indent.toString() + output);
    }
}
