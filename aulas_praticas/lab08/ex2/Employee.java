
class Employee extends Person {

	private double salary;
	private BankAccount bankAccount;
	
	public Employee(String n, double s) {
		super(n);
		salary = s;
		this.bankAccount = new BankAccountImpl("PeDeMeia", 0);
	}

	public double getSalary() {
		return salary;
	}

	public BankAccount getBankAccount() {
		return this.bankAccount;
	}
}