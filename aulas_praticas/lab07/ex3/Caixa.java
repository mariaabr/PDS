import java.util.*;

public class Caixa extends Produtos{
    
    List<Produtos> lista_produtos = new ArrayList<>();
    String name;
    double weight, totalweight;

    public Caixa(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    public void add(Produtos p){
        lista_produtos.add(p);
    }

    public double getweight(){

        this.totalweight = this.weight;

        for(Produtos p : lista_produtos){
            this.totalweight += p.getweight();
        }

        return this.totalweight;
    }

    public void draw(){
        String output = "* Caixa '" + name + "' [ Weight: " + weight + " ; Total: " + totalweight + " ]";
        System.out.println(indent.toString() + output);

        indent.append("   ");

        for(Produtos p : lista_produtos){
            p.draw();
        }

        indent.setLength(indent.length() - 3);
    }
}
