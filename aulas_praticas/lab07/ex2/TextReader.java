import java.util.*;
import java.io.*;

public class TextReader implements InterfaceTextReader {

    private String filename;

    public TextReader (String file_name){
        this.filename = file_name;
    }

    @Override
    public boolean hasNext(){

        Scanner file = scanner_file(filename);
        return file.hasNextLine();

    }

    @Override
    public String next(){

        Scanner file = scanner_file(filename);
        String all = "";
        
        while(file.hasNextLine()){
            all += file.nextLine();
            all += "\n";
        }
        return all;

    } 

    //método para ler o ficheiro
    public Scanner scanner_file(String filename){

        Scanner file = null;
        try {
            file = new Scanner(new File(filename));
            
        } catch (FileNotFoundException e) {
            System.out.println("Erro! Ficheiro não encontrado...");
            System.exit(0);
        }

        return file;
    }
}

