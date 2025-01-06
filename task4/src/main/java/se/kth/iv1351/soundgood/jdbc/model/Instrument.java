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

public class Instrument implements InstrumentDTO {
    private String instrId;
    private String instrType;
    private String instrBrand;
    private int instrInStock;
    private double price;

    public Instrument(String instrId, String instrType, String instrBrand, int instrInStock, double price) {
        this.instrId = instrId;
        this.instrType = instrType;
        this.instrBrand = instrBrand;
        this.instrInStock = instrInStock;
        this.price = price;
    }

    public Instrument(String instrId) {
        this(instrId, null, null, 0, 0);
    }

    @Override
    public String getInstrumentID() {
        return instrId;
    }

    @Override
    public String getInstrumentType() {
        return instrType;
    }

    @Override
    public String getInstrumentBrand() {
        return instrBrand;
    }

    @Override
    public int getInstrumentsInStock() {
        return instrInStock;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append("Instrument: [");
        stringRepresentation.append("ID: ");
        stringRepresentation.append(instrId);
        stringRepresentation.append(", Type: ");
        stringRepresentation.append(instrType);
        stringRepresentation.append(", Brand: ");
        stringRepresentation.append(instrBrand);
        stringRepresentation.append(", Available Stock: ");
        stringRepresentation.append(instrInStock);
        stringRepresentation.append(", Price: ");
        stringRepresentation.append(price);
        stringRepresentation.append("]");
        return stringRepresentation.toString();
    }
}
