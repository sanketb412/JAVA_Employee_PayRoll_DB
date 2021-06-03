package com.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBDemo {
    public static void main(String[] args) {

        /**
         * Establishing Database Connection
         */

        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_services_java?useSSL=false";
        String userName = "root";
        String password = "karunaMumy123@";
        Connection connection;

        /**
         * Knowing my Driver a Loaded or not
         */
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded.!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the drivers in classpath!", e);
        }

        /**
         * Calling ListDriver
         */
        listDrivers();
        try {
            System.out.println("Connecting to database: "+jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful!!!!!"+connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Listing all the Drivers which are registered in class path
     */
    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = driverList.nextElement();
            System.out.println("-> "+driverClass.getClass().getName());
        }
    }
}
