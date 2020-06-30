package com.sprzeliorz.GCDLCMwebcalculator.core;

/**
 * Exception class for object thrown when using application
 *
 * @author Sebastian Przeliorz
 * @version 1.2
 */
public class GCDLCMCalculatorExeption extends Exception {

    /**
     * Constructor without parameters
     */
    public GCDLCMCalculatorExeption() {
    }

    /**
     * Constructor with parameters
     *
     * @param message to display message
     */
    public GCDLCMCalculatorExeption(String message) {
        super(message);
    }
}
