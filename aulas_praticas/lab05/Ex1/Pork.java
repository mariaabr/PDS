package Ex1; 

public class Pork extends PortionFactory{
    
    public Pork(Temperature temperature) {
        super();
        this.setTemperature(temperature);
        this.setState(State.Solid);
    }

    @Override
    public String toString() {
        return "Pork: Temperature " + this.getTemperature() + ", State " + this.getState();
    }
}