
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter vehicle type (CAR/BIKE): ");
        String vehicleType = sc.nextLine();

        Vehicle vehicle = VehicleFactory.getVehicle(vehicleType);
        if (vehicle != null) {
            vehicle.drive();
        } else {
            System.out.println("Invalid vehicle type.");
        }

        sc.close();
    }
}
