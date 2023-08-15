package ex2;

public class DessertChef extends Chef {

    @Override
    public void parse(String request){
        if (canHandleRequest(request, "Dessert")) {
            System.out.printf("DessertChef : Starting to cook %s. Out in %d minutes.\n", request, this.randomTime("DessertChef"));
        } else {
            System.out.println("DessertChef : I can't cook that.");
            super.parse(request);
        }
    }
    
}