package Ex1;

public class Tuna extends PortionFactory{

    public Tuna(Temperature temperature) {
        super();
        this.setTemperature(temperature);
        this.setState(State.Solid);
    }

    @Override
    public String toString() {
        return "Tuna: Temperature " + this.getTemperature() + ", State " + this.getState();
    }

}