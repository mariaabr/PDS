import java.util.Date;

public class Employee implements InterfaceEmployee {

    private String name;

    public Employee(String n){
        this.name = n;
    }

    @Override
    public void start(Date date) {
        System.out.printf("%s começou a trabalhar na empresa no dia %s.\n",name, date.toString());
    }

    @Override
    public void terminate(Date date) {
        System.out.printf("%s deixou de trabalhar na empresa no dia %s.\n",name, date.toString());
    }

    @Override
    public void work() {
        System.out.printf("%s está a trabalhar na empresa. ",name);
    }
    
    @Override
    public String getName() {
        return this.name;
    }

}