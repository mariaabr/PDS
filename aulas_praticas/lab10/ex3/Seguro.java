package ex3;

public class Seguro {
    private String ramo;
    private String preco;

    public Seguro(String ramo, String preco){
        this.ramo = ramo;
        this.preco = preco;
    }


    public String getRamo() {
        return this.ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getPreco() {
        return this.preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
