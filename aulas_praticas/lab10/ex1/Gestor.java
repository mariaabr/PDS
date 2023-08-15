package ex1;

import java.util.*;

public class Gestor extends Observer {
    
    private ArrayList<Produto> produtos_em_stock;
    private ArrayList<Produto> produtos_vendidos; 

    public Gestor(String nome){
        super(nome);
        this.produtos_em_stock = new ArrayList<Produto>();
        this.produtos_vendidos = new ArrayList<Produto>();
    }

    public void receiveNotifys(Produto p){
        p.attach(this);
    }

    @Override
    public void update(Produto p, String s) {
        if (s.equals("nova licitação")){
            System.out.printf("Nova licitação ao produto %s com valor %f €.\n", p, p.getMaior_preco());
        }else{
            switch (p.getEstado()) {
                case stock:
                    this.produtos_em_leilao.remove(p);
                    this.produtos_em_stock.add(p);
                    System.out.printf("%s - O produto %s já não está disponível para leilão, está em stock.\n", this,p);
                    break;
                case leilao:
                    this.produtos_em_stock.remove(p);
                    this.produtos_em_leilao.add(p);
                    System.out.printf("O produto %s está agora disponível em leilão, com preço base: %f\n", p, p.getPreco_base());
                    break;
                case vendas:
                    this.produtos_em_leilao.remove(p);
                    this.produtos_vendidos.add(p);
                    System.out.printf("Produto %s vendido por %f €!\n", p, p.getMaior_preco());
                    break;
            }
        }

    }

    public void atualizarEstado(Produto p, Estado e) {
        p.setEstado(e);
    } 

    @Override
    public String toString() {
        return "[" + nome + "]";
    }
}
