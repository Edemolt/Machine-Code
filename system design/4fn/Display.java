
public class Display {

    public void displayData() {
        Data data = Data.getInstance();
        // Check if data is set
        if (data.getName() == null) {
            System.out.println("No data to display.");
        } else {
            System.out.println("Data details:");
            System.out.println("Name: " + data.getName());
            System.out.println("Size: " + data.getSize());
            System.out.println("Quantity: " + data.getQuantity());
            System.out.println("Price: " + data.getPrice());
        }
    }
}
