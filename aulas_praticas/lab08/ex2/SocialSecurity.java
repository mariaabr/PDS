import java.util.*;

public class SocialSecurity {
    
    private static String name;
    private static int socialsecurity_number = -1;
    private static ArrayList<String> socialsecurity_list = new ArrayList<String>();

    public static void regist(Employee employee) {
        name = employee.getName();

        if(!socialsecurity_list.contains(name)){
            Random randomssnum = new Random();
            socialsecurity_number = randomssnum.nextInt(99999999 - 10000000 + 1) + 10000000;  //numero random de 8 digitos

            socialsecurity_list.add(name);
            System.out.println("EMPLOYEE -> " + name + ", Social Security number: " + socialsecurity_number );
        } else {
            System.out.println("Already registed:");
            System.out.println("EMPLOYEE -> " + name + ", Social Security number: " + socialsecurity_number);
        }
    }
}