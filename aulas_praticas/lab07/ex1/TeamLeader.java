public class TeamLeader extends EmployeeDecorator {

    public TeamLeader(InterfaceEmployee e){
        super(e);
    }

    public void plan() {
        String e_name = e.getName();
        System.out.printf("%s é team leader.\n", e_name);
    }

}