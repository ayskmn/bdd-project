package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    private WebElement singInSignUpButton;
    @FindBy(xpath = "//div[@id='dismiss-button']/div/span")
    private WebElement dismissBtn;
    @FindBy(xpath = "//iframe[@title='Advertisement']")
    private WebElement iframe;
    @FindBy(xpath = "//iframe[@id='aswift_9']")
    private WebElement parentIframe;
    @FindBy(xpath = "//a[text()=' Logged in as ']")
    private WebElement loginAsUserText;
    @FindBy(xpath = "//a[text()=' Contact us']")
    private WebElement contactUsBtn;
    @FindBy(xpath = " //a[text()=' Test Cases']")
    private WebElement testCasesBtn;
    @FindBy(xpath = "//a[text()=' Products']")
    private WebElement productsBtn;

    public void clickOnSingInSignUpBtn(){
        singInSignUpButton.click();
    }
    public void verifyLogInAsUser(){
        Assert.assertTrue("Log in as user not visible",loginAsUserText.getText().trim().equalsIgnoreCase("Logged in as "+ ConfigReader.getProperty("name")));
    }
    public void verifyUserIsOnAHomePage(){
        Assert.assertTrue(driver.getTitle().trim().equalsIgnoreCase("Automation Exercise"));
    }
    public void clickOnContactUsBtn(){
        contactUsBtn.click();
    }
    public void clickTestCasesBtn(){
        testCasesBtn.click();
    }
    public void clickOnProductBtn(){
        productsBtn.click();
    }
    public void closeAd() throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().frame(parentIframe);
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }
}
