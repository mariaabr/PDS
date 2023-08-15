package ex1;

public class Cliente extends Observer{

    public Cliente(String nome){
        super(nome);
    }

    public void receiveNotifys(Produto p){
        p.attach(this);
    }

    @Override
    public void update(Produto p, String s) {
        if (s.equals("nova licitação")){
            System.out.printf("Nova licitação ao produto %s pelo cliente %s com valor %f €.\n", p,this, p.getMaior_preco());
        }else{
            switch (p.getEstado()) {
                case stock:
                    this.produtos_em_leilao.remove(p);
                    System.out.printf("O produto %s já não está disponível para leilão.\n", p);
                    break;
                case leilao:
                    this.produtos_em_leilao.add(p);
                    System.out.printf("O produto %s está disponível em leilão, com preço base: %f\n", p, p.getPreco_base());
                    break;
                case vendas:
                    this.produtos_em_leilao.remove(p);
                    System.out.printf("O produto %s foi vendido ao cliente %s por %f.\n", p, this,p.getMaior_preco());
                    break;
            }
        }

    }

    public void licitar(Produto p, double preco){
        if (!produtos_em_leilao.contains(p)){
            System.out.printf("O produto %s não está disponível para leilão.\n",p);
        } else{
            if(preco < p.getMaior_preco()){
                System.out.printf("Há uma licitação maior que a sua com o valor de %f €\n", p.getMaior_preco());
            } else{
                System.out.printf("Fez uma nova licitação:\n", preco);
                p.setMaior_preco(preco);
            }
        }

    }

    @Override
    public String toString() {
        return "[" + nome + "]";
    }

    
}
