package se.kth.iv1351.soundgood.jdbc.model;

/**
 * Generates a unique ID.
 */
public class IDGenerator {
    public static String generateId(String maxRentalId) {
        String newRentalId;
        if (maxRentalId != null) {
            String numericPart = maxRentalId.substring(1); // Remove the "R"
            int rentalNumber = Integer.parseInt(numericPart);
            rentalNumber++;

            // Format the new rental ID
            newRentalId = String.format("R%03d", rentalNumber);
        } else {
            // Handle the case where there are no rentals yet
            newRentalId = "R001";
        }
        return newRentalId;
    }
}
