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
import java.lang.String;

public class WSSolver{

    static void verifyArgs(String[] args){
        if (args.length==0){                                                    //verificação se existem argumentos
            System.out.println("Error: no arguments");
            System.exit(0);
        }
    }


    static void verificationsLetters(int columns,int rows,char[][] letters)
    {
        if (!(columns==rows)){                                                          //must be a square
            System.out.println("Soup must be a square");
            System.exit(0);
        }

        for (int a=0;a<letters.length;a++){
            for (int b=0;b<letters.length;b++){
                char car=letters[a][b];                                             // cada caracter
                    if (car >= 'a' && car <= 'z'){                                      //verificar se estão todas maiusculas
                        System.out.println("\n"+ "Some letters of the soup are in lowercase.Please all the letters must be in uppercase"+ "\n");        // mensagem de erro
                        System.exit(0);     //exit
                        
                    }
                    else if( car==' ' ){                                                //verificar linhas com espaços vazios
                        System.out.println("\n"+"Incomplete alphabet soup"+"\n");           //mensagem de erro 
                        System.exit(0);     //exit
                    }
                    else if(!(car>='A' && car<='Z')){                                    //verificar se apenas existem caracteres alfabéticos
                        System.out.println("\n" + "There only must be alphabetic characters. Please rewrite the soup."+"\n");       //mensagem de erro 
                        System.exit(0);     //exit
                    }
            }
        }
    }

    static void verificationsWords(List<String>words){                                              //verification if the words have at least 3 caracters
          for(String word:words){
            if(word.length()<3){
                System.out.println("The words must have at least 3 caracters");
                System.exit(0);
            }
          }
    }

    static void toU(String[] wordes){                                                               //to uppercase
        for(int p=0;p<wordes.length;p++){
            wordes[p]=wordes[p].toUpperCase();
        }
    }

    static void showSoup(char[][] letters){                                                         //print da sopa
        for (int a=0;a<letters.length;a++){ 
            for (int b=0;b<letters.length;b++){
                System.out.print(letters[a][b]+" ");

            }
            System.out.print("\n");
        }
    }


    static void showWords( String[] wordes ){                                                               //print das palavras
        System.out.print("Palavras a encontrar: \n" );
        for(String word:wordes){
            System.out.print(word + "\n");
        }
    }

    static void showtable(String[] wordes,String[] positions,int[][] postions){                                     //print da tabela
        System.out.printf("\n\n%-16s  %-16s  %-16s  %-16s \n\n","Words","Size","Pos","Search");
        for (int tab=0;tab<wordes.length;tab++){
            String posR=String.valueOf(postions[tab][0]);
            String posC=String.valueOf(postions[tab][1]);
            String pos=posR+","+posC;
            System.out.printf("%-17s %-17d %-17s %-17s \n",wordes[tab],wordes[tab].length(),pos,positions[tab]);
            
        }
    }

