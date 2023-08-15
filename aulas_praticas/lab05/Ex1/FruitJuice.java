package Ex1; 

public class FruitJuice extends PortionFactory {

    String fruit_name;

    public FruitJuice(String fruit_name, Temperature temperature) {
        super();
        this.fruit_name = fruit_name;
        this.setTemperature(temperature);
        this.setState(State.Liquid);
    }

    @Override
    public String toString() {
        return "FruitJuice: " + this.fruit_name + ", Temperature " + this.getTemperature() + ", State " + this.getState();
    }
}