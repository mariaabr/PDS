package ex3;

public class Cliente{
    private String nome;
    private String email;

    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void receiveMail(String seguradora_nome, Seguro seguro, String mail){
        System.out.println("Caixa de entrada de " + this.email + ":");
        System.out.println("    >> Senhor(a) " + this.nome + ", \n" + "       foi efetuado o seguro " + seguro.getRamo() + " por " + seguro.getPreco() + "€ por mês.");
        System.out.println(mail);
        System.out.println("Agradecemos a confiança,\n" + seguradora_nome + ".");
        System.out.println("----------------------------------------------------");
        // System.out.println("    >> Segue em anexo o comprovativo do seguro efetuado.");
    }
}
