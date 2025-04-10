
public class User {

    private String username;
    private BalanceSheet balanceSheet;

    public User(String name) {
        username = name;
        balanceSheet = new BalanceSheet();
    }

    public String getUserName() {
        return username;
    }

    public void printBalance() {
        System.out.println("You have spent: " + balanceSheet.getTotalSpent());
        System.out.println("You owe others: " + balanceSheet.getTotalOwed());
    }

    public void addOwed(User spender, int sum) {
        balanceSheet.addOwed(spender, sum);
    }

    public void addLent(User receiver, int sum) {
        balanceSheet.addLent(receiver, sum);
    }

    public void printOwedTo(User user) {
        System.out.println("You owe " + user.getUserName() + ": " + balanceSheet.getOwedTo(user));
    }

    public void printLentTo(User user) {
        System.out.println("You lent " + user.getUserName() + ": " + balanceSheet.getLentTo(user));
    }
}
