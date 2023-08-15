package lab01;

import java.io.*;
import java.util.*;


public class Solve {

    int size_sopa = 0; // conta o numero de linhas da sopa de letras
    int size_1st_line = 0; // guarda o tamanho da primeira linha
    char[] char_sopa_lines;
    ArrayList<Character> sopa_lines = new ArrayList<Character>(); // array das linhas da sopa de letras, que tem de ser constituidas so por maiusculas
    ArrayList<ArrayList<Character>> sopa_letras = new ArrayList<ArrayList<Character>>(); // array bidimensional para guardar a sopa de letras
    ArrayList<String> words_lines = new ArrayList<String>(); // array das linhas das palavras a encontrar, que tem de ser constituidas por minusculas ou misturadas
    ArrayList<String> find_words = new ArrayList<String>(); // array de palavras a encontrar
    FileWriter file_solucao = null; //ficheiro onde vai ser escrito o resultado


    static void find_word_WSsolver(FileWriter file_solucao,ArrayList<ArrayList<Character>> sopa_letras, String word, int size_sopa, char[][] sopa_solucao){ // econtra a palavra na sopa de letras

        // percorrer a sopa de letras
        for(int l = 0; l < sopa_letras.size(); l++){ // l representa as linhas da sopa de letras
            for(int c = 0; c < sopa_letras.size(); c++){ // c representa as colunas da sopa de letras
                if(sopa_letras.get(l).get(c) == word.charAt(0)){ // (l,c) -> coordenadas da primeira letra de cada palavra

                    // testar para todas as direcoes caso haja espaço
                    coordenadas coord_inicial = new coordenadas(l+1, c+1); // definir as coordenadas iniciais de ca palavra -> l+1 e c+1 porque l e c comecam em 0
                    
                    // Up
                    if(checkUp(l, word)){
                        searchUp(file_solucao,l, c, sopa_letras, word, size_sopa, coord_inicial, sopa_solucao);
                    }
                    // Down
                    if(checkDown(l, word, size_sopa)){
                        searchDown(file_solucao,l, c, sopa_letras, word, size_sopa, coord_inicial, sopa_solucao); 
                    }

                    // Left
                    if(checkLeft(c, word)){
                        searchLeft(file_solucao,l, c, sopa_letras, word, size_sopa, coord_inicial, sopa_solucao);
                    }

                    // Right
                    if(checkRight(c, word, size_sopa)){
                        searchRight(file_solucao,l, c, sopa_letras, word, size_sopa, coord_inicial, sopa_solucao);
                    }

                    // UpLeft
                    if(checkUpLeft(l, c, word)){
                        searchUpLeft(file_solucao,l, c, sopa_letras, word, size_sopa, coord_inicial, sopa_solucao);
                    }

                    // UpRight
                    if(checkUpRight(l, c, word, size_sopa)){
                        searchUpRight(file_solucao,l, c, sopa_letras, word, size_sopa, coord_inicial, sopa_solucao);
                    }

                    // DownLeft
                    if(checkDownLeft(l, c, word, size_sopa)){
                        searchDownLeft(file_solucao,l, c, sopa_letras, word, size_sopa, coord_inicial, sopa_solucao);
                    }

                    // DownRight
                    if(checkDownRight(l, c, word, size_sopa)){
                        searchDownRight(file_solucao,l, c, sopa_letras, word, size_sopa, coord_inicial, sopa_solucao);
                    }
                    
                }
            }
        }
    }

    // funcoes de check da possível direcao das palavras
    static boolean checkUp(int linha, String word){
        if((linha + 1) - word.length() < 0){ // (linha + 1) porque comeca no indice 0
            return false;
        }
        return true;
    }
 
    static boolean checkDown(int linha, String word, int size_sopa){
        if(linha + word.length() > size_sopa){
            return false;
        }
        return true;
    }

    static boolean checkLeft(int coluna, String word){
        if((coluna + 1) - word.length() < 0){
            return false;
        }
        return true;
    }

    static boolean checkRight(int coluna, String word, int size_sopa){
        if(coluna + word.length() > size_sopa){ // (coluna - 1) porque comeca no indice 0
            return false;
        }
        return true;
    }

    // diagonais
    static boolean checkUpLeft(int linha, int coluna, String word){
        if(linha - word.length() < 0 || (coluna + 1) - word.length() < 0){
            return false;
        }
        return true;
    }

