package com.academy.techcenture.pages;

import org.junit.Assert;
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

    public void verifyNavigatedToAccountCreatedSuccessfullyPage(){
        Assert.assertTrue("Text account created is not visible",accountCreatedText.isDisplayed());
    }
    public void clickOnContinueBtn(){
        continueBtn.click();
    }

    public void closePopUp(){

    }

}
