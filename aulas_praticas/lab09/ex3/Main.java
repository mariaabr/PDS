//Command

package ex3;
import java.util.*;

@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args){

        Actioncontrol action = new Actioncontrol();
        Collection collection = new ArrayList<>();

        Command add = new AddCommand(collection);
        Command remove = new RemoveCommand(collection);

        action.setControl(add);
        action.execute("Caridade");
        action.execute("Berto");
        action.execute("Sardinha");
        action.execute("Pistacchio");
        action.execute("Filsons");
        action.execute("Natito");
        action.execute("Papi aokiii");
        action.execute("Vo tilde");

        System.out.println(collection);
        action.undo();
        System.out.println(collection);


        action.setControl(remove);
        action.execute("Vo tilde");
        action.execute("Timtim");

        action.undo();
        System.out.println(collection);

    }
}
