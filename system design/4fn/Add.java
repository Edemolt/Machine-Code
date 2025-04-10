// Add.java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Add {

    public void addData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name:");
        String name = br.readLine();

        System.out.println("Enter the size (integer):");
        int size = Integer.parseInt(br.readLine());

        System.out.println("Enter the quantity (integer):");
        int quantity = Integer.parseInt(br.readLine());

        System.out.println("Enter the price (integer):");
        int price = Integer.parseInt(br.readLine());

        // Get the singleton instance and set values
        Data data = Data.getInstance();
        data.setName(name);
        data.setSize(size);
        data.setQuantity(quantity);
        data.setPrice(price);

        System.out.println("Data added successfully.");
    }
}
