package com.sprzeliorz.GCDLCMwebcalculator.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class used for conections with database
 *
 * @author Sebastian Przeliorz
 * @version 1.0
 */
public class GCDLCMDatabase {

    /**
     * It represent database connection
     */
    private Connection connection = null;

    /**
     * Represents database driver
     */
    private String dbDriver = "org.apache.derby.jdbc.ClientDriver";
    /**
     * Represents database url address
     */
    private String dbUrl = "jdbc:derby://localhost:1527/lab";
    /**
     * Represents database user name
     */
    private String dbUser = "db_user";
    /**
     * Represents database password
     */
    private String dbPass;
    //private String dbPass = "db_pass";

    public void create(String dbDriver, String dbUrl, String dbUser, String dbPass) {
        //this.dbDriver = dbDriver;
        //this.dbUrl = dbUrl;
        //this.dbUser = dbUser;
        //this.dbPass = dbPass;

        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe.getMessage());
        }

    }

    /**
     * Metod creating table i database when table dont exists.
     */
    public void createTable() {

       /* try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe.getMessage());
            return;
        }*/

        /*try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE Results "
                    + "(data VARCHAR(50), "
                    + "gcd INTEGER, lcm INTEGER)");
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
       */
    }

    /**
     * Method inserting data to database
     *
     * @param data data user for calculations
     * @param gcd result of calculating gcd
     * @param lcm result of calculating lcm
     */
    public void insertData(String data, String gcd, String lcm) {

        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe.getMessage());
            return;
        }

        try (PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO Results VALUES (?, ?, ?)")) {           
            prepStmt.setString(1, data);
            prepStmt.setString(2, gcd);
            prepStmt.setString(3, lcm);
            prepStmt.execute();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }
}
