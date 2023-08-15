import java.util.*;

abstract class EmployeeDecorator implements InterfaceEmployee {

    protected InterfaceEmployee e;

    public EmployeeDecorator(InterfaceEmployee e){
        this.e = e;
    }

    public void start(Date date){ e.start(date); }
    public void terminate(Date date){e.terminate(date); }
    public void work(){e.work();}
    public String getName() { return e.getName();}
    
}