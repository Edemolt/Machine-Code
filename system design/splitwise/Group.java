
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {

    private UUID groupId;
    private String groupName;
    private List<User> members;

    public Group(String name) {
        groupId = UUID.randomUUID();
        groupName = name;
        members = new ArrayList<>();
    }

    public void addMember(User user) {
        if (members.contains(user)) {
            System.out.println("Already a member, cannot add again.");
        } else {
            members.add(user);
            System.out.println(user.getUserName() + " added to group.");
        }
    }

    // Added method to retrieve a member by username
    public User getMember(String username) {
        for (User u : members) {
            if (u.getUserName().equals(username)) {
                return u;
            }
        }
        return null;
    }

    // Add an expense with split rules. Assumes ratio1 and ratio2 sum to 100.
    public void addExpense(User spender, int sum, int ratio1, int ratio2) {
        if (members.size() < 2) {
            System.out.println("Not enough members to split expense.");
            return;
        }

        int numberOfReceivers = members.size() - 1;

        // Calculate each receiver’s share based on the provided ratios.
        int spenderCost = ((sum * ratio1) / 100) / numberOfReceivers;
        int receiverCost = ((sum * ratio2) / 100) / numberOfReceivers;

        // Loop through all members excluding the spender.
        for (User user : members) {
            if (user != spender) {
                // The spender lent money to the receiver.
                spender.addLent(user, spenderCost);
                // The receiver owes money to the spender.
                user.addOwed(spender, receiverCost);
            }
        }
    }
}
