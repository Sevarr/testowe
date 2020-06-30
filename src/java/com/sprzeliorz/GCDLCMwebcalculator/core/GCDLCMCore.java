package com.sprzeliorz.GCDLCMwebcalculator.core;

import java.util.List;

/**
 * Core class of the application
 *
 * @author Sebastian Przeliorz
 * @version 1.6
 */
public class GCDLCMCore {

    public static final GCDLCMCore INSTANCE = new GCDLCMCore();
    /**
     * Constructor without parameters
     */
    private GCDLCMCore() {
    }

    /**
     * Method starting the calculations and trying for exeption durig the work
     * of application
     *
     * @param list contains data given by user
     * @return tab containing results of the calculations
     * @throws GCDLCMCalculatorExeption throws an exeption when variables are
     * incorrect
     */
    public int[] gcdlcmCalculate(List<String> list) throws GCDLCMCalculatorExeption {
        Calculate calculate = new Calculate();
        int[] tab = new int[list.size()];
        int[] tabResult = new int[2];
        if (list.size() < 2) {
            throw new GCDLCMCalculatorExeption("Need 2 or more values");
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("\\d+")) {
                tab[i] = Integer.parseInt(list.get(i));
            } else {
                throw new GCDLCMCalculatorExeption("Value need to be a positive number");
            } 
        }       
        tabResult[0] = calculate.greatestCommonFactor(tab);
        tabResult[1] = calculate.leastCommonMultiple(tabResult[0], tab);
        return tabResult;
    }
}
