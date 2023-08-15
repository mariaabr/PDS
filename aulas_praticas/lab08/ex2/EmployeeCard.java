import java.util.*;

public class EmployeeCard {

    private static String name;
    private static int card_number = -1;
    private static ArrayList<Integer> employees_cards = new ArrayList<Integer>();

    // public EmployeeCard() {
	// 	this.employees_cards = new ArrayList<Integer>();
	// }

    public static void createCardNumber(Employee employee) {
        name = employee.getName();

        if(!employees_cards.contains(card_number)){
            Random randomcard = new Random();
            card_number = randomcard.nextInt(99999999 - 10000000 + 1) + 10000000;  //numero random de 8 digitos

            employees_cards.add(card_number);
            System.out.println("EMPLOYEE -> " + name + ", card: " + card_number);
        } else {
            System.out.println("Already as a card number:");
            System.out.println("EMPLOYEE -> " + name + ", card: " + card_number);
        }
    }

    public String getemployeecards() {
		return "EMPLOYEE -> " + name + ", card: " + card_number;
	}
}
