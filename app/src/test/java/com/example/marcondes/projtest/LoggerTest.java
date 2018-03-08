package com.example.marcondes.projtest;

import com.example.marcondes.projtest.models.Logger;
import com.example.marcondes.projtest.models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Marcondes on 08/03/2018.
 */

public class LoggerTest {

    private Logger logger;

    @Before
    public void setUp() throws Exception {
        logger = new Logger();
    }

    @After
    public void tearDown() throws Exception {
        logger.closeConnection();
    }

    @Test
    public void testLogin() throws Exception{
        String username = "marcondesjra@gmail.com";
        String senha = "123456";

        boolean isValid = logger.login(new User(username, senha));

        assertTrue("User does not exist",isValid);
    }

    @Test
    public void testLoginNoUser() throws Exception{
        String username = "testNoLogin";
        String senha = "123";

        boolean isValid = logger.login(new User(username, senha));
        assertFalse("User logged in without having existing user",isValid);
    }


}
