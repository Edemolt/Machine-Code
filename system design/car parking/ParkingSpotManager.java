
import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManager {

    // Example shared resource: a list of parking spots.
    private final List<ParkingSpot> parkingSpots = new ArrayList<>();

    public synchronized ParkingSpot getAvailableSpot() {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable) {
                spot.assignSpot();
                return spot;
            }
        }
        return null;
    }

    public synchronized void releaseSpot(ParkingSpot spot) {
        spot.releaseSpot();
    }
}
