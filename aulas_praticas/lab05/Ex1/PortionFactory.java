package Ex1; 

import java.util.*;

public class PortionFactory implements Portion{

    Temperature temperature;
    State state;
    
    public PortionFactory() {
    }

    
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }


    public void setState(State state) {
        this.state = state;
    }

    public static Portion create(String food_type, Temperature temperature) {
        
        if(food_type.equals("Beverage") && temperature.equals(Temperature.COLD)){
            Scanner fruits_input = new Scanner(System.in);
            System.out.print("Fruta(s) do sumo: ");
            String fruit_name = fruits_input.nextLine();
            fruits_input.close();

            return new FruitJuice(fruit_name, temperature);
        } else if (food_type.equals("Beverage") && temperature.equals(Temperature.WARM)){
            return new Milk(temperature);
        } else if (food_type.equals("Meat") && temperature.equals(Temperature.COLD)){
            return new Tuna(temperature);
        } else if(food_type.equals("Meat") && temperature.equals(Temperature.WARM)){
            return new Pork(temperature);
        }
        return null;
    }


    @Override
    public Temperature getTemperature() {
        return this.temperature;
    }

    @Override
    public State getState() {
        return this.state;
    }

    
}