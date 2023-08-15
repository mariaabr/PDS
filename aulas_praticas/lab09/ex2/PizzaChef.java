package ex2;

public class PizzaChef extends Chef {

    @Override
    public void parse(String request){
        if (canHandleRequest(request, "Pizza")) {
            System.out.printf("PizzaChef : Starting to cook %s. Out in %d minutes.\n", request, this.randomTime("PizzaChef"));
        } else {
            System.out.println("PizzaChef : I can't cook that.");
            super.parse(request);
        }
    }
    
}