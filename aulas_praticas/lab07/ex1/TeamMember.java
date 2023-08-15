public class TeamMember extends EmployeeDecorator {

    public TeamMember(InterfaceEmployee e){
        super(e);
    }

    public void colaborate() {
        String e_name = e.getName();
        System.out.printf("%s é team member.\n", e_name);
    }
}