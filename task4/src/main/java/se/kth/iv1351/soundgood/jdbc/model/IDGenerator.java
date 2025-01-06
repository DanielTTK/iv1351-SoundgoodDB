package se.kth.iv1351.soundgood.jdbc.model;

/**
 * Generates a unique ID.
 * 
 * @returns a rental id.
 */
public class IDGenerator {
    public static String generateId(String maxRentalId) {
        String newRentalId;
        if (maxRentalId != null && maxRentalId != "") {
            String numericPart = maxRentalId.substring(1);
            int rentalNumber = Integer.parseInt(numericPart);
            rentalNumber++;

            newRentalId = String.format("R%03d", rentalNumber);
        } else {
            newRentalId = "R001";
        }
        return newRentalId;
    }
}
