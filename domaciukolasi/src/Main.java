public class Main {
    public static void main(String[] args) {

        User lukas = new User("Lukas", "Sasek", 11);
        BankAccount account001 = new BankAccount("62101", -1000000, lukas);

        User petr = new User("Petr", "Kukan", 16);
        BankAccount account002 = new BankAccount("62102", 1000000, petr);


        Bank mbank = new Bank("6210","MBank");


    }
}