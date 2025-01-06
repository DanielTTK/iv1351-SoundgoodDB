/*
 * The MIT License (MIT)
 * Copyright (c) 2020 Leif Lindbäck
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction,including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so,subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package se.kth.iv1351.soundgood.jdbc.model;

/**
 * A rental representing a lease for an instrument by a student
 */
public class Rental implements RentalDTO {
    private String rentalID;
    private String startDate;
    private String expiryDate;
    private String studentID;
    private String instrumentID;
    private String priceID;

    public Rental(String rentalID, String startDate, String expiryDate, String priceID, String instrumentID,
            String studentID) {
        this.rentalID = rentalID;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
        this.studentID = studentID;
        this.instrumentID = instrumentID;
        this.priceID = priceID;
    }

    public Rental(String rentalID) {
        this(rentalID, null, null, null, null, null);
    }

    @Override
    public String getRentalID() {
        return rentalID;
    }

    @Override
    public String getStartDate() {
        return startDate;
    }

    @Override
    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String getStudentID() {
        return studentID;
    }

    @Override
    public String getInstrumentID() {
        return instrumentID;
    }

    @Override
    public String getPriceID() {
        return priceID;
    }

    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append("Rental: [");
        stringRepresentation.append("Rental ID: ");
        stringRepresentation.append(rentalID);
        stringRepresentation.append(", Student ID: ");
        stringRepresentation.append(studentID);
        stringRepresentation.append(", Instrument ID: ");
        stringRepresentation.append(instrumentID);
        stringRepresentation.append(", Price ID: ");
        stringRepresentation.append(priceID);
        stringRepresentation.append("]");
        return stringRepresentation.toString();
    }
}
