package com.example.marcondes.projtest;

import android.test.ActivityInstrumentationTestCase2;

import com.example.marcondes.projtest.models.Conversor;
import com.example.marcondes.projtest.pageObject.MilePageObject;
import com.robotium.solo.Solo;


/**
 * Created by Bruno Ribeiro on 22/02/2018.
 */

public class MileRobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;
    private MilePageObject milePage;
    private Conversor conversor;

    public MileRobotiumTest(){super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        milePage = new MilePageObject(solo);
        conversor = new Conversor();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testMileToKmSucesso() throws Exception{
        milePage.fillMile("100");
        milePage.clickOnBtMileKm();
        double calculatedKm = conversor.mileToKm(100);
        double resultKm = Double.valueOf(milePage.getTextKmResult());
        assertEquals(calculatedKm, resultKm, 0.1);
    }

    public void testMileBlank() throws Exception {
        milePage.fillMile("");
        milePage.clickOnBtMileKm();
        double calculatedKm = conversor.mileToKm(0);
        double resultKm = Double.valueOf(milePage.getTextKmResult());
        assertEquals(calculatedKm, resultKm, 0.1);
    }

}
