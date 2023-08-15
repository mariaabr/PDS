package lab11.ex3;

public class Inventario implements State{

	@Override
	public void regista(Livro livro) {
		livro.setState(new Disponivel());
        System.out.println("Livro disponível :)\n");
	}

	@Override
	public void requisita(Livro livro) {
		System.out.println("Erro! Apenas pode registar...\n");
    }

	@Override
	public void devolve(Livro livro) {
		System.out.println("Erro! Apenas pode registar...\n");
	}

	@Override
	public void cancelaReserva(Livro livro) {
		System.out.println("Erro! Apenas pode registar...\n");
	}

	@Override
	public void reserva(Livro livro) {
        System.out.println("Erro! Apenas pode registar...\n");
	}

	@Override
	public String toString() {
		return "Inventário";
	}
    
}
