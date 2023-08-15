package lab03;

import java.util.*;
import java.io.*;

public class Ex2 {

    public static void main(String[] args) {

        ArrayList<Voo> voos = new ArrayList<Voo>();
        HashMap<String, ArrayList<Reserva>> reservasMap = new HashMap<>();
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        // ArrayList<String> lines_reservas = new ArrayList<>();

        if (args.length == 0) { // se nenhum argumento for passado

            options(voos, reservas, reservasMap);

        } else if (args.length == 1) { // se for passado um ficheiro com commandos como argumento

            try {

                Scanner file = new Scanner(new File(args[0]));

                while (file.hasNext()) {
                    String option[] = file.nextLine().split(" ");
                    tratamento_options(option, voos, reservas, reservasMap);
                }

            } catch (FileNotFoundException e) {
                System.err.println("Ocorreu um erro ao ler o ficheiro!");
                System.exit(0);
            }

        } else {
            System.err.println("Número incorreto de argumentos! Aceita um ficheiro de comandos ou nenhum argumento!");
            System.exit(0);
        }

    }

    // mostra as opções possíveis
    public static void options(ArrayList<Voo> voos, ArrayList<Reserva> reservas, HashMap<String, ArrayList<Reserva>> reservasMap) {

        boolean quit = true;
        Scanner input = new Scanner(System.in);

        while (quit) {
            System.out.println("\nEscolha uma opção (H para ajuda):");
            String options[] = input.nextLine().split(" "); // guardar num array de strings o input para poder tratar a opção escolhida
            tratamento_options(options, voos, reservas, reservasMap); // a opção escolhida que será o elemento no indice 0
        }

        input.close();
    }

    // tratamento de opções
    public static ArrayList<Voo> tratamento_options(String[] options, ArrayList<Voo> voos, ArrayList<Reserva> reservas, HashMap<String, ArrayList<Reserva>> reservasMap) {
        ArrayList<String> lines_reservas = new ArrayList<>();

        switch (options[0].toUpperCase()) {
            case "H":
                usage();
                break;

            case "I":

                if (options.length != 2) {
                    System.err.println("Número incorreto de argumentos!");
                } else{
                    try {
                        Scanner info_voo = new Scanner(new File("lab03/" + options[1])); // ler o ficheiro passado a seguir à opção I
                        Voo new_voo = readFile(info_voo, lines_reservas, reservas, reservasMap);
                        voos.add(new_voo);
    
                    } catch (FileNotFoundException e) {
                        System.err.println("\nOcorreu um erro ao ler o ficheiro!");
                        System.exit(0);
                    }
                }

            case "M":

                if (options.length != 2) {
                    System.err.println("Número incorreto de argumentos!");
                } else {
                    String codigo_voo = options[1];
                    int contador = 0; //vai permitir verificar se o codigo passado como argumento existe ou nao

                    for(Voo voo : voos) { //percorre todo o arraylist de voos
                        contador++;
                        System.out.println(voo);
                        if (voo.getCodigo_voo().equals(codigo_voo)) { //se encontrar o codigo de voo passado como argumento chama a função printMap
                            // System.out.println("ola1");
                            printMapreservas(voo, reservas, reservasMap); 
                        } 
                        if (contador + 1 == voos.size()) { // já não há mais voos na lista de voos, ou seja, o voo não existe
                            System.err.println("Código de voo inexistente");
                        }
                    }
                }
                break;

            case "F":
                
                if(options.length == 4){

                    String codigo_voo = options[1]; //primeiro argumento a seguir à opção corresponde ao codigo de voo
                    String[] lugares_exec = options[2].split("x"); //separar o terceiro argumento pelo x 
                    String[] lugares_tur = options[3].split("x"); //separar o quarto argumento pelo x 

                    for (Voo voo : voos){
                        if(voo.getCodigo_voo().equals(codigo_voo)){ //caso o código de voo pertença a algum voo já existente
                            System.err.println("Código de voo já existente!");
                        }else{
                           // criar novo voo consoante o construtor
                        Voo new_voo = new Voo(codigo_voo, Integer.parseInt(lugares_tur[0]),
                           Integer.parseInt(lugares_tur[1]), Integer.parseInt(lugares_exec[0]),
                           Integer.parseInt(lugares_exec[1]));
                        voos.add(new_voo); // adicionar ao array de voos
                        }
                    }
                    if(voos.size() == 0){ // caso a lista de voos esteja vazia, o programa não entra no ciclo for anterior
                        Voo new_voo = new Voo(codigo_voo, Integer.parseInt(lugares_tur[0]),
                                Integer.parseInt(lugares_tur[1]), Integer.parseInt(lugares_exec[0]),
                                Integer.parseInt(lugares_exec[1]));
                        System.out.print(new_voo);
                        voos.add(new_voo); // adicionar ao array de voos 
                    }

                } else if (options.length == 3){

                    String codigo_voo = options[1];
                    String[] lugares_tur = options[2].split("x");

                    for (Voo voo : voos){
                        if(voo.getCodigo_voo().equals(codigo_voo)){
                            System.err.println("Código de voo já existente!");
                        }else{
                           // criar novo voo consoante o construtor
                        Voo new_voo = new Voo(codigo_voo, Integer.parseInt(lugares_tur[0]),
                                Integer.parseInt(lugares_tur[1]));
                        System.out.print(new_voo);
                        voos.add(new_voo); // adicionar ao array de voos 
                        }
                    }
                    if(voos.size() == 0){
                        Voo new_voo = new Voo(codigo_voo, Integer.parseInt(lugares_tur[0]),
                                Integer.parseInt(lugares_tur[1]));
                        System.out.print(new_voo);
                        voos.add(new_voo); // adicionar ao array de voos 
                    }

                } else {
                    System.err.println("Número incorreto de argumentos!");
                }

                break;
            case "R":

                if (options.length != 4) {
                    System.err.println("Número incorreto de argumentos!");
                } else {

                    String codigo_voo = options[1];
                    System.out.println(codigo_voo);
                    char classe = options[2].charAt(0);
                    int lugares_desejados = Integer.parseInt(options[3]);
                    int contador = 0;

                    for (Voo voo : voos) {
                        contador++;
                        if (voo.getCodigo_voo().equals(codigo_voo)) {
                            voo.nova_reserva(classe, lugares_desejados);
                        }
                        if (contador + 1 == voos.size()) {
                            System.err.println("Código de voo inexistente");
                        }
                    }
                }
                break;

            case "C":
                break;
            case "Q":
                System.out.println("Até à próxima!");
                System.exit(0);
                break;
            default:
                break;
        }
        return voos;
    }

