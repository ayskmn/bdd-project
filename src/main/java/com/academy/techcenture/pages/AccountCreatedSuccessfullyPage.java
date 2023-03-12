package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedSuccessfullyPage extends BasePage{
    public AccountCreatedSuccessfullyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "b")
    private WebElement accountCreatedText;
    @FindBy(xpath = "//section[@id='form']/div/div/div/div/a")
    private WebElement continueBtn;

    @FindBy(xpath = "//iframe[@title='Advertisement']")
    private WebElement iframe;
    @FindBy(xpath = "//iframe[@id='aswift_2']")
    private WebElement parentIframe;

    public void verifyNavigatedToAccountCreatedSuccessfullyPage(){
        Assert.assertTrue("Text account created is not visible",accountCreatedText.isDisplayed());
    }
    public void clickOnContinueBtn(){
        continueBtn.click();
    }

    public void closePopUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().frame(parentIframe);
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

}
