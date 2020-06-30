package com.sprzeliorz.GCDLCMwebcalculator.core;

/**
 * Class used for all calculations
 *
 * @author Sebastian Przeliorz
 * @version 1.9
 */
public class Calculate {

    /**
     * Constructor without parameters
     */
    public Calculate() {
    }

    /**
     * Method used to calculate greatest common factor
     *
     * @param x contains first argument to calculate
     * @param y contains secound argument to calculate
     * @return returning result of the calculation
     */
    private int gcf(int x, int y) {
        while (x != y) {
            if (x > y) {
                x -= y;
            } else {
                y -= x;
            }
        }
        return x;
    }

    /**
     * Method calculating greatest common factor
     *
     * @param args parameters
     * @return returning result of the calculation
     * @throws com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption 
     * when variables are incorrect
     */
    public int greatestCommonFactor(int... args) throws GCDLCMCalculatorExeption {
        int i = 0;
        int gcd = args[0];
        for (int element : args) {
            if (args[i] <= 0) {
                throw new GCDLCMCalculatorExeption("Value cannot be 0");
            }
            gcd = gcf(gcd, args[i]);
            i++;
        }
        return gcd;
    }

    /**
     * Method used to calculate least common multiple based on result from
     * calculating greatest common factor
     *
     * @param args parameters
     * @param gcd result of already counted greatest common factor
     * @return returning result of the calculation
     * @throws com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption
     * when variables are incorrect
     */
    public int leastCommonMultiple(int gcd, int... args) throws GCDLCMCalculatorExeption {
        int i = 0;
        int ars = 1;
        int temp;
        int res = 0;
        for (int element : args) {
            if (args[i] <= 0) {
                throw new GCDLCMCalculatorExeption("Value cannot be 0");
            }
            temp = ars;
            ars = ars * args[i];
            if (i > 1) {                
                res = ars / gcf(temp, args[i]); 
                ars = res;                
            } else if (i > 0) {
                res = ars / gcf(args[0], args[i]);                    
                ars = res;
            }
            i++;
            
        }
        return res;
    }
}
