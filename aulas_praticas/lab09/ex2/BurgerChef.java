package ex2;

public class BurgerChef extends Chef {

    @Override
    public void parse(String request){
        if (canHandleRequest(request, "Burger")) {
            System.out.printf("BurgerChef : Starting to cook %s. Out in %d minutes.\n", request, this.randomTime("BurgerChef"));
        } else {
            System.out.println("BurgerChef : I can't cook that.");
            super.parse(request);
        }
    }
    
}