package lab03.gestor_aviao;

public class Reserva {

    private int id;
    private String classe;
    private int nlugar;
    

    // Constructors 

    public Reserva(int id, String classe, int nlugar){
        this.id = id;
        this.classe=classe;
        this.nlugar=nlugar;
    }

   //public Reserva(String classe, int nlug, int id){
   //    this.classe=classe;
   //    this.nlug=nlug;
   //    this.id=id;
   //}

   // getters and setters
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getNlugar() {
        return nlugar;
    }

    public void setNlugares(int nlugar) {
        this.nlugar = nlugar;
    }


     public String toID(){
        return String.valueOf(id);
    }

    @Override
    public String toString(){
        return classe + " " + nlugar;
    }
    
}