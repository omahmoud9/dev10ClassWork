public class BankAccount implements MoneyStorage {
    private double Balance;
    private String Description;

    public BankAccount(double balance, String description) {
        Balance = balance;
        Description = description;
    }

    @Override
    public double getBalance() {
        return Balance;
    }

    @Override
    public String getDescription() {
        return Description;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            Balance = Balance + amount;
            return true;
        }
        return false;
    }

    @Override
    public double withdraw(double amount) {
        if (Balance <= -25)  {
            return 0;
        }if(Balance > -25){
            if(amount > Balance + 25 ){
                return 0;
            }else if(amount < Balance + 25){
                Balance = Balance - amount;
                return amount;
            }
        }
        return 0;
    }
}
