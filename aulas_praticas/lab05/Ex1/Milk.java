package Ex1; 

public class Milk extends PortionFactory {
    
    public Milk(Temperature temperature) {
        super();
        this.setTemperature(temperature);
        this.setState(State.Liquid);
    }

    @Override
    public String toString() {
        return "Milk: Temperature " + this.getTemperature() + ", State " + this.getState();
    }
}
