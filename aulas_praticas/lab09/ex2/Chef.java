package ex2;

abstract class Chef{

    private Chef sucessorChef = null;

    public void parse (String request){
        if(sucessorChef!=null){
            sucessorChef.parse(request);
        } else{
            System.out.println("We're sorry but that request can't be satisfied by our service!");
        }
    }

    protected boolean canHandleRequest(String request, String food_type){
        return (request == null) ||  (request.toLowerCase().contains(food_type.toLowerCase()));
    }

    public Chef setSucessor(Chef sucessorChef){
        this.sucessorChef = sucessorChef;
        return this;
    }

    protected int randomTime(String chef){
        int time = 0;
        if (chef == "SushiChef") {
            time=14;
        } else if (chef == "PastaChef") {
            time=14;
        } else if (chef == "BurgerChef") {
            time=19;
        } else if (chef == "PizzaChef") {
            time=7;
        } else if (chef == "DessertChef") {
            time=17;
        }
        return time;
    }
}