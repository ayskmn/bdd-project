package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInfopage extends BasePage{

    public UserInfopage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElement enterAccountInfoText;
    @FindBy(id = "newsletter")
    private WebElement newsLettersBtnSingUp;
    @FindBy(id = "optin")
    private WebElement receiveSpecialOffersFromOurPartnersBtn;
    @FindBy(xpath = "//input[@value='create_account']/following-sibling::button[@type='submit']")
    private WebElement createAccountBtn;
    public void verifyEnterAccountInfoTextIsVisible(){
        Assert.assertTrue("account info text is not visible",enterAccountInfoText.isDisplayed());
    }
    public void enterUserInfo(){

    }
    public void clickOnNewsLettersBtnSingUp(String str){
        driver.findElement(By.xpath("//label[text()='"+str+"']/../div/span/input[@type='checkbox']")).click();
    }
    public void clickOnReceiveSpecialOffersFromOurPartners(){
        receiveSpecialOffersFromOurPartnersBtn.click();
    }
    public void clickOnCreateAccountBtn(){
        createAccountBtn.click();
    }

}
