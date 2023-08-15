import java.util.*;

public class Registos {
    
    // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees
    
    public Registos() {
        empregados = new ArrayList<>();
    }
    
    public void insere(Empregado emp) {
        // Code to insert employee
        empregados.add(emp);
    }
    
    public void remove(int codigo) {
        // Code to remove employee
        for(Empregado emp : empregados){
            if(emp.codigo() == codigo){
                empregados.remove(emp);
            }
        }
    }
    
    public boolean isEmpregado(int codigo) {
        // Code to find employee
        for(Empregado emp : empregados){
            if(emp.codigo() == codigo){
                return true;
            }
        }
        return false;
    }
    
    public List<Empregado> listaDeEmpregados() {
        // Code to retrieve collection
        List<Empregado> list_empregados = new ArrayList<Empregado>(empregados.size());
        
        for(int i = 0; i < empregados.size(); i++){
            Empregado e = empregados.get(i);
            list_empregados.add(i, e);
        }

        return list_empregados;
    }

    @Override
    public String toString() {
        return "Registos [empregados = " + empregados + "]";
    }
}
