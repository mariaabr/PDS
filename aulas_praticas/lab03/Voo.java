package lab03;
import java.util.*;


public class Voo {
    
    private String codigo_voo;
    private Aviao aviao;
    private int filasT_num;
    private int lugares_filaT_num;
    private int filasE_num;
    private int lugares_filaE_num;
    private int disponiveisE;
    private int disponiveisT;
    private int reserva_id = 0;
    private ArrayList <String> reservas = new ArrayList <String>();
    // private boolean classe_exec;
    // private int lugaresT_total;
    // private int lugaresE_total;
    private int lugaresTuristica[][];
    private int lugaresExecutiva[][];

    public Voo(String codigo_voo, int filasT_num,  int lugares_filaT_num){
        this.codigo_voo = codigo_voo;
        this.aviao = new Aviao(filasT_num, lugares_filaT_num);
        this.filasT_num = filasT_num;
        this.lugares_filaT_num = lugares_filaT_num;
        this.disponiveisT = filasT_num * lugares_filaT_num;
        // this.classe_exec = false;
        // this.lugaresT_total = filasT_num * lugares_filaT_num;
        // this.lugaresTuristica = new int[filasT_num][lugares_filaT_num];
    }

    public Voo(String codigo_voo, int filasT_num, int lugares_filaT_num, int filasE_num, int lugares_filaE_num){
        this.codigo_voo = codigo_voo;
        this.aviao = new Aviao(filasT_num, lugares_filaT_num, filasE_num, lugares_filaE_num);
        this.filasT_num = filasT_num;
        this.lugares_filaT_num = lugares_filaT_num;
        this.filasE_num = filasE_num;
        this.lugares_filaE_num = lugares_filaE_num;
        this.disponiveisE = filasE_num * lugares_filaE_num;
        this.disponiveisT = filasT_num * lugares_filaT_num;
        // this.classe_exec = true;
        // this.lugaresT_total = filasT_num * lugares_filaT_num;
        // this.lugaresE_total = filasE_num * lugares_filaE_num;
        // this.lugaresTuristica = new int[filasT_num][lugares_filaT_num];
        // this.lugaresExecutiva = new int[filasE_num][lugares_filaE_num];
    }

    public String getCodigo_voo() {
        return codigo_voo;
    }

    public void setCodigo_voo(String codigo_voo) {
        this.codigo_voo = codigo_voo;
    }

    public int getFilasT_num() {
        return filasT_num;
    }

    public void setFilasT_num(int filasT_num) {
        this.filasT_num = filasT_num;
    }

    public int getLugares_filaT_num() {
        return lugares_filaT_num;
    }

    public void setLugares_filaT_num(int lugares_filaT_num) {
        this.lugares_filaT_num = lugares_filaT_num;
    }

    public int getFilasE_num() {
        return filasE_num;
    }

    public void setFilasE_num(int filasE_num) {
        this.filasE_num = filasE_num;
    }

    public int getLugares_filaE_num() {
        return lugares_filaE_num;
    }

    public void setLugares_filaE_num(int lugares_filaE_num) {
        this.lugares_filaE_num = lugares_filaE_num;
    }

    

    public int[][] getLugaresTuristica() {
        return lugaresTuristica;
    }

    public void setLugaresTuristica(int[][] lugaresTuristica) {
        lugaresTuristica = new int [filasT_num][lugares_filaT_num];
    }

    public int[][] getLugaresExecutiva() {
        return lugaresExecutiva;
    }

    public void setLugaresExecutiva(int[][] lugaresExecutiva) {
        lugaresExecutiva = new int [filasE_num][lugares_filaE_num];
    }


    
    public int getDisponiveisE() {
        return disponiveisE;
    }
    ArrayList<String> places = new ArrayList<String>();

    public void setDisponiveisT(int disponiveisT) {
        this.disponiveisT = disponiveisT;
    }

    @Override
    public String toString() {
        return "Voo [codigo_voo=" + codigo_voo + ", aviao=" + aviao + ", filasT_num=" + filasT_num
                + ", lugares_filaT_num=" + lugares_filaT_num + ", filasE_num=" + filasE_num + ", lugares_filaE_num="
                + lugares_filaE_num + "]";
    }

	public ArrayList<String> nova_reserva(char classe, int lugares_desejados) {
        int fila, lugar;
        int controlo_c = 0; //controla colunas
        int controlo_l = 0; //controla linhas

        if (classe=='E'){
            System.out.print("aqui");
            if (lugares_desejados>disponiveisE){
                System.err.printf("Impossível fazer reserva, há apenas %d lugares disponíveis", disponiveisE);
            }
            else{
                reserva_id ++;
                for (int i = controlo_c; i < filasE_num; i++) {
                    for (int j = controlo_l; j < lugares_filaE_num; j++) {
                        int letter_fila_num = 65 + j; // 'A' ascii
                        char letter_fila = (char) letter_fila_num;
                        if (lugares_desejados!= 0 && lugaresExecutiva[i][j] == 0) {
                            lugaresExecutiva[j][i] = reserva_id;
                            System.out.print(lugaresExecutiva);
                            lugares_desejados--;
                            reservas.add(controlo_c, String.valueOf(letter_fila));
                            System.out.printf("%s | %s",controlo_c, letter_fila);
                        }
                    }
                    controlo_c += i;
                }
                disponiveisE -= lugares_desejados;
            }
        }
        else if (classe=='T'){
            System.out.print("aqui");
            if (lugares_desejados>disponiveisT){
                System.err.printf("Impossível fazer reserva, há apenas %d lugares disponíveis", disponiveisE);
            }
            else{
                reserva_id ++;
                for (int i = controlo_c; i < filasT_num; i++) {
                    for (int j = controlo_l; j < lugares_filaT_num; j++) {
                        int letter_fila_num = 65 + j; // 'A' ascii
                        char letter_fila = (char) letter_fila_num;
                        if (lugares_desejados!= 0 && lugaresTuristica[i][j] == 0) {
                            lugaresTuristica[j][i] = reserva_id;
                            System.out.print(lugaresTuristica);
                            lugares_desejados--;
                            reservas.add(controlo_c, String.valueOf(letter_fila));
                            System.out.printf("%s | %s",controlo_c, letter_fila);
                        }
                    }
                    controlo_c += i;
                }
                disponiveisT -= lugares_desejados;
            }
        }
        return reservas;
	}
}