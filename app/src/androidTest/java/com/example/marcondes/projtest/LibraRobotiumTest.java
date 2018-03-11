package com.example.marcondes.projtest;

import android.test.ActivityInstrumentationTestCase2;

import com.example.marcondes.projtest.models.Conversor;
import com.example.marcondes.projtest.pageObject.LibraPageObject;
import com.robotium.solo.Solo;


/**
 * Created by Bruno Ribeiro on 22/02/2018.
 */

public class LibraRobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;
    private LibraPageObject libraPage;
    private Conversor conversor;

    public LibraRobotiumTest(){super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        libraPage = new LibraPageObject(solo);
        conversor = new Conversor();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testLibraToKgSucesso() throws Exception{
        libraPage.fillLibra("100");
        libraPage.clickOnBtLibraKg();
        double calculatedKg = conversor.lbToKg(100);
        double resultKg = Double.valueOf(libraPage.getTextKgResult());
        assertEquals(calculatedKg, resultKg, 0.1);
    }

    public void testlibraBlank() throws Exception {
        libraPage.fillLibra("");
        libraPage.clickOnBtLibraKg();
        double calculatedKg = conversor.lbToKg(0);
        double resultKg = Double.valueOf(libraPage.getTextKgResult());
        assertEquals(calculatedKg, resultKg, 0.1);
    }

}
