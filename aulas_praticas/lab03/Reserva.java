package lab03;

import java.util.*;

public class Reserva {

    private String codigo_voo;
    private char classe;
    private int passengers_num; // numero de lugares reservados numa reserva
    private int reserva_id;

    // public Reserva(String codigo_voo,char classe, int passengers_num){
    //     this.codigo_voo=codigo_voo;
    //     this.classe = classe;
    //     this.passengers_num = passengers_num;
    // }

    public Reserva(String codigo_voo, char classe, int passengers_num, int reserva_id){
        this.codigo_voo=codigo_voo;
        this.classe = classe;
        this.passengers_num = passengers_num;
        this.reserva_id = reserva_id;
    }

    public String getCodigo_voo() {
        return codigo_voo;
    }

    public void setCodigo_voo(String codigo_voo) {
        this.codigo_voo = codigo_voo;
    }


    public char getClasse() {
        return classe;
    }

    public void setClasse(char classe) {
        this.classe = classe;
    }


    public int getPassengers_num() {
        return passengers_num;
    }

    public void setPassengers_num(int passengers_num) {
        this.passengers_num = passengers_num;
    }

    public int getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(int reserva_id) {
        this.reserva_id = reserva_id;
    }

    public Object getCodigo_reserva() {
        return null;
    }

    public String[] getLugares() {
        return null;
    }

    public static void addReserva(char classe, int places_number) {
        
    }

    
    // public static void printMapreservas(Voo voo){

    //     // boolean classe_exec = false;
    //     int lugaresT_total = voo.getFilasT_num() * voo.getLugares_filaT_num();
    //     int lugaresE_total = voo.getFilasE_num() * voo.getLugares_filaE_num();;
    //     int lugaresTuristica[][] = new int[voo.getFilasT_num()][voo.getLugares_filaT_num()];
    //     int lugaresExecutiva[][] = new int[voo.getFilasE_num()][voo.getLugares_filaE_num()];
    //     int num_filas_total = voo.getFilasE_num() + voo.getFilasT_num();
    //     int max;
    //     char classe = getClasse();
        
    //     // linha das filas do aviao: executiva + turistica
    //     System.out.printf("    ");
    //     // System.out.println("hello");
    //     for(int i = 1; i <= num_filas_total; i++){
    //         System.out.printf("%2d ", i);
    //     }

    //     if(voo.getLugares_filaT_num() >= voo.getLugares_filaE_num()){
    //         max = voo.getLugares_filaT_num();
    //     } else {
    //         max = voo.getLugares_filaE_num();
    //     }

    //     for(int i = 0; i < max; i++){

    //         int letter_fila_num = 65 + i; // 'A' ascii
    //         char letter_fila = (char) letter_fila_num;
    //         System.out.printf("\n%c   ", letter_fila);

    //         for(int j = 0; j < voo.getFilasE_num(); j++){
    //             if (i < voo.getLugares_filaE_num()) {
    //                 System.out.format("%2d ", lugaresExecutiva[j][i]);
                    
    //                 for(int num = 0; num < )
    //                 // if(classe.equals("E")){

    //                 // }
                    
    //             } else if (i >= voo.getLugares_filaE_num()){
    //                 System.out.format("   ");
    //             }
    //         }

    //         for(int n = 0; n < voo.getFilasT_num(); n++){
    //             System.out.format("%2d ", lugaresTuristica[n][i]); // ahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh //sameeeeeeeee
    //         }
    //     }
    // }

    // @Override
    // public String toString() {
    //     return codigo_voo + ":" + reservation_number + " = " classe=" + classe + ", passengers_num=" + passengers_num
    //             + ", reservation_number=" + reservation_number + "]";
    // }
}