    static boolean checkUpRight(int linha, int coluna, String word, int size_sopa){
        if((linha + 1) - word.length() < 0 || coluna + word.length() > size_sopa){
            return false;
        }
        return true;
    }

    static boolean checkDownLeft(int linha, int coluna, String word, int size_sopa){
        if(linha + word.length() > size_sopa || (coluna + 1) - word.length() < 0){
            return false;
        }
        return true;
    }

    static boolean checkDownRight(int linha, int coluna, String word, int size_sopa){
        if(linha + word.length() > size_sopa || coluna + word.length() > size_sopa){
            return false;
        }
        return true;
    }

    // procurar a palavra toda na sopa de letras
    // estas funcoes de search não so procuram a palavra como, caso a encontrem, escrevem-na na tabela que sera mostrada ao utilizador
    //e chamam a função printSolucao que prints o output que inclui a palavra, o seu tamanho, as coordenaas e a direção encontrada pela função
    private static char[][] searchUp(FileWriter file_solucao,int linha, int coluna, ArrayList<ArrayList<Character>> sopa_letras, String word, int size_sopa, coordenadas coord_inicial,  char[][] sopa_solucao){
        int i = 0;

        for (char letter : word.toCharArray() ){
            if(sopa_letras.get(linha - i).get(coluna) == letter && i != word.length() - 1){
                i++;
                continue;
            } else if (sopa_letras.get(linha - i).get(coluna) == letter){ // ultima letra da palavra
                // a palavra foi encontrada
                for(int j = 0; j < word.length(); j++) {
                    sopa_solucao[linha - j][coluna] = sopa_letras.get(linha - j).get(coluna); // escrever a palavra na solucao da sopa de letras
                }
                printSolucao(file_solucao,word, coord_inicial, direction.Up, sopa_solucao);
            } else {
                break;
            }
        }
        return sopa_solucao;
    }

    private static char[][] searchDown(FileWriter file_solucao,int linha, int coluna, ArrayList<ArrayList<Character>> sopa_letras, String word, int size_sopa, coordenadas coord_inicial,  char[][] sopa_solucao){
        int i = 0;

        for (char letter : word.toCharArray() ){
            if(sopa_letras.get(linha + i).get(coluna) == letter && i != word.length() - 1){
                i++;
                continue;
            } else if (sopa_letras.get(linha + i).get(coluna) == letter){
                // a palavra foi encontrada
                for(int j = 0; j < word.length(); j++) {
                    sopa_solucao[linha + j][coluna] = sopa_letras.get(linha + j).get(coluna); // escrever a palavra na solucao da sopa de letras
                }
                printSolucao(file_solucao,word, coord_inicial, direction.Down, sopa_solucao);
            } else {
                break;
            }
        }
        return sopa_solucao;
    }

    private static char[][] searchLeft(FileWriter file_solucao,int linha, int coluna, ArrayList<ArrayList<Character>> sopa_letras, String word, int size_sopa, coordenadas coord_inicial,  char[][] sopa_solucao){
        int i = 0;

        for (char letter : word.toCharArray() ){
            if(sopa_letras.get(linha).get(coluna - i) == letter && i != word.length() - 1){
                i++;
                continue;
            } else if (sopa_letras.get(linha).get(coluna - i) == letter){
                // a palavra foi encontrada
                for(int j = 0; j < word.length(); j++) {
                    sopa_solucao[linha][coluna - j] = sopa_letras.get(linha).get(coluna - j); // escrever a palavra na solucao da sopa de letras
                }
                printSolucao(file_solucao,word, coord_inicial, direction.Left, sopa_solucao);
            } else {
                break;
            }
        }
        return sopa_solucao;
    }

    private static char[][] searchRight(FileWriter file_solucao,int linha, int coluna, ArrayList<ArrayList<Character>> sopa_letras, String word, int size_sopa, coordenadas coord_inicial,  char[][] sopa_solucao){
        int i = 0;

        for (char letter : word.toCharArray() ){
            if(sopa_letras.get(linha).get(coluna + i) == letter && i != word.length() - 1){
                i++;
                continue;
            } else if (sopa_letras.get(linha).get(coluna + i) == letter){
                // a palavra foi encontrada
                for(int j = 0; j < word.length(); j++) {
                    sopa_solucao[linha][coluna + j] = sopa_letras.get(linha).get(coluna + j); // escrever a palavra na solucao da sopa de letras
                }
                printSolucao(file_solucao,word, coord_inicial, direction.Right, sopa_solucao);
            } else {
                break;
            }
        }
        return sopa_solucao;
    }

