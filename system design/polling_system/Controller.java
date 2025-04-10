
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Controller {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8080);

        // Initialize the input and output streams once, outside the loop.
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            while (true) {
                System.out.println("Enter 1 to register as voter");
                System.out.println("Enter 2 to register as candidate");
                System.out.println("Enter 3 to cast vote");
                System.out.println("Enter 4 to get vote count");
                System.out.println("Enter 5 to exit");

                String input = System.console().readLine();
                if (input == null) {
                    System.out.println("No console available. Exiting.");
                    break;
                }
                int choice = Integer.parseInt(input);

                // Send the choice to the server.
                out.println(choice);

                if (choice == 1) {
                    // Voter registration
                    System.out.println("Enter your name:");
                    String name = System.console().readLine();
                    out.println(name);

                    System.out.println("Enter your age:");
                    String age = System.console().readLine();
                    out.println(age);

                    System.out.println("Enter your voter ID:");
                    String voterId = System.console().readLine();
                    out.println(voterId);

                    // Read and print server confirmation.
                    System.out.println(in.readLine());

                } else if (choice == 2) {
                    // Candidate registration
                    System.out.println("Enter your name:");
                    String name = System.console().readLine();
                    out.println(name);

                    System.out.println("Enter your age:");
                    String age = System.console().readLine();
                    out.println(age);

                    System.out.println("Enter your candidate ID:");
                    String candidateId = System.console().readLine();
                    out.println(candidateId);

                    System.out.println("Enter your party affiliation:");
                    String partyAffiliation = System.console().readLine();
                    out.println(partyAffiliation);

                    // Read and print server confirmation.
                    System.out.println(in.readLine());

                } else if (choice == 3) {
                    // Cast vote: expects voter ID then candidate ID
                    System.out.println("Enter your voter ID:");
                    String voterId = System.console().readLine();
                    out.println(voterId);

                    System.out.println("Enter candidate ID to vote for:");
                    String candidateId = System.console().readLine();
                    out.println(candidateId);

                    // Read and print server confirmation.
                    System.out.println(in.readLine());

                } else if (choice == 4) {
                    // Get vote count
                    System.out.println("Vote Count:");
                    System.out.println(in.readLine());

                } else if (choice == 5) {
                    System.out.println("Exiting.");
                    break; // Exit the loop.
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