    static void showFinalSoup(char[][] finalsoup){                                                                  //print da sopa final com as palavras encontradas
        System.out.println();
        for (int r = 0; r < finalsoup.length; r++) { 
            for (int cl= 0; cl < finalsoup.length; cl++){
                System.out.printf("%2s",finalsoup[r][cl]);
                }
            System.out.println();
        }
        System.out.println();
    }




                
    public static void main(String args[]) throws IOException{

        Path path = Paths.get(args[0]);                                         //encontrar ficheiro

        verifyArgs(args);
	

        //leitura//

        List<String> lines = Files.readAllLines(path);                              //ler ficheiro
        int i=0;
        int columns=0;
        List<String> words = new ArrayList<>();
        int rows = lines.get(0).length();
        char[][] letters= new char[rows][rows];
        System.out.println();                                                 //espaço
        for (String line: lines){                                                   //percorre linhas
            if(i<rows && line.equals(line.toUpperCase())){
                char[] caracter = line.toCharArray();                                   //array de caracteres                                        //print desse array de caracteres
                letters[i]=caracter;                                                    //array de caracteres passa para a matriz
                i=i+1;
                columns++;
            }
            else{
                String[] lineWords = line.split("[,;\\s]+");
                for (String word : lineWords) {
                    if (!word.isEmpty()) {
                        words.add(word);
                    }
                }
            }                                                                                       //proxima linha
        }   


        String[] wordes=new String[words.size()];
        int n=0;
        for(String word:words){
                wordes[n]=word;
                n++;
        }


        //fim leitura//

        System.out.println("\n");
        verificationsLetters(columns,rows,letters);                                                //chamada funcao verificationLetters
        verificationsWords(words);                                                            // chamada funcao verificationsWords
        showSoup(letters);
        System.out.println();
        showWords(wordes);
        

        

        char[][] finalsoup=new char[letters.length][letters.length];                          //criação matriz vazia
        for (int a=0;a<finalsoup.length;a++){                                   // percorrer linhas
            for (int b=0;b<finalsoup.length;b++){                               //percorrer colunas
                finalsoup[a][b]='.';                                            //adicionar . a cada elemento da matriz
            }
        }


        toU(wordes);


        
        int[][] postions=new int[words.size()][2];
        String[] positions=new String[words.size()];
        int siz=0;


         // fazer pesquisa das palavras //

        for(int p=0;p<wordes.length;p++){                                                                           //percorre cada palavra 
            for (int row=0;row<letters.length;row++){                                                               //percorre cada linha e coluna 
                for (int col=0;col<letters.length;col++){
                        if(wordes[p].charAt(0)==letters[row][col]){                                                 //caso seja encontra a primeira letra da palavra dentro da sopa de letras é efetuada a procura

                            //search right
                            for(int next=0;next<wordes[p].length();next++){                                          //procura em todas as direções
                                if(col+wordes[p].length()<=letters.length){
                                    if(wordes[p].charAt(next)==letters[row][col+next]){
                                        siz+=1;
                                    }else break;
                                }else break;

                                if(wordes[p].length()==siz){
                                    int cnt=0;
                                    for(int ap=col;ap < col+wordes[p].length();ap++){
                                        finalsoup[row][ap] = wordes[p].charAt(cnt);
                                        cnt++;
                                    }
                                    postions[p][0]=row+1;
                                    postions[p][1]=col+1;
                                    positions[p]="Right";

                                }
                            }
                                
                            siz=0;

                            //search left
                            for(int next=0;next<wordes[p].length();next++){
                                if(col-wordes[p].length()+1 >=0){
                                    if(wordes[p].charAt(next)==letters[row][col-next]){
                                        siz+=1;
                                    }else break;
                                }else break;

                                if(wordes[p].length()==siz){
                                    int cnt=0;
                                    for(int ap=col;ap>col-wordes[p].length();ap--){
                                        finalsoup[row][ap] = wordes[p].charAt(cnt);
                                        cnt++;
                                    }
                                    postions[p][0]=row+1;
                                    postions[p][1]=col+1;
                                    positions[p]="Left";
                                }
                            }
                            siz=0;

                            //search up
                            for(int next=0;next<wordes[p].length();next++){
                                if(row-wordes[p].length()+1 >=0){
                                    if(wordes[p].charAt(next)==letters[row-next][col]){
                                        siz+=1;
                                    }else break;
                                }else break;

                                if(wordes[p].length()==siz){
                                    int cnt=0;
                                    for(int ap=row;ap>row-wordes[p].length();ap--){
                                        finalsoup[ap][col] = wordes[p].charAt(cnt);
                                        cnt++;
                                    }
                                    postions[p][0]=row+1;
                                    postions[p][1]=col+1;
                                    positions[p]="Up";
                                }
                            }
                            siz=0;

                            //search down
                            for(int next=0;next<wordes[p].length();next++){
                                if(row+wordes[p].length()<=letters.length){
                                    if(wordes[p].charAt(next) == letters[row+next][col]){
                                        siz+=1;
                                    }else break;
                                }else break;

                                if(wordes[p].length()==siz){
                                    int cnt=0;
                                    for(int ap=row;ap<row+wordes[p].length();ap++){
                                        finalsoup[ap][col] = wordes[p].charAt(cnt);
                                        cnt++;
                                    }
                                    postions[p][0]=row+1;
                                    postions[p][1]=col+1;
                                    positions[p]="Down";
                                }
                            }
                            siz=0;
                        
                            // search upleft
                            for(int next=0;next<wordes[p].length();next++){
                                if(row-wordes[p].length() + 1 >= 0 && col-wordes[p].length() +1 >= 0){
                                    if(wordes[p].charAt(next)==letters[row-next][col-next]){
                                        siz+=1;
                                    }else break;
                                }else break;

                                if(wordes[p].length()==siz){
                                    int cnt=0;
                                    int dig=col;
                                    for(int ap=row;ap>row-wordes[p].length();ap--){
                                        finalsoup[ap][dig] = wordes[p].charAt(cnt);
                                        dig--;
                                        cnt++;
                                    }
                                    postions[p][0]=row+1;
                                    postions[p][1]=col+1;
                                    positions[p]="UpLeft";
                                }
                            }
                            siz=0;

                             //search upright
                             for(int next=0;next<wordes[p].length();next++){
                                if((row-wordes[p].length() + 1 >= 0) && (col+wordes[p].length()<=letters.length)){
                                    if(wordes[p].charAt(next)==letters[row-next][col+next]){
                                        siz+=1;
                                    }else break;
                                }else break;

                                if(wordes[p].length()==siz){
                                    int cnt=0;
                                    int dig=col;
                                    for(int ap=row;ap>row-wordes[p].length();ap--){
                                        finalsoup[ap][dig] = wordes[p].charAt(cnt);
                                        dig++;
                                        cnt++;
                                    }
                                    postions[p][0]=row+1;
                                    postions[p][1]=col+1;
                                    positions[p]="UpRight";
                                }
                            }
                            siz=0;

                            //search down left
                            for(int next=0;next<wordes[p].length();next++){
                                if(row+wordes[p].length()<=letters.length && (col-wordes[p].length()+1 >=0)){
                                    if(wordes[p].charAt(next)==letters[row+next][col-next]){
                                        siz+=1;
                                    }else break;
                                }else break;

                                if(wordes[p].length()==siz){
                                    int cnt=0;
                                    int dig=col;
                                    for(int ap=row;ap<row+wordes[p].length();ap++){
                                        finalsoup[ap][dig] = wordes[p].charAt(cnt);
                                        dig--;
                                        cnt++;
                                    }
                                    postions[p][0]=row+1;
                                    postions[p][1]=col+1;
                                    positions[p]="DownLeft";
                                }
                            }
                            siz=0;

                            //search down right

                            for(int next=0;next<wordes[p].length();next++){
                                if((col+wordes[p].length()<=letters.length)&& (row+wordes[p].length()<=letters.length) ){
                                    if(wordes[p].charAt(next)==letters[row+next][col+next]){
                                        siz+=1;
                                    }else break;
                                }else break;

                                if(wordes[p].length()==siz){
                                    int cnt=0;
                                    int dig=col;
                                    for(int ap=row;ap<row+wordes[p].length();ap++){
                                        finalsoup[ap][dig] = wordes[p].charAt(cnt);
                                        dig++;
                                        cnt++;
                                    }
                                    postions[p][0]=row+1;
                                    postions[p][1]=col+1;
                                    positions[p]="DownRight";
                                }
                            }
                            siz=0;
                        }
                    }
                }
            }

        //fim pesquisa//


        showtable(wordes,positions,postions);
        showFinalSoup(finalsoup);

        String number="";

        for(int a=0;a<args[0].length();a++){

            if(args[0].charAt(a)>='0'&& args[0].charAt(a)<='9'){
                number+=args[0].charAt(a);
            }

        }
        

        String fi="sopa"+number+"_result.txt";

        new FileWriter(fi, false).close();                                                      //escrever ficheiro destinado resultados pretendidos
        FileWriter fw=new FileWriter(fi,true);


        for (int a=0;a<letters.length;a++){
            for (int b=0;b<letters.length;b++){
                fw.write(letters[a][b]+" ");

            }
            fw.write("\n");
        }
        fw.write("\n");

        fw.write("Palavras a encontrar: \n" );
        for(String word:wordes){
            fw.write(word + "\n");
        }

        fw.write(String.format("\n\n%-16s  %-16s  %-16s  %-16s \n\n","Words","Size","Pos","Search"));
        for (int tab=0;tab<wordes.length;tab++){
            String posR=String.valueOf(postions[tab][0]);
            String posC=String.valueOf(postions[tab][1]);
            String pos=posR+","+posC;
            fw.write(String.format("%-17s %-17d %-17s %-17s \n",wordes[tab],wordes[tab].length(),pos,positions[tab]));
            
        }

        fw.write("\n");
        for (int r = 0; r < finalsoup.length; r++) { 
            for (int cl= 0; cl < finalsoup.length; cl++){
                fw.write(String.format("%2s",finalsoup[r][cl]));
                }
            fw.write("\n");
        }
        fw.write("\n");



        fw.close();




        


    
    
    }
}







            





