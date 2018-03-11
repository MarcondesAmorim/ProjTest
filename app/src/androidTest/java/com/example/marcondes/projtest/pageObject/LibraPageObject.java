package com.example.marcondes.projtest.pageObject;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.marcondes.projtest.R;
import com.robotium.solo.Solo;

/**
 * Created by bruno on 22/02/2018.
 */

public class LibraPageObject {

    private Solo solo;

    private EditText editTextLibra;
    private TextView textViewKg;
    private Button btLibraKg;

    public LibraPageObject(Solo soloRef){
        this.solo = soloRef;
        updateFields();
    }

    private void updateFields() {
        editTextLibra = (EditText) solo.getView(R.id.editTextLibra);
        textViewKg = (TextView) solo.getView(R.id.textViewKg);
        btLibraKg = (Button) solo.getView(R.id.btLibraKg);
    }


    public void fillLibra(String libra) {solo.enterText(editTextLibra, libra);}
    public void clickOnBtLibraKg() {solo.clickOnView(btLibraKg);}
    public String getTextKgResult(){updateFields();return textViewKg.getText().toString();}
}
