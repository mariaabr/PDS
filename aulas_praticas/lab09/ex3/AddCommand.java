package ex3;
import java.util.*;

public class AddCommand<T> implements Command<T> {
    private Collection<T> collection;
    private T last_element;
    private boolean undo = false;

    public AddCommand(Collection<T> collection){
        this.collection = collection;
    }

    // execute - add
    public boolean execute (T element) {
        boolean res = this.collection.add(element);
        if(res){
            this.last_element = element;
            this.undo = true;
        }
        return res; 
    }

    // undo
    public boolean undo(){
        if(undo){
            boolean res = this.collection.remove(last_element);
                this.undo = false;
                return res;
        }
        System.out.println("Can't undo!");
        return false;
    }
}