    // menu de opções possíveis
    public static void usage() {

        System.out.println("----------------------------------------Usage----------------------------------------");
        System.out.println("'I <filename>' : Lê um ficheio de texto contendo informação sobre um voo.");
        System.out.println("'M <flight_code>' : Exibe o mapa de reservas de um voo.");
        System.out.println("'F <flight_code> <num_seats_executive> <num_seats_tourist>' : Acrescenta um novo voo.");
        System.out.println("'R <flight_code> <class> <num_seats>' : Acrescenta uma nova reserva de voo.");
        System.out.println("'C <reservation_code>' : Cancela uma reserva.");
        System.out.println("'Q' : Termina o programa.\n");

    }

    public static Voo readFile(Scanner info_voo, ArrayList<String> lines_reservas, ArrayList<Reserva> reservas, HashMap<String, ArrayList<Reserva>> reservasMap) {
        String[] infos = new String[3];
        int lugaresT_total = 0;
        int lugaresE_total = 0;
        int lugaresT_sum = 0;
        int lugaresE_sum = 0;
        Voo voo = null;
        int reserva_id = 1;

        while (info_voo.hasNextLine()) {
            String line = info_voo.nextLine();

            if (line.startsWith(">")) { // primeira linha que contém as informações

                infos = line.split(" "); // primeira linha num array de strings para manipular as informaçõees

                String codigo_voo = infos[0].substring(1, infos[0].length()); // código de voo sem o ">"

                if (infos.length == 3) { // se existirem classe executiva e turística
                    String[] exec = infos[1].split("x"); // para buscar o numero de lugares de uma classe
                    String[] tur = infos[2].split("x");

                    int filasT_num = Integer.parseInt(tur[0]);
                    int lugares_filaT_num = Integer.parseInt(tur[1]);
                    int filasE_num = Integer.parseInt(exec[0]);
                    int lugares_filaE_num = Integer.parseInt(exec[1]);

                    voo = new Voo(codigo_voo, filasT_num, lugares_filaT_num, filasE_num, lugares_filaE_num);
                    lugaresT_total = voo.getFilasT_num() * voo.getLugares_filaT_num();
                    lugaresE_total = voo.getFilasE_num() * voo.getLugares_filaE_num();

                    System.out.printf("\n" + "Código de voo %s. Lugares disponíveis: %d lugares em Classe Executiva; %d lugares em Classe Turística. \n",
                    voo.getCodigo_voo(), lugaresT_total, lugaresE_total);

                } else if (infos.length == 2) { // se só existir classe turística
                    String[] tur = infos[1].split("x");

                    int filasT_num = Integer.parseInt(tur[0]);
                    int lugares_filaT_num = Integer.parseInt(tur[1]);

                    voo = new Voo(codigo_voo, filasT_num, lugares_filaT_num);

                    lugaresT_total = voo.getFilasT_num() * voo.getLugares_filaT_num();

                    System.out.printf("\nCódigo de voo %s. Lugares disponíveis: %d lugares em Classe Turística.\n",
                            codigo_voo, lugaresT_total);
                    System.out.println("\nClasse Executiva não disponível neste voo.");

                } else {
                    System.out.println("\nSomething is not right with this file, try another one!\n");
                }

            } else {
                
                lines_reservas.add(line);
                // Reserva.listreservas(lines_reservas);
                String[] line_reservas = line.split(" ");
                // System.out.println(line_reservas.toString());
                char classe = line_reservas[0].charAt(0);
                // System.out.println(classe);
                int passengers_num = Integer.parseInt(line_reservas[1]);
                // System.out.println(line_reservas[1]);

                if (infos.length == 2) {
                    if (classe == 'E') {
                        lines_reservas.remove(line);
                        reserva_id--;
                        System.out.printf("\nNão foi possível obter lugares para a reserva: %s\n", line);
                    }
                } else {
                    if (classe == 'T') {
                        lugaresT_sum += passengers_num;
                        if (lugaresT_sum > lugaresT_total) {
                            lugaresT_sum -= passengers_num;
                            lines_reservas.remove(line);
                            reserva_id--;
                            System.out.printf("\nNão foi possível obter lugares para a reserva: %s\n", line);
                        }
                    }

                    if (classe == 'E') {
                        lugaresE_sum += passengers_num;
                        if (lugaresE_sum > lugaresE_total) {
                            // System.out.println(lugaresE_sum);
                            lugaresE_sum -= passengers_num;
                            lines_reservas.remove(line);
                            reserva_id--;
                            System.out.printf("\nNão foi possível obter lugares para a reserva: %s\n", line);
                        }
                    }
                }
                
                System.out.printf("Reserva %d: %s\n", reserva_id, line);
                
                Reserva reserva = new Reserva(voo.getCodigo_voo(), classe, passengers_num, reserva_id);
                reservas.add(reserva);
                reserva_id++;
            }
        }

        reservasMap.put(voo.getCodigo_voo(), reservas);
        return voo;
    }

