package com.example.marcondes.projtest.pageObject;

import android.widget.Button;
import android.widget.EditText;

import com.example.marcondes.projtest.R;
import com.robotium.solo.Solo;

/**
 * Created by bruno on 22/02/2018.
 */

public class HzPageObject {

    private Solo solo;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    public HzPageObject(Solo soloRef){
        this.solo = soloRef;
        updateFields();
    }

    private void updateFields() {
        editTextEmail = (EditText) solo.getView(R.id.editEmail);
        editTextPassword = (EditText) solo.getView(R.id.editPassword);
        buttonLogin = (Button) solo.getView(R.id.buttomLogin);
    }


    public void fillEmail(String email) {solo.enterText(editTextEmail, email);}

    public void fillPassword(String password) {solo.enterText(editTextPassword, password);}

    public void clickOnButtonLogin() {solo.clickOnView(buttonLogin);}
}
