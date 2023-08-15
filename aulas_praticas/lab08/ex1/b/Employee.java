
class Employee {

private double salary;
private Person name;
private BankAccount bankAccount;
	
	public Employee(Person n, double s) {
		this.name = n;
		this.salary = s;
		this.bankAccount = new BankAccountProxy(new BankAccountImpl("PeDeMeia", 0));
	}

	public double getSalary() {
		return salary;
	}

	public Person getName() {
		return name;
	}

	public BankAccount getBankAccount() {
		return this.bankAccount;
	}
}