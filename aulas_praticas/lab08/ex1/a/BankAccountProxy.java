public class BankAccountProxy implements BankAccount {
    
    private BankAccountImpl bank_account;

	BankAccountProxy(BankAccountImpl bank_account) {
        this.bank_account = bank_account;
		
	}

    @Override
    public void deposit(double amount) {
        this.bank_account.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (Company.user == User.OWNER){
            return this.bank_account.withdraw(amount); 
        } else{
            System.out.println("You don't have access to this information");
            return false;
        }
    }

    @Override
    public double balance() {
        if (Company.user == User.OWNER){
           return this.bank_account.balance();
        } else{
            System.out.println("You don't have access to this information");
            return -1;
        }
    }
}
