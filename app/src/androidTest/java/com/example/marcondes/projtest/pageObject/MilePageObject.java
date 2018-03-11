package com.example.marcondes.projtest.pageObject;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.marcondes.projtest.R;
import com.robotium.solo.Solo;

/**
 * Created by bruno on 22/02/2018.
 */

public class MilePageObject {

    private Solo solo;

    private EditText editTextMile;
    private TextView textViewKm;
    private Button btMileKm;

    public MilePageObject(Solo soloRef){
        this.solo = soloRef;
        updateFields();
    }

    private void updateFields() {
        editTextMile = (EditText) solo.getView(R.id.editTextMile);
        textViewKm = (TextView) solo.getView(R.id.textViewKm);
        btMileKm = (Button) solo.getView(R.id.btMileKM);
    }


    public void fillMile(String mile) {solo.enterText(editTextMile, mile);}
    public void clickOnBtMileKm() {solo.clickOnView(btMileKm);}
    public String getTextKmResult(){updateFields();return textViewKm.getText().toString();}
}
