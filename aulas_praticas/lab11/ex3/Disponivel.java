package lab11.ex3;

public class Disponivel implements State {

	@Override
	public void regista(Livro livro) {
		System.out.println("Erro! Apenas pode requisitar ou reservar...\n");
	}

	@Override
	public void requisita(Livro livro) {
		livro.setState(new Emprestado());
        System.out.println("Livro emprestado :)\n");
	}

	@Override
	public void devolve(Livro livro) {
		System.out.println("Erro! Apenas pode requisitar ou reservar...\n");
	}

	@Override
	public void cancelaReserva(Livro livro) {
		System.out.println("Erro! Apenas pode requisitar ou reservar...\n");
	}

	@Override
	public void reserva(Livro livro) {
        livro.setState(new Reservado());
        System.out.println("Livro reservado :)\n");
	}

	@Override
	public String toString() {
		return "Disponível";
	}
    
}
