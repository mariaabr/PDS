package lab11.ex1;

public class Telemovel {
    
    private String marca;
    private String processador;
    private double preco;
    private String memoria;
    private String camara;


    public Telemovel(String marca, String processador, double preco, String memoria, String camara) {
        this.marca = marca;
        this.processador = processador;
        this.preco = preco;
        this.memoria = memoria;
        this.camara = camara;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getProcessador() {
        return processador;
    }


    public void setProcessador(String processador) {
        this.processador = processador;
    }


    public double getPreco() {
        return preco;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }


    public String getMemoria() {
        return memoria;
    }


    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }


    public String getCamara() {
        return camara;
    }


    public void setCamara(String camara) {
        this.camara = camara;
    }


    @Override
    public String toString() {
        return "Telemovel [marca=" + marca + ", processador=" + processador + ", preco=" + preco + ", memoria="
                + memoria + ", camara=" + camara + "]";
    }

}
