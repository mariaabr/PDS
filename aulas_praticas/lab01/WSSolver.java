
package lab01;

import java.io.*;
import java.util.*;


public class WSSolver {
    public static void main(String[] args) throws IOException{ // String[] args contem um array com os argumentos introduzidos na linha de comando/terminal

        // inicializacao de variaveis
        Scanner file = null; 
        String line = null;
        int size_sopa = 0; // conta o numero de linhas da sopa de letras
        int size_1st_line = 0; // guarda o tamanho da primeira linha
        char[] char_sopa_lines;
        ArrayList<Character> sopa_lines = new ArrayList<Character>(); // array das linhas da sopa de letras, que tem de ser constituidas so por maiusculas
        ArrayList<ArrayList<Character>> sopa_letras = new ArrayList<ArrayList<Character>>(); // array bidimensional para guardar a sopa de letras
        ArrayList<String> words_lines = new ArrayList<String>(); // array das linhas das palavras a encontrar, que tem de ser constituidas por minusculas ou misturadas
        ArrayList<String> find_words = new ArrayList<String>(); // array de palavras a encontrar
        FileWriter file_solucao = null; //ficheiro onde vai ser escrito o resultado

        // leitura do ficheiro introduzido como argumento no terminal linux
        try {
            if(args.length == 1)
            {
                file = new Scanner(new File(args[0]));// args[0] é o nome do ficheiro txt que contém a sopa de letras e as palavras a encontrar
                file_solucao = new FileWriter(String.format("%s_results.txt", args[0].substring(0,args[0].length()-4))); //ficheiro onde vai ser escrita a solução
            }
            else{
                System.out.println("Incorrect number of arguments.");
                System.exit(0);
            }

        } catch (IOException e) {
            System.out.println("An error reading the file occurred.");
            e.printStackTrace();
        }

        // leitura das linhas do ficheiro e adicionadas aos arrays especificos
        while (file.hasNextLine()) { // ler linhas
            try {
                line = file.nextLine();
                if(!line.contains(";") && !line.contains(",") && !line.contains(" ")){ // && !line.contains("[ \t]")){ //filtrar as palavras a procurar
                    if(line.equals(line.toUpperCase())){
                        size_sopa++;

                        if(size_sopa == 1){
                            size_1st_line = line.length(); //guardar o tamanho da primeira linha para comparar com todas as outras
                        }

                        // validação do tamanho e caracteres da sopa de letras
                        if(line.length() != size_1st_line) {
                            System.out.println("O puzzle não é quadrado!");
                        } else if(line.length() > 40){
                            System.out.println("O puzzle tem um tamanho superior a 40!");
                        } else if(!line.matches("[A-Z]+")){
                            System.out.println("A sopa só pode ter caracteres alfabéticos!");
                        }else{
                            // passar o puzzle para o array bidimencional sopa_letras
                            char_sopa_lines = line.toCharArray();
                            sopa_lines = new ArrayList<Character>(); // array das linhas da sopa de letras, que tem de ser constituidas so por maiusculas

                            for(char character: char_sopa_lines){
                                sopa_lines.add(character);
                            }

                            // System.out.printf("here %s\n", sopa_lines);
                            sopa_letras.add(sopa_lines);
                        }
                    } else {
                        System.out.println("O puzzle não tem apenas letras maiúsculas, introduza outra sopa de letras para podermos avaliar!"); 
                        System.exit(0);
                    }
                } else {
                    words_lines.add(line);
                }
            } catch (NoSuchElementException e) { //caso haja linhas em branco
                continue;
            }
        }
        file.close();


        validate(find_words, words_lines,size_1st_line,size_sopa);

        char[][] sopa_solucao = createTabela(sopa_lines);

        for(String word : find_words){ // percorrer a lista de palavras a encontrar
            Solve.find_word_WSsolver(file_solucao,sopa_letras, word.toUpperCase(), size_sopa, sopa_solucao); //resolver a sopa
        }

        printTabela(sopa_solucao, file_solucao);   
    }

    static void validate(ArrayList<String> find_words, ArrayList<String> words_lines, int size_1st_line, int size_sopa){

        // split das palavras do array words_lines para ter uma lista das palavras a encontrar
        for(String l : words_lines){
            String[] words = l.split("\\W");
            for(String word : words){
                if(word.matches("[a-zA-Z]+")){ //garantir que a palavra a procurar só tem letras
                    if(word.length() >= 3){ // tem de ter pelo menos 3 caracteres
                        find_words.add(word);
                    }
                }
            }
        }

        // se existir uma palavra contida noutra retorna a maior
        for(int i = 0; i < find_words.size(); i++){
            for(int j = 0; j < find_words.size(); j++){
                if(find_words.get(i) != find_words.get(j) && find_words.get(i).contains(find_words.get(j))){
                    // System.out.printf("%s contem %s \n", find_words.get(i), find_words.get(j));
                    find_words.remove(find_words.get(j));
                }
            }
        }
    }

    static char[][] createTabela(ArrayList<Character> sopa_letras){
        char[][]sopa_solucao = new char [sopa_letras.size()][sopa_letras.size()]; // array bidimensional apresentado no fim com a solucao da sopa de letras
        for(int l = 0; l < sopa_solucao.length; l++){
            for(int c = 0; c < sopa_solucao.length; c++){
                sopa_solucao[l][c] = '.';
                // System.out.print(String.format("%c", sopa_solucao[l][c]));
            }
            // System.out.println();
        }
        return sopa_solucao;
    }

    // cria a tabela da solucao
    static void printTabela(char[][]sopa_solucao, FileWriter file_solucao){

        try {
            //escrever a sopa de letras
            file_solucao.write("\n");
            for(int l = 0; l < sopa_solucao.length; l++){
                for(int c = 0; c < sopa_solucao.length; c++){
                    file_solucao.write(String.format(" %c ", sopa_solucao[l][c]));
                }
                file_solucao.write("\n");
            }
            file_solucao.close();

        } catch (IOException e) {
            System.out.print("Error writing solution in file");
            e.printStackTrace();
        }
    }
}
