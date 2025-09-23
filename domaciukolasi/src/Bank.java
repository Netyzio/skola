import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Bank {

    private final String name;
    private final ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    private final ArrayList<BankAccount> fullNames = new ArrayList<BankAccount>();

    public Bank(String name) {

        this.name = name;
    }

    public void addAccoount(BankAccount account) {
        accounts.add(account);
    }

    public void addFullName(BankAccount fullName) {
        fullNames.add(fullName);
    }


    public int getTotalBalance() {
        int total = 0;
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount account = accounts.get(i);
            total += (int) account.getBalance();
        }
        return total;
    }

    public int getUserCount() {
        Set<User> uniqueUsers = new HashSet<>();

        for (int i = 0; i < accounts.size(); i++) {
            uniqueUsers.add(accounts.get(i).getFullName());
        }

        return uniqueUsers.size();
    }


}
