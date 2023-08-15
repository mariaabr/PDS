package lab03;

public class Aviao {
    
    private int lugares_t; //lugares por fila da classe turisticas
    private int lugares_e; //lugares por fila da classe executiva
    private int filas_t; //numero de filas da classe turistica
    private int filas_e; //numero de filas da classe executiva


    public Aviao(int lugares_t, int lugares_e, int filas_t, int filas_e) {
        this.lugares_t = lugares_t;
        this.lugares_e = lugares_e;
        this.filas_t = filas_t;
        this.filas_e = filas_e;
    }


    public Aviao(int lugares_t, int filas_t) {
        this.lugares_t = lugares_t;
        this.filas_t = filas_t;
        this.lugares_e = 0;
    }


    public int getLugares_t() {
        return lugares_t;
    }


    public void setLugares_t(int lugares_t) {
        this.lugares_t = lugares_t;
    }


    public int getLugares_e() {
        return lugares_e;
    }


    public void setLugares_e(int lugares_e) {
        this.lugares_e = lugares_e;
    }


    public int getFilas_t() {
        return filas_t;
    }


    public void setFilas_t(int filas_t) {
        this.filas_t = filas_t;
    }


    public int getFilas_e() {
        return filas_e;
    }


    public void setFilas_e(int filas_e) {
        this.filas_e = filas_e;
    }

}
