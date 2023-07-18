public class ParkingLot {
    protected ParkingSpot[][] parkingSpots;

    public ParkingLot(int rows, int columns) {
        parkingSpots = new ParkingSpot[rows][columns];
        initializeParkingSpots();
    }

    private void initializeParkingSpots() {
        char rowIdentifier = 'A';
        for (int row = 0; row < parkingSpots.length; row++) {
            for (int column = 0; column < parkingSpots[row].length; column++) {
                String spotId = String.format("%c%d", rowIdentifier, column + 1);
                parkingSpots[row][column] = new ParkingSpot(spotId);
            }
            rowIdentifier++;
        }
    }

    public void setSpotType(String spotId, ParkingSpotType type) {
        int row = spotId.charAt(0) - 'A';
        int column = Integer.parseInt(spotId.substring(1)) - 1;
        parkingSpots[row][column].setType(type);
    }

    public ParkingSpotType getSpotType(String spotId) {
        int row = spotId.charAt(0) - 'A';
        int column = Integer.parseInt(spotId.substring(1)) - 1;
        return parkingSpots[row][column].getType();
    }

    public ParkingSpot[][] getParkingSpots() {
        return parkingSpots;
    }
}
