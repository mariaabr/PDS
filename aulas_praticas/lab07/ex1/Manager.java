public class Manager extends EmployeeDecorator {

    public Manager(InterfaceEmployee e){
        super(e);
    }

    public void manage(){
        String e_name = e.getName();
        System.out.printf("%s é manager.\n",e_name);
    } 
}