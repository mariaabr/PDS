package lab03.gestor_aviao;

import java.util.*;
import java.io.*;

public class GestorAviao {
    private String option;
    private String[] args;
    private LinkedList<Voo> voos =  new LinkedList<Voo>();
    private int ReservationId = 1;


    public void menuStarter() throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        // repeat menu until quit (Q) (system.exit)
        while (true) {
            System.out.println("\nEscolha uma opçao (H para ajuda): ");
            String input = sc.nextLine();
            args = input.split(" ");
            option = args[0];
            menu(option);
            }
    }
    
    public void menuStarter(String line) throws FileNotFoundException{
            args = line.split(" ");
            option = args[0];
            menu(option);
    }
    

    public void menu(String option) throws FileNotFoundException {
        option = option.toUpperCase();

        switch (option) {
            //sair
            case "Q":
                System.out.println("Saíndo do programa...");
                System.exit(0);
                break;


            //ajuda
            case "H":
                helpMenu();
                break;


            // le o ficheiro com informacao sobre um voo
            case "I":
                if (args.length != 2)
                    invalidOption();
                
                try{
                    File file = new File(args[1]);
                    Scanner fileScanner = new Scanner(file);
                    checkFlightFile(fileScanner);

                }catch (FileNotFoundException e){
                    System.out.print("Nao foi possível encontrar o ficheiro. Por favor tente com um ficheiro diferente ou mova o ficheiro para a pasta raíz");
                    System.exit(1);
                }
                break;
            

            //mapa
            case "M":
                if (args.length != 2) 
                    invalidOption();

                checkVoo(args[1]);
                printMapa(args[1]);
                break;
            

            //adiciona voo
            case "F":

                //flight_code num_seats_tourist
                if (args.length == 3)
                    novoVoo(args[1],args[2]); 

                //flight_code num_seats_executive num_seats_tourist
                else if(args.length == 4)
                    novoVoo(args[1],args[2],args[3]); 

                else 
                    invalidOption();

                break;
            
            //nova reserva
            case "R":

                if (args.length != 4) 
                    invalidOption();

                addReserva(args[1], args[2], args[3]);
                break;
            
            //cancela uma reserva
            case "C":

                if (args.length != 2)
                    invalidOption();

                cancelarReserva(args[1]);

                break;

            default:
                invalidOption();
        }
    }


    public void helpMenu() {
        System.out.print("\nOpções disponíveis:\n"
                            + "H - apresenta as opções do menu. (current page)\n"
                            + "I [FILENAME] - lê um ficheiro com informação sobre um voo.\n"
                            + "M [FLIGHT CODE] - exibe o mapa de reservas de um voo.\n"
                            + "F [FLIGHT CODE] [NUM SEATS EXECUTIVE](optional) [NUM SEATS TOURIST] - acrescenta um novo voo com codigo, lugares em executiva e lugares em turística\n"
                            + "R [FLIGHT CODE] [CLASS] [NUMBER SEATS] - acrescenta uma nova reserva a um voo (com código), da classe (T/E) e o número de lúgares\n"
                            + "C [RESERVATION CODE] - cancela uma reserva\n"
                            + "Q - termina o programa\n");
    }

    private void invalidOption() throws FileNotFoundException {

            System.out.println("Ocurreu um erro com a opçao selecionada, por favor selecione a opçao H de modo a ver o formato correto da opçao pretendida");
            menuStarter();
        }


    public boolean checkFlightFile(Scanner fileScanner){
       
            String linha = fileScanner.nextLine();

            String[] firstLine = linha.split(" ");

            if (!(firstLine[0].charAt(0) == '>')){
                System.out.print("Ficheiro inválido. Certifique-se que o ficheiro comece com '>[CÓDIGO DE VOO]'");
                System.exit(1);
            }

            Voo voo;
            String vooId = firstLine[0].substring(1);

            if (firstLine.length == 2) 
                voo = new Voo(vooId, firstLine[1]);

            else 
                voo = new Voo(vooId, firstLine[1], firstLine[2]);

            // print voo info
            System.out.print(voo.toString());

            // adiciona voo a lista
            while (fileScanner.hasNextLine()){
                String vooSeatsLinha = fileScanner.nextLine();
                String[] info = vooSeatsLinha.split(" ");
                Reserva reserva = new Reserva(ReservationId,info[0],Integer.parseInt(info[1]));
                ReservationId++;
                voo.addReservasFile(reserva);
            }
        
            voos.add(voo);
            
            fileScanner.close();

        return true;
    }
    
    public void printMapa(String id){

        checkVoo(id).mapaVoo();
    }

    public void novoVoo(String name, String tur){

        Voo voo = new Voo(name, tur);
        voos.add(voo);
    }
    public void novoVoo(String name, String exec, String tur){

        Voo voo = new Voo(name, exec, tur);
        voos.add(voo);
    }
    
    private Voo checkVoo(String id){

            for(int i = 0; i < voos.size(); i++){

                if(id.equals(voos.get(i).getId())){
                    return voos.get(i);
                }
            }
            System.out.println("Voo nao encontrado. Por favor verifique o código do voo que pretende ver.");
            System.exit(1);
            return null;
        }


    public void addReserva(String idVoo, String classe, String nlugares){

        Reserva reserva = new Reserva(ReservationId,classe, Integer.parseInt(nlugares));
        ReservationId++;
        checkVoo(idVoo).addReserva(reserva);
    }

   

    public void cancelarReserva(String input){

        String[] str = input.split(":");
        String idVoo = str[0];
        String idReserva = str[1];
        checkVoo(idVoo).cancelaReserva(Integer.parseInt(idReserva));
    }


   

 
}
