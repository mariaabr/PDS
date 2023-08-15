package lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservas {

    static String nomeVoo;
    static String lugaresE;
    static String lugaresT;
    static ArrayList<String> reservas = new ArrayList<String>();
    static char[][] mapaT;
    static char[][] mapaE;

    public static void readFile(File file) throws FileNotFoundException{
        Scanner s = new Scanner(file);
        String[] line = s.nextLine().split(" ");
        nomeVoo = line[0];
        if( line.length <=2){
            lugaresT = line[1];
        }
        else{
            lugaresE = line[1];
            lugaresT = line[2];
        }
        while(s.hasNextLine()){

            reservas.add(s.nextLine());

        }

        s.close();
    }

    public static void createMaps(){
        String[] lineT = lugaresT.split("x");
        mapaT = new char[Integer.parseInt(lineT[0])][Integer.parseInt(lineT[1])];
        if( lugaresE!= null){
            String[] lineE = lugaresE.split("x");
            mapaE = new char[Integer.parseInt(lineE[0])][Integer.parseInt(lineE[1])];
        }
    }

    public static boolean checkSpaces(){
        for(String reserva: reservas){
            if( mapaE != null){
                String[] r = reserva.split(" ");
                if(r[0]=="E"){
                    mapaE[][] = r[1];
   
                }
                if(r[0]=="T"){
                    mapaT[][] = r[1];
   
                }
            }
            else{
                String[] r = reserva.split(" ");
                mapaT[][] = r[1];
            }
        }

        return false;
    }


    public static void main(String[] args) throws FileNotFoundException {
        File voo = new File(args[0]);
        readFile(voo);
        createMaps();
        checkSpaces();

    }
}
