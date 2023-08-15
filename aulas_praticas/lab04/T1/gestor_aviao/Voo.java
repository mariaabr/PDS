package lab03.gestor_aviao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Voo {
    
    private String id;
    private String execStr;
    private String tourStr;

    private int classeExec;
    private int classeTour;

    private int execOcupados = 0;
    private int tourOcupados = 0;

    private int filasExec = 0;
    private int filasTour = 0;
    private int filasTotal = 0;

    private int execPorFila;
    private int tourPorFila;
    private int colsTotal;

    private int ReservationId;

    private LinkedList<Reserva> reservas = new LinkedList<Reserva>();
    public int[][] mapaReservas;
  





    // Constructors 

    public Voo(String id){
        this.id=id;  
    }

    public Voo(String id, String tour){
            this.id=id;
            tourStr = tour;

            classeExec = 0;
            filasExec = 0;
            execPorFila = 0;

            classeTour=getSeats(tour);
            filasTour = getFilas(tour);
            filasTotal = filasTour;

            tourPorFila = getSeatsPerFila(tour);
            mapaReservas = new int[colsTotal][filasTotal];
            
            for (int i = 0; i < colsTotal; i++) {
                for (int j = 0; j < filasTotal; j++) {
                    mapaReservas[i][j] = 0;
                }
            }
        }

    public Voo(String id, String exec, String tour){
        this.id=id;
        execStr = exec;
        tourStr = tour;

        classeExec=getSeats(exec);
        classeTour=getSeats(tour);
        
        filasExec = getFilas(exec);
        filasTour = getFilas(tour);
        
        tourPorFila = getSeatsPerFila(tour);
        execPorFila = getSeatsPerFila(exec);

        filasTotal = filasExec + filasTour;
        colsTotal = Math.max(tourPorFila,execPorFila);

        mapaReservas = new int[colsTotal][filasTotal];

        // inicializa a matriz com zeros
        for (int i = 0; i < colsTotal; i++){
            for (int j = 0; j < filasTotal; j++){
                mapaReservas[i][j] = 0;
            }
        }
    }


    // getters and setters
     public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getClasseExec() {
        return classeExec;
    }

    public void setClasseExec(int classeExec) {
        this.classeExec = classeExec;
    }

    public int getClasseTour() {
        return classeTour;
    }

    public void setClasseTour(int classeTour) {
        this.classeTour = classeTour;
    }

    @Override
    public String toString(){
        if (classeExec == 0)
            return "Código de voo " + id + ". Lugares disponíveis: " + classeTour + " em classe Turística.\n Classe Executiva não disponível neste voo.\n";
        return "Código de voo " + id + ". Lugares disponíveis: " + classeExec + " em classe Executiva; "+ classeTour + " lugares em classe Turística.\n";
    } 
    


    //Funcoes

    public void addReservasFile(Reserva reserva){

        String classe = reserva.getClasse();
        
        boolean boolReserva;

        if (classe.equals("T")){
            boolReserva = addTour(reserva);
            ReservationId++;
        }

        else{
            boolReserva = addExec(reserva);
            ReservationId++;
        }
        if (!boolReserva)
            System.out.println("\nNao foi possível obter lugares para a reserva: " + reserva.toString());
        
        else {
            preencheVoo();
        }
    }
    
        public void addReserva(Reserva reserva){

            String classe = reserva.getClasse();
            boolean boolReserva;
    
            if (classe.equals("T")){
                boolReserva = addTour(reserva);
                ReservationId++;
            }
    
            else{
                boolReserva = addExec(reserva);
                ReservationId++;
            }
            if (!boolReserva)
                System.out.println("\nNao foi possível obter lugares para a reserva: " + reserva.toString());
            
            else {
                preencheVoo();
                printReserva(reserva);
            }
        }

    

    private boolean addTour(Reserva reserva){

        //verifica se ha lugares disponiveis
        if (classeTour - tourOcupados >= reserva.getNlugar()){
            tourOcupados += 1;
            reservas.add(reserva);
            return true;
        }

        return false;
    }


    private boolean addExec(Reserva reserva){

        
        //verifica se ha lugares disponiveis
        if (classeExec- execOcupados >= reserva.getNlugar()){
            execOcupados += 1;
            reservas.add(reserva);
            return true;
        }

        return false;
    }

    private void printReserva(Reserva reserva){
        int idReserva = reserva.getId();
        int numLugares = reserva.getNlugar();
        List<String> reservaSeats = new ArrayList<String> (); 
        char letra;
        int num;
        String seat;

        char fila = 'A';
        for (int j = 0; j < colsTotal; j++){
            for (int i = 0; i < filasTotal ; i++) {
                if (numLugares == 0) {
                    break;
                }
                if (mapaReservas[j][i] == idReserva) {
                    num = i + 1; /////
                    letra = fila;
                    seat = String.valueOf(num) + letra;
                    reservaSeats.add(seat);

                }
            }
            if (numLugares == 0) {
                break;
            }
            fila++;
        }

        Collections.sort(reservaSeats);
        
        System.out.print(id + ":" + numLugares + " =");

        for (int i = 0; i < reservaSeats.size(); i++){
            if (i == reservaSeats.size()-1){
                System.out.print(" " + reservaSeats.get(i));
            }
            else
                System.out.print(" " + reservaSeats.get(i) + " |");      
        }


        
    }
          
     public void preencheVooReserva(Reserva reserva){
         String classe = reserva.getClasse();

         if (classe.equals("E")) {
             // preenche as filas da classe executiv
              for (int j = 0; j < filasExec; j++){
                 for (int i = 0; i < execPorFila; i++) {

                     if (mapaReservas[i][j] == 0) {
                         mapaReservas[i][j] = reserva.getId();
                    
                     }
                 }
             
             }
         } else {
             // preenche as filas da classe turística
             for  (int j = filasExec; j < filasTotal; j++){
                 for  (int i = 0; i < tourPorFila; i++){
                
                     if (mapaReservas[i][j] == 0) {
                         mapaReservas[i][j] = reserva.getId();
                    
                     }
                 }
             
             }
         }
     }



   public void preencheVoo(){
  
    for (int i = 0; i < colsTotal; i++) {
        for (int j = 0; j < filasTotal; j++) {
            mapaReservas[i][j] = 0;
        }
    }
    // preenche a matriz com as reservas
    for (Reserva reserva : reservas) {
        String classe = reserva.getClasse();
        int numLugares = reserva.getNlugar();

        if (classe.equals("E")) {
            // preenche as filas da classe executiva
             for (int j = 0; j < filasExec; j++){
                for (int i = 0; i < execPorFila; i++) {
                    if (numLugares == 0) {
                        break;
                    }
                    if (mapaReservas[i][j] == 0) {
                        mapaReservas[i][j] = reserva.getId();
                        numLugares--;
                    }
                }
                if (numLugares == 0) {
                    break;
                }
            }
        } else {
            // preenche as filas da classe turística
            for  (int j = filasExec; j < filasTotal; j++){
                for  (int i = 0; i < tourPorFila; i++){
                    if (numLugares == 0) {
                        break;
                    }
                    if (mapaReservas[i][j] == 0) {
                        mapaReservas[i][j] = reserva.getId();
                        numLugares--;
                    }
                }
                if (numLugares == 0) {
                    break;
                }
            }
        }
         //lugares que nao existem
         if (tourPorFila > execPorFila){
            for (int j = 0; j < filasExec; j++){
                for (int i = execPorFila; i < tourPorFila; i++) {
                    if (mapaReservas[i][j] == 0) {
                        mapaReservas[i][j] = -1;
                    }
                }

            }
        }

        if (tourPorFila < execPorFila){
            for (int j = filasExec; j < filasTotal; j++){
                for (int i = tourPorFila; i < execPorFila; i++) {
                    if (mapaReservas[i][j] == 0) {
                        mapaReservas[i][j] = -1;
                    }
                }

            }
        }
    }
    
}


   public void mapaVoo() {

    // exibe o mapa das reservas
    // [ 1 2 3 4 5 6 ...]
    System.out.printf("%-2s","");
    for (int j = 1; j <= filasTotal; j++) {
        System.out.printf("%-3d", j);
    }
    System.out.println();


    char fila = 'A';
    for (int i = 0; i < colsTotal; i++) {
        System.out.printf("%-2s", fila++);
        for (int j = 0; j < filasTotal; j++) {
            if (mapaReservas[i][j] == -1){
                System.out.printf("%-3s", " ");
            }
            else{
                System.out.printf("%-3d", mapaReservas[i][j]);
            }
        }
        System.out.println();
    }
}
    
    public void cancelaReserva(int vooId){

        reservas.remove(vooId);
    }



    //Funçoes aux

    private int getSeats(String str){   //str = A x B

        String [] AxB = str.split("x");
        int seats = Integer.valueOf(AxB[0]) * Integer.valueOf(AxB[1]);

        return seats;
    }
    
    private int getFilas(String str){   //str = A x B

        String [] AxB = str.split("x");
        int filas = Integer.valueOf(AxB[0]);

        return filas;
    }

    private int getSeatsPerFila(String str){   //str = A x B

        String [] AxB = str.split("x");
        int seats = Integer.valueOf(AxB[1]);

        return seats;
    }
   

}
