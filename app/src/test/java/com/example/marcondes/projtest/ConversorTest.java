package com.example.marcondes.projtest;

import com.example.marcondes.projtest.models.Conversor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcondes on 08/03/2018.
 */

public class ConversorTest {

    private Conversor conversor;

    @Before
    public void setUp() throws Exception {
        conversor = new Conversor();
    }

    @Test
    public void testCelsiusToKelvin() throws Exception {
        double input = 100;
        double output;
        double expected = 373.15;
        double delta = 0.1;

        output = conversor.celsiusToKelvin(input);
        assertEquals(expected, output, delta);

        input = 98.6;
        output = 0;
        expected = 371.75;

        output = conversor.celsiusToKelvin(input);
        assertEquals(expected, output, delta);
    }

    @Test
    public void testHzToMHx() throws Exception {
        double input = 100;
        double output;
        double expected = 0.1;
        double delta = 0.1;

        output = conversor.hzToMhz(input);
        assertEquals(expected, output, delta);

        input = 1000;
        output = 0;
        expected = 1;

        output = conversor.hzToMhz(input);
        assertEquals(expected, output, delta);
    }

    @Test
    public void testLbToKg() throws Exception {
        double input = 100;
        double output;
        double expected = 45.35;
        double delta = 0.01;

        output = conversor.lbToKg(input);
        assertEquals(expected, output, delta);
    }


    @Test
    public void testMileToKm() throws Exception {
        double input = 100;
        double output;
        double expected = 160;
        double delta = 0.01;

        output = conversor.mileToKm(input);
        assertEquals(expected, output, delta);
    }

}

