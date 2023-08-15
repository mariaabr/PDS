public class Conserva extends Produtos{
    
    String name;
    double weight, totalweight;

    public Conserva(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double getweight(){
        return this.weight;
    }

    @Override
    public void draw(){
        String output = "Conserva '" + name + "' - Weight: " + weight;
        System.out.println(indent.toString() + output);
    }
}
