package se.kth.iv1351.soundgood.jdbc.controller;

import se.kth.iv1351.soundgood.jdbc.integration.*;
import se.kth.iv1351.soundgood.jdbc.model.*;

public class Controller {
    // Add more DAOs below if needed
    private final SoundgoodDAO database;

    public Controller() throws SoundgoodDBException {
        // Add more DAOs below if needed
        database = new SoundgoodDAO();
    }

    public void createRental(String instrumentID) throws RentalException, InstrumentException {
        String failureMsg = "Could not create a rental for student: " + instrumentID;

        if (instrumentID == null) {
            throw new InstrumentException(failureMsg);
        }

        try {
            database.createRental(new Rental(), new Instrument());
        } catch (Exception e) {
            throw new RentalException(failureMsg, e);
        }
    }
}
