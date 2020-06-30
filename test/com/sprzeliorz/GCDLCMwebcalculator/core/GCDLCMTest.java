package com.sprzeliorz.GCDLCMwebcalculator.core;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing class of this application
 *
 * @author Sebastian Przeliorz
 * @version 1.0
 */
public class GCDLCMTest {

    private final GCDLCMCore GcdlcmCore = GCDLCMCore.INSTANCE;
    private final Calculate calculate = new Calculate();
    private GCDLCMCalculatorExeption exception = new GCDLCMCalculatorExeption();

    @Test
    public void testGreatestCommonFactor_same_value() {
        int[] tab = new int[3];
        tab[0] = 2;
        tab[1] = 2;
        tab[2] = 2;
        try {
            assertEquals(2, calculate.greatestCommonFactor(tab));
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
        }
    }

    @Test
    public void testCalculate_greatestCommonFactor_negative_zero_value() {
        int[] tab = new int[3];
        tab[0] = 0;
        tab[1] = -3;
        tab[2] = 1;
        try {
            assertEquals(1, calculate.greatestCommonFactor(tab));
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
        }
    }

    @Test
    public void testGreatestCommonFactor_try_exception() {
        int[] tab = new int[3];
        tab[0] = -1;
        tab[1] = -2;
        tab[2] = -5;
        try {
            calculate.greatestCommonFactor(tab);
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
            exception = ex;
        }
        assertEquals("Value cannot be 0", exception.getMessage());
    }

    @Test
    public void testGreatestCommonFactor_regular_data() {
        int[] tab = new int[3];
        tab[0] = 2;
        tab[1] = 4;
        tab[2] = 6;
        tab[2] = 8;
        try {
            assertEquals(2, calculate.greatestCommonFactor(tab));
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
        }
    }

    @Test
    public void testLeastCommonMultiple_same_value() {
        int[] tab = new int[3];
        tab[0] = 2;
        tab[1] = 2;
        tab[2] = 2;
        try {
            assertEquals(2, calculate.leastCommonMultiple(3, tab));
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
        }
    }

    @Test
    public void testLeastCommonMultiple_negative_zero_value() {
        int[] tab = new int[3];
        tab[0] = 0;
        tab[1] = -1;
        tab[2] = 1;
        try {
            assertEquals(1, calculate.leastCommonMultiple(3, tab));
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
        }
    }
    
    @Test
    public void testLeastCommonMultiple_try_exception() {
        int[] tab = new int[3];
        tab[0] = -1;
        tab[1] = -2;
        tab[2] = -5;
        try {
            calculate.leastCommonMultiple(3, tab);
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
            exception = ex;
        }
        assertEquals("Value cannot be 0", exception.getMessage());
    }
    
    @Test
    public void testLeastCommonMultiple_regular_data() {
        int[] tab = new int[4];
        tab[0] = 2;
        tab[1] = 4;
        tab[2] = 6;
        tab[2] = 8;
        try {
            assertEquals(5, calculate.leastCommonMultiple(3, tab));
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
        }
    }

    @Test
    public void testGCDLCMCalculate_regular_data() {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("4");
        int[] tab = new int[2];
        tab[0] = 2;
        tab[1] = 4;
        try {
            assertArrayEquals(tab, GcdlcmCore.gcdlcmCalculate(list));
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
        }
    }
    
    @Test
    public void testGCDLCMCalculate_regular_data_big_values() {
        List<String> list = new ArrayList<>();
        list.add("224");
        list.add("446");
        int[] tab = new int[2];
        tab[0] = 2;
        tab[1] = 49952;
        try {
            assertArrayEquals(tab, GcdlcmCore.gcdlcmCalculate(list));
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
        }
    }

    @Test
    public void testGCDLCMCalculate_try_exception_zero() throws GCDLCMCalculatorExeption {
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("4");
        try {
            GcdlcmCore.gcdlcmCalculate(list);
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
            exception = ex;
        }
        assertEquals("Value cannot be 0", exception.getMessage());
    }

    @Test
    public void testGCDLCMCalculate_try_exception_negative_number() throws GCDLCMCalculatorExeption {
        List<String> list = new ArrayList<>();
        list.add("-2");
        list.add("4");
        try {
            GcdlcmCore.gcdlcmCalculate(list);
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
            exception = ex;
        }
        assertEquals("Value need to be a positive number", exception.getMessage());
    }
    
    @Test
    public void testGCDLCMCalculate_try_exception_not_number_value() throws GCDLCMCalculatorExeption {
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("tset");
        try {
            GcdlcmCore.gcdlcmCalculate(list);
        } catch (com.sprzeliorz.GCDLCMwebcalculator.core.GCDLCMCalculatorExeption ex) {
            exception = ex;
        }
        assertEquals("Value need to be a positive number", exception.getMessage());
    }
}