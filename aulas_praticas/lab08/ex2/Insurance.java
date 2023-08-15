import java.util.*;

public class Insurance {
    
    private static String name;
    private static int insurance_number = -1;
    private static ArrayList<String> insurance_list = new ArrayList<String>();

    public static void regist(Employee employee) {
        name = employee.getName();

        if(!insurance_list.contains(name)){
            Random randominsnum = new Random();
            insurance_number = randominsnum.nextInt(99999999 - 10000000 + 1) + 10000000;  //numero random de 8 digitos

            insurance_list.add(name);
            System.out.println("EMPLOYEE -> " + name + ", Insurance number: " + insurance_number );
        } else {
            System.out.println("Already registed:");
            System.out.println("EMPLOYEE -> " + name + ", Insurance number: " + insurance_number);
        }
    }
}
