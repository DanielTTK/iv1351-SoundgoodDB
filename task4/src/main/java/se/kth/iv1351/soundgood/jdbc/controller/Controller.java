package se.kth.iv1351.soundgood.jdbc.controller;

import java.util.List;

import se.kth.iv1351.soundgood.jdbc.integration.*;
import se.kth.iv1351.soundgood.jdbc.model.*;

public class Controller {
    // Add more DAOs below if needed
    private final SoundgoodDAO database;

    public Controller() throws SoundgoodDBException {
        // Add more DAOs below if needed
        database = new SoundgoodDAO();
    }

    public void createRental(String instrumentID, int studentID, String priceID)
            throws RentalException, InstrumentException {
        String failureMsg = "Could not create rental for student " + studentID;

        if (instrumentID == null) {
            throw new InstrumentException(failureMsg);
        }

        try {
            database.createRental(new Instrument(instrumentID), new Student(studentID), priceID);
        } catch (Exception e) {
            throw new RentalException(failureMsg, e);
        }
    }

    public List<Instrument> listInstrumentsByType(String instrumentType) throws SoundgoodDBException {
        return database.findInstrumentsByType(instrumentType);
    }

    public void terminateRental(String rentalID) throws RentalException {
        String failureMsg = "Could not terminate rental " + rentalID;
        try {
            Rental rental = new Rental(rentalID);
            database.deleteRental(rental);
        } catch (Exception e) {
            throw new RentalException(failureMsg, e);
        }
    }
}
