package com.example.marcondes.projtest;

import android.test.ActivityInstrumentationTestCase2;

import com.example.marcondes.projtest.models.Conversor;
import com.example.marcondes.projtest.pageObject.CelsiusPageObject;
import com.robotium.solo.Solo;


/**
 * Created by Bruno Ribeiro on 22/02/2018.
 */

public class CelsiusRobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;
    private CelsiusPageObject celsiusPage;
    private Conversor conversor;

    public CelsiusRobotiumTest(){super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        celsiusPage = new CelsiusPageObject(solo);
        conversor = new Conversor();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testcelsiuToKevinSucesso() throws Exception{
        celsiusPage.fillCelsius("100");
        celsiusPage.clickOnBtCelsiusKevin();
        double calculatedKelvin = conversor.celsiusToKelvin(100);
        double resultKelvin = Double.valueOf(celsiusPage.getTextKevinResult());
        assertEquals(calculatedKelvin, resultKelvin, 0.1);
    }

    public void testCelsiuBlank() throws Exception {
        celsiusPage.fillCelsius("");
        celsiusPage.clickOnBtCelsiusKevin();
        double calculatedKElvin = conversor.celsiusToKelvin(0);
        double resultKevin = Double.valueOf(celsiusPage.getTextKevinResult());
        assertEquals(calculatedKElvin, resultKevin, 0.1);
   }

}
