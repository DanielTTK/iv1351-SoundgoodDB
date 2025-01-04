package se.kth.iv1351.soundgood.jdbc.model;

/**
 * Generates a unique ID.
 */
public class IDGenerator {
    private static int currentId = 1000;

    public static synchronized int generateId() {
        return currentId++;
    }
}
