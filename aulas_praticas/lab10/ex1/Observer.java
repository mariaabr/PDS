package ex1;

import java.util.*;

abstract class Observer {

   protected String nome;
   protected ArrayList<Produto> produtos_em_leilao = new ArrayList<Produto>(); 

   public Observer(String nome) {
      this.nome = nome;
      this.produtos_em_leilao = new ArrayList<Produto>(); 
   }

   public abstract void update(Produto p, String s);

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public ArrayList<Produto> getProdutos_em_leilao() {
      return produtos_em_leilao;
   }

   public void setProdutos_em_leilao(ArrayList<Produto> produtos_em_leilao) {
      this.produtos_em_leilao = produtos_em_leilao;
   }

}
