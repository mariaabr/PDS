package lab11.ex3;

public class Emprestado implements State{

	@Override
	public void regista(Livro livro) {
		System.out.println("Erro! Apenas pode devolver...\n");
	}

	@Override
	public void requisita(Livro livro) {
		System.out.println("Erro! Apenas pode devolver...\n");
	}

	@Override
	public void devolve(Livro livro) {
        livro.setState(new Disponivel());
        System.out.println("Livro disponível :)\n");
	}

	@Override
	public void cancelaReserva(Livro livro) {
		System.out.println("Erro! Apenas pode devolver...\n");
	}

	@Override
	public void reserva(Livro livro) {
		System.out.println("Erro! Apenas pode devolver...\n");
	}

	@Override
	public String toString() {
		return "Emprestado";
	}
    
}
