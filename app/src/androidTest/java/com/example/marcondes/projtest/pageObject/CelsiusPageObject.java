package com.example.marcondes.projtest.pageObject;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.marcondes.projtest.R;
import com.robotium.solo.Solo;

/**
 * Created by bruno on 22/02/2018.
 */

public class CelsiusPageObject {

    private Solo solo;

    private EditText editTextCelsius;
    private TextView textViewKelvin;
    private Button btCelsiusKevin;

    public CelsiusPageObject(Solo soloRef){
        this.solo = soloRef;
        updateFields();
    }

    private void updateFields() {
        editTextCelsius = (EditText) solo.getView(R.id.editTextCelsius);
        textViewKelvin = (TextView) solo.getView(R.id.textViewKelvin);
        btCelsiusKevin = (Button) solo.getView(R.id.btCelsiusKelvin);
    }


    public void fillCelsius(String celsius) {solo.enterText(editTextCelsius, celsius);}
    public String getTextKevinResult(){

        String retorno = textViewKelvin.getText().toString();
    return retorno;

    }
    public void clickOnBtCelsiusKevin() {solo.clickOnView(btCelsiusKevin);}
}
