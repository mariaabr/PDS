import java.util.*;

public class Parking {

    // private static Company company = new Company();
    private static ArrayList<String> parking_list = new ArrayList<String>(); 
    
    // public Parking(){
    //     this.parking_list = new ArrayList<String>();
    // }

    public static boolean allow (Employee name){
        if(name.getSalary() > Company.salaryMedio()){
            parking_list.add(name.getName());
            System.out.println(name.getName() + " allowed to parking.");
            // System.out.println("EMPLOYEE -> " + name);
            return true;
        } else {
            System.out.println(name.getName() + " not allowed to parking.");
            return false;
        }
    }

    public ArrayList<String> getAllowedEmployees(){
        return this.parking_list;
    }
}
