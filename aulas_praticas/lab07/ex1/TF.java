import java.util.Date;

public class TF {

    public static void main(String[] args) {

        InterfaceEmployee e1 = new Employee("Maria Albertina");

        Manager m1 = new Manager( new Employee("Norberto"));
        TeamLeader l1 = new TeamLeader( new Employee("Cremelinda"));
        TeamLeader l2 = new TeamLeader(e1);
        TeamLeader l3 = new TeamLeader(m1);
        TeamMember tm1 = new TeamMember(e1);
        TeamMember tm2 = new TeamMember(new TeamLeader(new Manager(new Employee("Amora"))));

        InterfaceEmployee lista_employees[] = {e1, m1, l1, l2, l3, tm1, tm2};
        for (InterfaceEmployee emp : lista_employees){
            emp.start(new Date());
            emp.work();

            if (emp instanceof TeamMember) {
                TeamMember tm = (TeamMember) emp;
                tm.colaborate();
            }
            if (emp instanceof TeamLeader) {
                TeamLeader l = (TeamLeader) emp;
                l.plan();
            }
            if (emp instanceof Manager) {
                Manager m = (Manager) emp;
                m.manage();
            }

            emp.terminate(new Date());
        }
    }
    
}