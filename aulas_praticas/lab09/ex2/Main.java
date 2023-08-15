//Chain of responsibility

package ex2;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        ArrayList <String> requestList = new ArrayList<>();

        requestList.add("veggie burger");
        requestList.add("Pasta Carbonara");
        requestList.add("PLAIN pizza, no toppings!");
        requestList.add("sushi nigiri and sashimi"); 
        requestList.add("salad with tuna");
        requestList.add("strawberry ice cream and waffles dessert"); 

        Chef chef = new SushiChef().setSucessor(new PastaChef().setSucessor(new BurgerChef().setSucessor(new PizzaChef().setSucessor(new DessertChef()))));
        
        for (String request : requestList){
            System.out.println("Can I please get a " + request + "?");
            chef.parse(request);
        }
    }
    
}
