public class BankAccount {
    private final double balance;
    private final User fullName;
    private final Bank bankName;

    public BankAccount(double balance, User fullName, Bank bankName) {
        this.fullName = fullName;
        this.balance = balance;
        this.bankName = bankName;
        bankName.addAccoount(this);
        bankName.addFullName(this);
    }


    public boolean isInDebt() {
        return balance < 0;
    }

    public double getBalance() {
        return balance;
    }

    public User getFullName() {
        return fullName;
    }

}
