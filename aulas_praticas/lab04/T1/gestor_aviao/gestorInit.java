package lab03.gestor_aviao;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class gestorInit {
    public static void main(String[] args) throws FileNotFoundException{
        GestorAviao gestor = new GestorAviao(); 

        if (args.length == 1) {
            String filename = args[0];
            File file = new File(filename);
            Scanner scanner;

            try {
                scanner = new Scanner(file);

            } catch (FileNotFoundException e) {
                System.out.println("Nao foi possivel encontrar o ficheiro de comandos. Por favor tente com um ficheiro diferente ou mova o ficheiro para a pasta raíz  ");
                System.exit(1);
                return;
            }

            while (scanner.hasNextLine()) {
                System.out.println();
                String linha = scanner.nextLine();
                gestor.menuStarter(linha);
                System.out.println();
            }

            scanner.close();
        
        }
        else if (args.length == 0){
            gestor.menuStarter();
        }
        else{
            System.out.println("USO: java gestorInit // java gestorInit [FICHEIRO DE COMANDOS]");
            System.exit(1);
        }
}
}