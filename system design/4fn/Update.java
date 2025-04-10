// Update.java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Update {

    public void updateData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Data data = Data.getInstance();

        System.out.println("Enter the name for which you want to update the details:");
        String inputName = br.readLine();

        // Check if the provided name matches the data's name (ignoring case)
        if (data.getName() != null && data.getName().equalsIgnoreCase(inputName)) {
            System.out.println("Enter the new size (integer):");
            int size = Integer.parseInt(br.readLine());

            System.out.println("Enter the new quantity (integer):");
            int quantity = Integer.parseInt(br.readLine());

            System.out.println("Enter the new price (integer):");
            int price = Integer.parseInt(br.readLine());

            // Update the fields
            data.setSize(size);
            data.setQuantity(quantity);
            data.setPrice(price);

            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Name not found. Update operation aborted.");
        }
    }
}
