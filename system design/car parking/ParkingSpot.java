
public class ParkingSpot {

    private final int spotNo;
    private final String spotType;

    public boolean isAvailable;

    public ParkingSpot(String spotType) {
        spotNo = 0;
        this.spotType = spotType;
        this.isAvailable = true;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public void assignSpot() {
        this.isAvailable = false;
    }

    public void releaseSpot() {
        this.isAvailable = true;
    }

}
