package com.example.marcondes.projtest;

import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;
import com.example.marcondes.projtest.pageObject.LoginPageObject;
import com.example.marcondes.projtest.models.Logger;
import com.example.marcondes.projtest.models.User;


/**
 * Created by Bruno Ribeiro on 22/02/2018.
 */

public class LoginRobotiumTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    private Solo solo;
    private LoginPageObject loginPage;
    private Logger logger;

    public LoginRobotiumTest(){
        super(LoginActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        loginPage = new LoginPageObject(solo);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testLoginSucesso() throws Exception{
        loginPage.fillEmail("marcondesjra@gmail.com");
        loginPage.fillPassword("123456");
        loginPage.clickOnButtonLogin();
        assertTrue("Message not displayed",solo.searchText("Welcome"));
    }

    public void testLoginEmBranco() throws Exception{
        loginPage.fillEmail("");
        loginPage.fillPassword("");
        loginPage.clickOnButtonLogin();
        assertTrue("Message not displayed",solo.searchText("Blank field"));
        //solo.sleep(1000);

        loginPage.fillEmail("bruno");
        loginPage.fillPassword("");
        loginPage.clickOnButtonLogin();
        assertTrue("Message not displayed",solo.searchText("Blank field"));
        //solo.sleep(1000);

        loginPage.fillEmail("");
        loginPage.fillPassword("1234");
        loginPage.clickOnButtonLogin();
        assertTrue("Message not displayed",solo.searchText("Blank field"));
    }

    public void testLoginIncorreto() throws Exception{
        loginPage.fillEmail("userDoesNotExist");
        loginPage.fillPassword("12341234");
        loginPage.clickOnButtonLogin();
        assertTrue("Message not displayed",solo.searchText("Email/Password invalid!"));
    }

}
