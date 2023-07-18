public class ParkingSpot {
    private String spotId;
    private ParkingSpotType type;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.type = ParkingSpotType.MINUTE;
    }

    public String getSpotId() {
        return spotId;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public void setType(ParkingSpotType type) {
        this.type = type;
    }
}
