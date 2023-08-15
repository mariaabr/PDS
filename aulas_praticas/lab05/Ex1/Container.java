package Ex1;

public class Container extends PortionFactory {


    public static Container create(Portion portion) {
        
        if(portion.getState().equals(State.Liquid) && portion.getTemperature().equals(Temperature.COLD)){
            return new PlasticBottle(portion);
        } else if (portion.getState().equals(State.Liquid) && portion.getTemperature().equals(Temperature.WARM)){
            return new TermicBottle(portion);
        } else if (portion.getState().equals(State.Solid) && portion.getTemperature().equals(Temperature.COLD)){
            return new PlasticBag(portion);
        } else if(portion.getState().equals(State.Solid) && portion.getTemperature().equals(Temperature.WARM)){
            return new TupperWare(portion);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Container []";
    }
    
}
