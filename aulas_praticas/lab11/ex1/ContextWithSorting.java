package lab11.ex1;

public class ContextWithSorting {

    private final SortStrategy strategy;

    public ContextWithSorting(SortStrategy strategy){
        this.strategy=strategy;
    }

    public void sort(Telemovel[] telemovel){
        strategy.sort(telemovel);
    }
}
