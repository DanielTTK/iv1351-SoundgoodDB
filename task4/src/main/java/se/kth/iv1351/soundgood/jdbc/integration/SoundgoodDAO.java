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

package se.kth.iv1351.soundgood.jdbc.integration;

import java.sql.*;

public class SoundgoodDAO {

    private Connection connection;
    private PreparedStatement updateRentalToExpiryStmt;

    /**
     * Constructs a new DAO object connected to the Soundgood database.
     * 
     * @throws SoundgoodDBException an exception which specifies a database error.
     */
    public SoundgoodDAO() throws SoundgoodDBException {
        try {
            connectToDatabase();
        } catch (SQLException exception) {
            throw new SoundgoodDBException("could not connect to datasource.", exception);
        }
    }

    /**
     * Deletes a rental by updating the lease date to expiry, and from that removes
     * the lease. Rental deletion through forced expiry is preferred due to the
     * database saving of historical data. Direct deletion does not make use of
     * database
     * functionality.
     */
    public void deleteRental(String rentalId) throws SoundgoodDBException {
        String failureMsg = "Failed to terminate rental: " + rentalId;

        try {
            updateRentalToExpiryStmt.setString(1, rentalId);
            updateRentalToExpiryStmt.executeUpdate();

            connection.commit();
        } catch (SQLException sqle) {
            handleException(failureMsg, sqle);
        }
    }

    /**
     * Handles exceptions and rolls back transactions.
     */
    private void handleException(String failureMsg, Exception cause) throws SoundgoodDBException {
        try {
            connection.rollback();
        } catch (SQLException rollbackExc) {
            failureMsg += " Also failed to rollback transaction: " + rollbackExc.getMessage();
        }
        throw new SoundgoodDBException(failureMsg, cause);
    }

    public void commit() throws SoundgoodDBException {
        try {
            connection.commit();
        } catch (SQLException e) {
            handleException("Failed to commit", e);
        }
    }

    private void prepareStatements(Connection connection) throws SQLException {
        /*
         * Examples:
         * createAccountStmt = connection.prepareStatement("INSERT INTO " +
         * ACCT_TABLE_NAME
         * + "(" + ACCT_NO_COLUMN_NAME + ", " + BALANCE_COLUMN_NAME + ", "
         * + HOLDER_FK_COLUMN_NAME + ") VALUES (?, ?, ?)");
         * 
         * findHolderPKStmt = connection.prepareStatement("SELECT " +
         * HOLDER_PK_COLUMN_NAME
         * + " FROM " + HOLDER_TABLE_NAME + " WHERE " + HOLDER_COLUMN_NAME + " = ?");
         * 
         * changeBalanceStmt = connection.prepareStatement("UPDATE " + ACCT_TABLE_NAME
         * + " SET " + BALANCE_COLUMN_NAME + " = ? WHERE " + ACCT_NO_COLUMN_NAME +
         * " = ? ");
         * 
         * deleteAccountStmt = connection.prepareStatement("DELETE FROM " +
         * ACCT_TABLE_NAME
         * + " WHERE " + ACCT_NO_COLUMN_NAME + " = ?");
         */

        updateRentalToExpiryStmt = connection.prepareStatement(
                "UPDATE instrument_rental SET lease_expiry_time = CURRENT_TIMESTAMP(0) WHERE rental_id = ?");
    }

    /**
     * Handles connection to soundgood database.
     */
    void connectToDatabase() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/soundgood",
                "postgres", "kth");
        connection.setAutoCommit(false);
        prepareStatements(connection);
    }
}
