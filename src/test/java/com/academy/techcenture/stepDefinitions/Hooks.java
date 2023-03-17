package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.masterthought.cucumber.ReportBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

public class Hooks {


    @Before
    public void setUp(){
        Driver.getDriver();
    }

    @After
    public void tearDown(){
       Driver.quitDriver();
    }
    @AfterStep
    public void addScreenshot(Scenario scenario){
        WebDriver driver = Driver.getDriver();
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }
}
