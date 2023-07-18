import java.util.Scanner;

public class ParkingLotApp {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5, 7);
        Scanner scanner = new Scanner(System.in);

        System.out.println("cnfigurar el tipo de spot ");
        System.out.println("Ingrese los identificaciones de ID y sus tipo ");
        System.out.println("los tipos pueden ser: PREMIUM, VIP, MINUTE");
        System.out.println("Ejemplo: A1 PREMIUM");

        while (true) {
            System.out.print("Ingrese el ID del lugar y escriba (o 'done' para terminar):");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("input no valido. intente nuevamente.");
                continue;
            }

            String spotId = parts[0];
            String typeString = parts[1];

            try {
                ParkingSpotType type = ParkingSpotType.valueOf(typeString.toUpperCase());
                parkingLot.setSpotType(spotId, type);
                System.out.println("Tipo de spot actualiado correctamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de spot no valido. intentelo nuevamente.");
            }
        }

        System.out.println("Parking spots:");
        ParkingSpot[][] parkingSpots = parkingLot.parkingSpots;
        for (int row = 0; row < parkingSpots.length; row++) {
            for (int column = 0; column < parkingSpots[row].length; column++) {
                String spotId = parkingSpots[row][column].getSpotId();
                ParkingSpotType spotType = parkingLot.getSpotType(spotId);
                System.out.println("Spot ID: " + spotId + ", Type: " + spotType);
            }
        }
    }
}
