
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Add addObj = new Add();
        Update updateObj = new Update();
        Remove removeObj = new Remove();
        Display displayObj = new Display();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean running = true;
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Data");
            System.out.println("2. Update Data");
            System.out.println("3. Remove Data");
            System.out.println("4. Display Data");
            System.out.println("5. Exit");
            try {
                int choice = Integer.parseInt(br.readLine());
                switch (choice) {
                    case 1:
                        addObj.addData();
                        break;
                    case 2:
                        updateObj.updateData();
                        break;
                    case 3:
                        removeObj.removeData();
                        break;
                    case 4:
                        displayObj.displayData();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (IOException e) {
                System.out.println("IO Exception: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
