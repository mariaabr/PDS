//State

package lab11.ex3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        Livro[] livros = { new Livro(1,"Java Anti-Stress", "Omodionah"),
        new Livro(2,"A Guerra dos Padrões", "Jorge Omel"),
        new Livro(3,"A Procura da Luz", "Khumatkli")};

        while (true) {
            print(livros[0],livros[1],livros[2]);
            System.out.println(">> <livro>, <operação>: (1) regista; (2) requisita; (3) devolve; (4) reserva; (5) cancelar reserva\n");
            System.out.printf(">> ");
            Scanner scan = new Scanner(System.in);
            try{
                String[] input = scan.nextLine().split(",");
                int escolha_livro = Integer.parseInt(input[0]);
                int operacao = Integer.parseInt(input[1]);
                Livro livro = livros[escolha_livro-1];

                switch (operacao) {
                    case 1:
                        livro.regista();
                        break;
                    case 2:
                        livro.requisita();
                        break;
                    case 3:
                        livro.devolve();
                        break;
                    case 4:
                        livro.reserva();
                        break;
                    case 5:
                        livro.cancelaReserva();
                        break;
                }
            }
            catch (NumberFormatException e){
                System.err.println("\nErro: Formato incorreto! Exemplo de formato correto:\n>>1,1\n");
                continue;
            }
        }
        
    }

    public static void print(Livro livro1, Livro livro2, Livro livro3){
            System.out.println("*Biblioteca*");
            System.out.println(livro1);
            System.out.println(livro2);
            System.out.println(livro3);
    }
    
}
