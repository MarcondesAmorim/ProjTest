package com.example.marcondes.projtest;

import android.test.ActivityInstrumentationTestCase2;

import com.example.marcondes.projtest.models.Conversor;
import com.example.marcondes.projtest.pageObject.HzPageObject;
import com.robotium.solo.Solo;


/**
 * Created by Bruno Ribeiro on 22/02/2018.
 */

public class HzRobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;
    private HzPageObject hzPage;
    private Conversor conversor;

    public HzRobotiumTest(){super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        hzPage = new HzPageObject(solo);
        conversor = new Conversor();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testHzToMHzSucesso() throws Exception{
        hzPage.fillHz("1000");
        hzPage.clickOnBtHzMHz();
        double calculatedMHz = conversor.hzToMhz(1000);
        double resultMHz = Double.valueOf(hzPage.getTextMHzResult());
        assertEquals(calculatedMHz, resultMHz, 0.1);
    }

    public void testHzBlank() throws Exception {
        hzPage.fillHz("");
        hzPage.clickOnBtHzMHz();
        double calculatedMHz = conversor.hzToMhz(0);
        double resultMHz = Double.valueOf(hzPage.getTextMHzResult());
        assertEquals(calculatedMHz, resultMHz, 0.1);
    }

}
