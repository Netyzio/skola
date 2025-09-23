public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank("Airbank");
        Bank bank0 = new Bank("Mbank");

        User a = new User("Petr Kukan");
        BankAccount a0 = new BankAccount(-1000, a, bank0);
        BankAccount a1 = new BankAccount(100, a, bank0);

        User b = new User("Petr Mesl");
        BankAccount b0 = new BankAccount(1000, b, bank0);
        BankAccount b1 = new BankAccount(1000, b, bank1);


        System.out.println(bank0.getUserCount());
        System.out.println(bank0.getTotalBalance());

        System.out.println(bank1.getUserCount());
        System.out.println(bank1.getTotalBalance());

        System.out.println(a0.isInDebt());
        System.out.println(a1.isInDebt());

    }
}
