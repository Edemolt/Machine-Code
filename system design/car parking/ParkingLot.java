
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParkingLot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("How many cars will enter?");
        int numCars = sc.nextInt();

        for (int i = 0; i < numCars; i++) {
            // Collect input synchronously in the main thread
            System.out.println("Please enter your car type for car " + (i + 1) + ":");
            String type = sc.next();
            System.out.println("Enter car number for car " + (i + 1) + ":");
            String carno = sc.next();

            // Create a new task for processing car entry
            Runnable entryTask = () -> processCarEntry(type, carno);
            executor.submit(entryTask);
        }
        executor.shutdown();
        sc.close();
    }

    private static void processCarEntry(String type, String carno) {
        Car car;
        if (type.equalsIgnoreCase("compact")) {
            car = new CompactCar(carno);
        } else if (type.equalsIgnoreCase("big")) {
            car = new BigCar(carno);
        } else {
            throw new IllegalArgumentException("Unsupported car type: " + type);
        }

        // Process car entry operations (e.g., ticket generation)
        EntryTerminal entryTerminal = new EntryTerminal(car);
        entryTerminal.printEntryTicket(entryTerminal.getTicket());

        // Simulate further processing (like notifying exit tasks, etc.)
    }
}
