import java.util.*;

class Company {

public static User user;
private static List<Employee> emps = new ArrayList<>();

// private Insurance insurance = new Insurance();
// private Parking parking = new Parking();
// private EmployeeCard employeeCard;
// private SocialSecurity socialSecurity;

	public void admitEmployee(Person person, double salary) {
		Employee e = new Employee(person.getName(), salary);
		emps.add(e);

		SocialSecurity.regist(e);
		Insurance.regist(e);
		EmployeeCard.createCardNumber(e);
		Parking.allow(e);

	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

	public static double salaryMedio(){
        double salarySum = 0;
        for (Employee employee : emps){
            salarySum += employee.getSalary();
        }
        return (double) salarySum/emps.size();
    }
}