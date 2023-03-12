package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void setUp(){
        Driver.getDriver();
    }

    @After
    public void tearDown(){
       Driver.quitDriver();
    }
}