    // diagonais
    private static char[][] searchUpLeft(FileWriter file_solucao,int linha, int coluna, ArrayList<ArrayList<Character>> sopa_letras, String word, int size_sopa, coordenadas coord_inicial,  char[][] sopa_solucao){
        int i = 0;

        for (char letter : word.toCharArray() ){
            if(sopa_letras.get(linha - i).get(coluna - i) == letter && i != word.length() - 1){
                i++;
                continue;
            } else if (sopa_letras.get(linha - i).get(coluna - i) == letter){
                // a palavra foi encontrada
                for(int j = 0; j < word.length(); j++) {
                    sopa_solucao[linha - j][coluna - j] = sopa_letras.get(linha - j).get(coluna - j); // escrever a palavra na solucao da sopa de letras
                }
                printSolucao(file_solucao,word, coord_inicial, direction.UpLeft, sopa_solucao);
            } else {
                break;
            }
        }
        return sopa_solucao;
    }

    private static char[][] searchUpRight(FileWriter file_solucao,int linha, int coluna, ArrayList<ArrayList<Character>> sopa_letras, String word, int size_sopa, coordenadas coord_inicial,  char[][] sopa_solucao){
        int i = 0;

        for (char letter : word.toCharArray() ){
            if(sopa_letras.get(linha - i).get(coluna + i) == letter && i != word.length() - 1){
                i++;
                continue;
            } else if (sopa_letras.get(linha - i).get(coluna + i) == letter){
                // a palavra foi encontrada
                for(int j = 0; j < word.length(); j++) {
                    sopa_solucao[linha - j][coluna + j] = sopa_letras.get(linha - j).get(coluna + j); // escrever a palavra na solucao da sopa de letras
                }
                printSolucao(file_solucao,word, coord_inicial, direction.UpRight, sopa_solucao);
            } else {
                break;
            }
        }
        return sopa_solucao;
    }

    private static char[][] searchDownLeft(FileWriter file_solucao,int linha, int coluna, ArrayList<ArrayList<Character>> sopa_letras, String word, int size_sopa, coordenadas coord_inicial,  char[][] sopa_solucao){
        int i = 0;

        for (char letter : word.toCharArray() ){
            if(sopa_letras.get(linha + i).get(coluna - i) == letter && i != word.length() - 1){
                i++;
                continue;
            } else if (sopa_letras.get(linha + i).get(coluna - i) == letter){
                // a palavra foi encontrada
                for(int j = 0; j < word.length(); j++) {
                    sopa_solucao[linha + j][coluna - j] = sopa_letras.get(linha + j).get(coluna - j); // escrever a palavra na solucao da sopa de letras
                }
                printSolucao(file_solucao,word, coord_inicial, direction.DownLeft, sopa_solucao);
            } else {
                break;
            }
        }
        return sopa_solucao;
    }

    private static char[][] searchDownRight(FileWriter file_solucao,int linha, int coluna, ArrayList<ArrayList<Character>> sopa_letras, String word, int size_sopa, coordenadas coord_inicial,  char[][] sopa_solucao){
        int i = 0;

        for (char letter : word.toCharArray() ){
            if(sopa_letras.get(linha + i).get(coluna + i) == letter && i != word.length() - 1){
                i++;
                continue;
            } else if (sopa_letras.get(linha + i).get(coluna + i) == letter){
                // a palavra foi encontrada
                for(int j = 0; j < word.length(); j++) {
                    sopa_solucao[linha + j][coluna + j] = sopa_letras.get(linha + j).get(coluna + j); // escrever a palavra na solucao da sopa de letras
                }
                printSolucao(file_solucao,word, coord_inicial, direction.DownRight, sopa_solucao);
            } else {
                break;
            }
        } 
        return sopa_solucao;
    }

        // print da solucao
        static void printSolucao(FileWriter file_solucao,String word, coordenadas coord_inicial, direction direcao, char[][] sopa_solucao){
    
            try {
                //escrever a sopa de letras
                file_solucao.write(String.format("%-15s %-6d %-8s %-9s \n", word.toLowerCase(), word.length(), coord_inicial, direcao));
            } catch (IOException e) {
                System.out.print("Error writing solution in file");
                e.printStackTrace();
            }
        }

}

