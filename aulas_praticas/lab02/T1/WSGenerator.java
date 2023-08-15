//lab01

//Grupo 09
//P2

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WSGenerator {

    static void puttingpoints(char[][] letters) {                   //por pontos na matriz para mais facil compreensão dos espaços
        for (int row = 0; row < letters.length; row++) {
            for (int col = 0; col < letters.length; col++) {
                letters[row][col] = '.';
            }
        }
    }

    static void toU(String[] wordes) {                              //por em CapsLocks
        for (int p = 0; p < wordes.length; p++) {
            wordes[p] = wordes[p].toUpperCase();
        }
    }

    private static char randomChar() {                              //random chars para a matrix
        Random r = new Random();
        return (char) (r.nextInt(26) + 'A');
    }

    public static void main(String args[]) throws IOException {

        if (args.length == 0) {                                        // verificação se existem argumentos
            System.out.println("Error: no arguments");
            System.exit(0);
        }

        String f = " ";                                                 //inicialização de strings
        int Matrix = 0;
        String fi = " ";

        for (int a = 0; a < args.length; a++) {                         //leitura de argumentos 
            if (args[a].equals("-i")) {
                f = args[a + 1];

            }

            if (args[a].equals("-s")) {
                Matrix = Integer.parseInt(args[a + 1]);
            }

            if (args[a].equals("-o")) {
                fi = args[a + 1];
            }
        }

        char[][] letters = new char[Matrix][Matrix];                    //criação da matriz 

        puttingpoints(letters);                                         //chamda função

        Path path = Paths.get(f);

        List<String> lines = Files.readAllLines(path);                  //ler ficheiro de input
        List<String> words = new ArrayList<>();                         //criação de arraylist para leitura de linhas do ficheiro

        for (String line : lines) {                                     //leitura das linhas do ficheiro 
            String[] lineWords = line.split("[,;\\s]+");
            for (String word : lineWords) {                             // leitura palavras a serem gereadas
                if (word.length() > Matrix) {
                    System.out.print(" \n Error! Wrong Soup size. \n");
                    System.exit(0);
                }
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }

        String[] wordes = new String[words.size()];                        //criação de um array de Strings para melhor manipulação   
        int n = 0;
        for (String word : words) {
            wordes[n] = word;
            n++;
        }

        toU(wordes);                                                        //uppercase
        
        int siz = 0;                                                        //size da palavra
        boolean wo = false;                                                 //boolean para se a palavra foi criada dentro da matriz
        boolean possible = true;                                            //boolean para se é possivel criar palavra na sopa e não passar por cima de nenhuma outra palavra



        for (int p = 0; p < wordes.length; p++) {                           //percorrer palavras
            int randomsearch = (int) Math.floor(Math.random() * (8 - 1 + 1) + 1);           //escolhe qual vai ser a direção da palavra dentro da sopa
            while (wo == false) {                                                           //enquanto a palavra nao for completada
                int randomrow = (int) Math.floor(Math.random() * ((Matrix - 1) - 0 + 1) + 0);           //random row
                int randomcol = (int) Math.floor(Math.random() * ((Matrix - 1) - 0 + 1) + 0);           //random col
                switch (randomsearch) {         
                    // create right
                    case 1:                                                                              //verifica length da matriz em comparação com a palavra em questão e o sitio onde é inicializada
                        if (randomcol + wordes[p].length() <= letters.length) {
                            for (int passo = 0; passo < wordes[p].length(); passo++) {                      //verificação se pode ser construida ou não 
                                if (letters[randomrow][randomcol + passo] >= 'A'
                                        && letters[randomrow][randomcol + passo] <= 'Z') {
                                    possible = false;
                                    break;
                                }
                            }
                            if (possible == true) {                                                           //caso seja possivel , esta é construida
                                for (int next = 0; next < wordes[p].length(); next++) {
                                    letters[randomrow][randomcol + next] = wordes[p].charAt(next);
                                    siz += 1;
                                }
                                if (wordes[p].length() == siz) {
                                    wo = true;
                                }
                            } else
                                break;
                        } else
                            break;
                        break;
                    // create left
                    case 2:
                        if (randomcol - wordes[p].length() + 1 >= 0) {
                            for (int passo = 0; passo < wordes[p].length(); passo++) {
                                if (letters[randomrow][randomcol - passo] >= 'A'
                                        && letters[randomrow][randomcol - passo] <= 'Z') {
                                    possible = false;
                                    break;
                                }
                            }
                            if (possible == true) {
                                for (int next = 0; next < wordes[p].length(); next++) {
                                    letters[randomrow][randomcol - next] = wordes[p].charAt(next);
                                    siz += 1;
                                }
                                if (wordes[p].length() == siz) {
                                    wo = true;
                                }
                            } else
                                break;
                        } else
                            break;
                        break;
                    // create up
                    case 3:
                        if (randomrow - wordes[p].length() + 1 >= 0) {
                            for (int passo = 0; passo < wordes[p].length(); passo++) {
                                if (letters[randomrow - passo][randomcol] >= 'A'
                                        && letters[randomrow - passo][randomcol] <= 'Z') {
                                    possible = false;
                                    break;
                                }
                            }
                            for (int next = 0; next < wordes[p].length(); next++) {
                                letters[randomrow - next][randomcol] = wordes[p].charAt(next);
                                siz += 1;
                            }

                            if (wordes[p].length() == siz) {
                                wo = true;
                            }
                        } else
                            break;
                        break;
                    // create down
                    case 4:
                        if (randomrow + wordes[p].length() <= letters.length) {
                            for (int passo = 0; passo < wordes[p].length(); passo++) {
                                if (letters[randomrow + passo][randomcol] >= 'A'
                                        && letters[randomrow + passo][randomcol] <= 'Z') {
                                    possible = false;
                                    break;
                                }
                            }
                            if (possible == true) {
                                for (int next = 0; next < wordes[p].length(); next++) {
                                    letters[randomrow + next][randomcol] = wordes[p].charAt(next);
                                    siz += 1;
                                }

                                if (wordes[p].length() == siz) {
                                    wo = true;
                                }
                            } else
                                break;
                        } else
                            break;
                        break;

                    // create upleft
                    case 5:
                        if (randomrow - wordes[p].length() + 1 >= 0 && randomcol - wordes[p].length() + 1 >= 0) {
                            for (int passo = 0; passo < wordes[p].length(); passo++) {
                                if (letters[randomrow - passo][randomcol - passo] >= 'A'
                                        && letters[randomrow - passo][randomcol - passo] <= 'Z') {
                                    possible = false;
                                    break;
                                }
                            }
                            if (possible == true) {
                                for (int next = 0; next < wordes[p].length(); next++) {
                                    letters[randomrow - next][randomcol - next] = wordes[p].charAt(next);
                                    siz += 1;
                                }

                                if (wordes[p].length() == siz) {
                                    wo = true;
                                }
                            } else
                                break;
                        } else
                            break;
                        break;

                    // create upright
                    case 6:
                        if ((randomrow - wordes[p].length() + 1 >= 0)
                                && (randomcol + wordes[p].length() <= letters.length)) {
                            for (int passo = 0; passo < wordes[p].length(); passo++) {
                                if (letters[randomrow - passo][randomcol + passo] >= 'A'
                                        && letters[randomrow - passo][randomcol + passo] <= 'Z') {
                                    possible = false;
                                    break;
                                }
                            }
                            if (possible == true) {
                                for (int next = 0; next < wordes[p].length(); next++) {
                                    letters[randomrow - next][randomcol + next] = wordes[p].charAt(next);
                                    siz += 1;
                                }

                                if (wordes[p].length() == siz) {
                                    wo = true;
                                }
                            } else
                                break;
                        } else
                            break;
                        break;

                    // create downleft
                    case 7:
                        if (randomrow + wordes[p].length() <= letters.length
                                && (randomcol - wordes[p].length() + 1 >= 0)) {
                            for (int passo = 0; passo < wordes[p].length(); passo++) {
                                if (letters[randomrow + passo][randomcol - passo] >= 'A'
                                        && letters[randomrow + passo][randomcol - passo] <= 'Z') {
                                    possible = false;
                                    break;
                                }
                            }
                            if (possible == true) {
                                for (int next = 0; next < wordes[p].length(); next++) {
                                    letters[randomrow + next][randomcol - next] = wordes[p].charAt(next);
                                    siz += 1;
                                }

                                if (wordes[p].length() == siz) {
                                    wo = true;
                                }
                            } else
                                break;
                        } else
                            break;
                        break;

                    // create downright
                    case 8:
                        if ((randomcol + wordes[p].length() <= letters.length)
                                && (randomrow + wordes[p].length() <= letters.length)) {
                            for (int passo = 0; passo < wordes[p].length(); passo++) {
                                if (letters[randomrow + passo][randomcol + passo] >= 'A'
                                        && letters[randomrow + passo][randomcol + passo] <= 'Z') {
                                    possible = false;
                                    break;
                                }
                            }
                            if (possible == true) {
                                for (int next = 0; next < wordes[p].length(); next++) {

                                    letters[randomrow + next][randomcol + next] = wordes[p].charAt(next);
                                    siz += 1;
                                }

                                if (wordes[p].length() == siz) {
                                    wo = true;
                                }
                            } else
                                break;
                        } else
                            break;
                        break;

                }
                possible = true;
            }
            siz = 0;
            wo = false;

        }

        for (int roww = 0; roww < letters.length; roww++) {                                                //preenchimento das restantes letras da sopa random
            for (int cool = 0; cool < letters.length; cool++) {
                if (letters[roww][cool] == '.') {
                    letters[roww][cool] = randomChar();
                }
            }
        }

        System.out.println();
        for (int r = 0; r < letters.length; r++) {                                                          //print no terminal 
            for (int cl = 0; cl < letters.length; cl++) {
                System.out.printf("%2s", letters[r][cl]);
            }
            System.out.println();
        }
        System.out.println();

        new FileWriter(fi, false).close();                                                                  //escrever no ficheiro destinado 
        FileWriter fw = new FileWriter(fi, true);

        for (int a = 0; a < letters.length; a++) {
            for (int b = 0; b < letters.length; b++) {
                fw.write(letters[a][b]);

            }
            fw.write("\n");
        }
        fw.write("\n");
        fw.write("\n");

        for (String word : wordes) {
            fw.write(word.toLowerCase() + "\n");
        }

        fw.close();
                                                                                                //close
    }
}