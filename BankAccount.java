class BankAccount implements ATM {
    private double balance;
    private static final String LOG_FILE = "transaction_log.txt";

    public BankAccount(double initialDeposit) {
        this.balance = initialDeposit;
        logTransaction("Account created with balance: " + balance);
    }

    @Override
    public double getBalance() {
        logTransaction("Checked balance: " + balance);
        return balance;
    }

    @Override
    public boolean getCash(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            logTransaction("Withdrawn: " + amount + ", Remaining Balance: " + balance);
            return true;
        } else {
            logTransaction("Failed withdrawal attempt: " + amount);
            return false;
        }
    }
    
    public void depositCash(double amount) {
        if (amount > 0) {
            balance += amount;
            logTransaction("Deposited: " + amount + ", New Balance: " + balance);
        }
    }

    private void logTransaction(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(message);
        } catch (IOException e) {
            System.out.println("Error logging transaction: " + e.getMessage());
        }
    }
}