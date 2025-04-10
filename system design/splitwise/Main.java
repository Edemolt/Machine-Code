
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Group grp = new Group("Kharcha");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("Enter 1 to add new member");
            System.out.println("Enter 2 to add a new Expense split");
            System.out.println("Enter 3 to check particulars of an individual");
            System.out.println("Enter 4 to exit");

            int resp = sc.nextInt();
            if (resp == 1) {
                System.out.println("Enter the member name:");
                String name = sc.next();
                User newUser = new User(name);
                grp.addMember(newUser);
            } else if (resp == 2) {
                System.out.println("Enter the total money, spender name, ratio1 (for spender) and ratio2 (for receiver):");
                int money = sc.nextInt();
                String spenderName = sc.next();
                int ratio1 = sc.nextInt();
                int ratio2 = sc.nextInt();

                User spenderUser = grp.getMember(spenderName);
                if (spenderUser == null) {
                    System.out.println("Spender is not a member of the group.");
                    continue;
                }

                grp.addExpense(spenderUser, money, ratio1, ratio2);
                System.out.println("Expense added successfully.");
            } else if (resp == 3) {
                System.out.println("Enter the user for whom you want to check details:");
                String name = sc.next();
                User user = grp.getMember(name);
                if (user == null) {
                    System.out.println("User not found in the group.");
                    continue;
                }
                // Start a loop to allow multiple queries for this user.
                while (true) {
                    System.out.println("\nDetail Menu for " + user.getUserName() + ":");
                    System.out.println("Enter 1 to check total spent and owed");
                    System.out.println("Enter 2 to check total lent to a particular user");
                    System.out.println("Enter 3 to check total owed to a particular user");
                    System.out.println("Enter 4 to return to main menu");

                    int input = sc.nextInt();
                    if (input == 4) {
                        break; // Exit the detail query loop and return to the main menu.
                    } else if (input == 1) {
                        // printBalance() shows both total spent and total owed.
                        user.printBalance();
                    } else if (input == 2) {
                        System.out.println("Enter the name of the user to whom you lent money:");
                        String otherName = sc.next();
                        User other = grp.getMember(otherName);
                        if (other == null) {
                            System.out.println("User not found.");
                        } else {
                            user.printLentTo(other);
                        }
                    } else if (input == 3) {
                        System.out.println("Enter the name of the user from whom you owe money:");
                        String otherName = sc.next();
                        User other = grp.getMember(otherName);
                        if (other == null) {
                            System.out.println("User not found.");
                        } else {
                            user.printOwedTo(other);
                        }
                    } else {
                        System.out.println("Invalid option, please try again.");
                    }
                }
            } else if (resp == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }

        sc.close();
    }
}
