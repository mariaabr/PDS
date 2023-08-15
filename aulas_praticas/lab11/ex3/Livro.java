package lab11.ex3;

public class Livro {

    private String titulo;
    private int ISBN;
    private int ano;
    private String primeiro_autor;
    private State currentState;


    public Livro(int iSBN, String titulo, String primeiro_autor) {
        this.titulo = titulo;
        ISBN = iSBN;
        this.primeiro_autor = primeiro_autor;
        this.currentState = new Inventario();
    }

    public void setState(State s) {
        this.currentState = s;
    }

    public void regista(){
        currentState.regista(this);
    }

    public void requisita(){
        currentState.requisita(this);
    }

    public void devolve(){
        currentState.devolve(this);
    }

    public void cancelaReserva(){
        currentState.cancelaReserva(this);
    }

    public void reserva(){
        currentState.reserva(this);
    }

    @Override
    public String toString() {

        String livro = String.format("%-1d %-25s %-20s [%s]", ISBN, this.titulo, this.primeiro_autor, this.currentState);
        return livro;
    }
}
