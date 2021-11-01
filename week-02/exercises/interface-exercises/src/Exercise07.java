import java.util.Scanner;

public class Exercise07 {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        MoneyStorage storage = getStorage();
        String input;
        do {
            print(storage);

            System.out.println("Choose an action:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Select [1-3]:");

            input = console.nextLine();

            if (input.equals("1")) {
                makeDeposit(storage);
            } else if (input.equals("2")) {
                makeWithdrawal(storage);
            }

        } while (!input.equals("3"));

        System.out.println("Goodbye.");
    }

    static MoneyStorage getStorage() {

        System.out.println("Choose a place to store your money:");
        System.out.println("1. Wallet");
        System.out.println("2. Mortgage");
        System.out.println("3. Vault");
        System.out.println("4. Bank Account");

        String input;
        do {
            System.out.print("Select [1-4]:");
            input = console.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Starting Balance");
                    int startingBalance = Integer.parseInt(console.nextLine());
                    System.out.println("Wallet Description");
                    String description = console.nextLine();
                    MoneyStorage wallet = new Wallet(startingBalance, description);
                    return wallet;
                case "2":
                    System.out.println("Starting Balance");
                    startingBalance = Integer.parseInt(console.nextLine());
                    System.out.println("Mortgage Account number");
                    description = console.nextLine();
                    MoneyStorage mortgage = new Mortgage(startingBalance, description);
                    return mortgage;
                case "3":
                    System.out.println("Starting Balance");
                    startingBalance = Integer.parseInt(console.nextLine());
                    System.out.println("Vault number");
                    description = console.nextLine();
                    MoneyStorage vault = new Vault(startingBalance, description);
                    return vault;
                case "4":
                    System.out.println("Starting Balance");
                    startingBalance = Integer.parseInt(console.nextLine());
                    System.out.println("Account number");
                    description = console.nextLine();
                    MoneyStorage bankAccount = new BankAccount(startingBalance, description);
                    return bankAccount;
            }
        } while (!(input.length() == 1 && input.charAt(0) >= '1' && input.charAt(0) <= '4'));

        // 1. Add a switch statement to handle options 1 - 4.
        // 2. For each option, create a method that returns a MoneyStorage of the appropriate type:
        // 1 == Wallet, 2 == Mortgage, 3 == Vault, 4 == Bank Account
        // Prompt the user for data. Data should be specific to the type:
        // - a starting balance
        // - description for a Wallet
        // - accountNumber for Mortgage and BankAccount
        // - for Vault?

        // 3. Return the Wallet, Mortgage, Vault, or Bank Account instead of null.
//        System.out.println("You messed up");
        return null;
    }

    static void print(MoneyStorage storage) {
        System.out.println();
        System.out.println(storage.getDescription());
        System.out.println("=".repeat(storage.getDescription().length()));
        System.out.printf("Current balance: $%.2f%n", storage.getBalance());
        System.out.println();
    }

    static void makeDeposit(MoneyStorage storage) {
        System.out.print("Amount to deposit:");
        double amt = Double.parseDouble(console.nextLine());
        storage.deposit(amt);
    }

    static void makeWithdrawal(MoneyStorage storage) {
        System.out.print("Amount to withdraw:");
        double amt = Double.parseDouble(console.nextLine());
        double withdrawn = storage.withdraw(amt);
        System.out.printf("Withdrawn: $%.2f%n", withdrawn);
    }
}
