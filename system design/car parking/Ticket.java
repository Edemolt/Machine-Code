
import java.time.LocalTime;
import java.util.UUID;

public class Ticket {

    UUID id;
    LocalTime currentTime;
    Car car;
    ParkingSpot spot;

    public Ticket(Car car) {
        this.id = UUID.randomUUID();
        this.currentTime = LocalTime.now();
        this.car = car;
        spot = new ParkingSpot(car.getCarType());
    }

    public UUID getId() {
        return id;
    }

    public LocalTime getEnterTime() {
        return currentTime;
    }

    public Car getCar() {
        return car;
    }

    public int getSpotId() {
        return spot.getSpotNo();
    }
}
