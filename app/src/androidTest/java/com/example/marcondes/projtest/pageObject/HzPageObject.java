package com.example.marcondes.projtest.pageObject;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.marcondes.projtest.R;
import com.robotium.solo.Solo;

/**
 * Created by bruno on 22/02/2018.
 */

public class HzPageObject {

    private Solo solo;

    private EditText editTextHz;
    private TextView textViewMhz;
    private Button btHzMHz;

    public HzPageObject(Solo soloRef){
        this.solo = soloRef;
        updateFields();
    }

    private void updateFields() {
        editTextHz = (EditText) solo.getView(R.id.editTextHz);
        textViewMhz = (TextView) solo.getView(R.id.textViewMHz);
        btHzMHz = (Button) solo.getView(R.id.btHzMHz);
    }


    public void fillHz(String hz) {solo.enterText(editTextHz, hz);}
    public void clickOnBtHzMHz() {solo.clickOnView(btHzMHz);}
    public String getTextMHzResult(){updateFields();return textViewMhz.getText().toString();}
}
