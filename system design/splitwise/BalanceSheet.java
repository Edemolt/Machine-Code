
import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {

    private int totalSpent;
    private int totalOwed;

    // Separate maps for amounts the current user has lent and owes
    private Map<User, Integer> owedMap; // Money I owe to others (key: creditor)
    private Map<User, Integer> lentMap; // Money others owe me (key: debtor)

    public BalanceSheet() {
        totalSpent = 0;
        totalOwed = 0;
        owedMap = new HashMap<>();
        lentMap = new HashMap<>();
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public int getTotalOwed() {
        return totalOwed;
    }

    public int getOwedTo(User user) {
        return owedMap.getOrDefault(user, 0);
    }

    public int getLentTo(User user) {
        return lentMap.getOrDefault(user, 0);
    }

    // Record that the current user owes 'sum' to the given user (creditor)
    public void addOwed(User creditor, int sum) {
        int newVal = owedMap.getOrDefault(creditor, 0) + sum;
        owedMap.put(creditor, newVal);
        totalOwed += sum;
    }

    // Record that the current user lent 'sum' to the given user (debtor)
    public void addLent(User debtor, int sum) {
        int newVal = lentMap.getOrDefault(debtor, 0) + sum;
        lentMap.put(debtor, newVal);
        totalSpent += sum;
    }

    // Example method to print a summary balance for those who owe the user money.
    public void printBalanceSheet() {
        for (User key : lentMap.keySet()) {
            int amount = lentMap.get(key);
            if (amount > 0) {
                System.out.println(key.getUserName() + " owes you " + amount);
            }
        }
    }
}
