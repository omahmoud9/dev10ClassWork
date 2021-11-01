public class Vault implements MoneyStorage  {
    private double balance;
    private String description;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean deposit(double amount) {
        if(amount > 0) {
            balance = balance + amount;
            return true;
        }
        return false;
    }

    public Vault(double balance, String description) {
        this.balance = balance;
        this.description = description;
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0.0) {
            return 0.0;
        }
        if (amount > balance){
            amount = balance;
            balance = 0;
            return amount;
        }

        double result = Math.min(amount, balance);
        balance -= result;
        return result;
    }
}
