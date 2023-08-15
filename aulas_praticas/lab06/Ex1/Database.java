import java.util.*;

public class Database {
    
    private Vector<Employee> employees; // Stores the employees
    
    public Database() {
        employees = new Vector<>();
    }
    
    public boolean addEmployee(Employee employee) {
        // Code to add employee
        for(Employee e : employees)
            if (employee == e )
                return false;
        return employees.add(employee);
    }
    
    public void deleteEmployee(long emp_num) {
        // Code to delete employee
        for(Employee e : employees){
            if (e.getEmpNum() == emp_num){
                employees.remove(e);
                break;
            }
        }
    }

    public Employee[] getAllEmployees() {
        // Code to retrieve collection
        Employee[] employees_collection = new Employee[employees.size()];
        for (int i = 0; i < employees.size(); i++){
            employees_collection[i] = employees.get(i);
        }
        return employees_collection;
    }

    @Override
    public String toString() {
        return "Database [employees = " + employees + "]";
    }
}
