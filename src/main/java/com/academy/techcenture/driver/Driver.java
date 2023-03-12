package com.academy.techcenture.driver;

import com.academy.techcenture.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){}
    protected static WebDriver driver;
    public static   WebDriver getDriver(){
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");

            int pageLoadTime = Integer.parseInt(ConfigReader.getProperty("pageLoadTime"));
            int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicitWait"));

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("autofill.profile_enabled", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.default_content_setting_values.notifications", 2);
                options.addArguments("/Users/ayse/Library/Application Support/Google/Chrome/Profile 1");
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
               driver = new EdgeDriver();
            } else {
                throw new RuntimeException("NO DRIVER FOUND");
            }
        driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        }
        return driver;
    }
    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