    public static void printMapreservas(Voo voo, ArrayList<Reserva> reservas, HashMap<String, ArrayList<Reserva>> reservasMap){
        int lugaresT_total = voo.getFilasT_num() * voo.getLugares_filaT_num();
        int lugaresE_total = voo.getFilasE_num() * voo.getLugares_filaE_num();;
        int lugaresTuristica[][] = new int[voo.getFilasT_num()][voo.getLugares_filaT_num()];
        int lugaresExecutiva[][] = new int[voo.getFilasE_num()][voo.getLugares_filaE_num()];
        int num_filas_total = voo.getFilasE_num() + voo.getFilasT_num();
        int max;

        // char classe = reserva.getClasse();
        // int passengers_num = reserva.getPassengers_num();
        
        // linha das filas do aviao: executiva + turistica
        System.out.printf("    ");
        // System.out.println("hello");
        for(int i = 1; i <= num_filas_total; i++){
            System.out.printf("%2d ", i);
        }

        if(voo.getLugares_filaT_num() >= voo.getLugares_filaE_num()){
            max = voo.getLugares_filaT_num();
        } else {
            max = voo.getLugares_filaE_num();
        }

        for(int i = 0; i < max; i++){

            int letter_fila_num = 65 + i; // 'A' ascii
            char letter_fila = (char) letter_fila_num;
            System.out.printf("\n%c   ", letter_fila);

            for(int j = 0; j < voo.getFilasE_num(); j++){
                if (i < voo.getLugares_filaE_num()) {
                    System.out.format("%2d ", lugaresExecutiva[j][i]);
                    
                    
                } else if (i >= voo.getLugares_filaE_num()){
                    System.out.format("   ");
                }
            }

            for(int n = 0; n < voo.getFilasT_num(); n++){
                System.out.format("%2d ", lugaresTuristica[n][i]); 
            }

        }
    }
}