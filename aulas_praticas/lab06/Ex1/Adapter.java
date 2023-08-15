public class Adapter extends Database {

    private Registos registos;

    public Adapter(Registos registos) {
        super();
        this.registos = registos;
    }

    public void addEmployee(Empregado employee) {
        // Code to add employee
        registos.insere(employee);
    }
    
    public void deleteEmployee(int emp_num) {
        // Code to delete employee
        // for(Empregado emp : registos.listaDeEmpregados()){
        //     if(emp.codigo() == emp_num){
        //         registos.remove(emp_num);
        //     }
        // }

        for(Empregado emp : registos.listaDeEmpregados()){
             if(emp.codigo() == emp_num){
                registos.listaDeEmpregados();
                registos.listaDeEmpregados().remove(emp);
            }
        }
    }

    public boolean isEmpregado(int codigo) {
        // Code to find employee
        for(Empregado emp : registos.listaDeEmpregados()){
            if(emp.codigo() == codigo){
                return true;
            }
        }
        return false;
    }

    public void all_employees_print() {
        // Code to retrieve collection
        for(Empregado emp : registos.listaDeEmpregados()){
            if(emp != null){
                System.out.println(emp);
            }
        }
    }
}