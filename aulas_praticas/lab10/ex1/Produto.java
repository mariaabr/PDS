package ex1;

import java.util.*;

public class Produto {
    
    private int codigo;
    private String descricao;
    private double preco_base;
    private double maior_preco;
    private List<Observer> observers = new ArrayList<>();
    private Estado estado;
    private int maxtimeleilao = 0;

    public Produto(int codigo, String descricao, double preco_base) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco_base = preco_base;
        this.estado = Estado.stock;
        this.maxtimeleilao = 0;
    }

    public void attach(Observer o){
        observers.add(o);
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_base() {
        return preco_base;
    }

    public void setPreco_base(double preco_base) {
        this.preco_base = preco_base;
    }

    public double getMaior_preco() {
        return maior_preco;
    }

    public void setMaior_preco(double maior_preco) {
        this.maior_preco = maior_preco;
        notifyObservers(this, "nova licitação");
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        notifyObservers(this, "só mudando o estado");
    }

    private void notifyObservers(Produto p,String s){
        for (Observer obs : observers){
            obs.update(this,s);
        }
    }

    @Override
    public String toString() {
        return "[codigo=" + codigo + ", descricao=" + descricao + "]";
    }
    
}
