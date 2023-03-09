package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.locks.Condition;

public class PaymentPage extends BasePage{
    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="(//div/form/div/div/label/following-sibling::input)[1]")
    private WebElement nameOnCardInput;

    @FindBy(xpath="(//div/form/div/div/label/following-sibling::input)[2]")
    private WebElement cardNumberInput;

    @FindBy(xpath="(//div/form/div/div/label/following-sibling::input)[3]")
    private WebElement cvcInput;

    @FindBy(xpath="(//div/form/div/div/label/following-sibling::input)[4]")
    private WebElement expMonthInput;

    @FindBy(xpath="(//div/form/div/div/label/following-sibling::input)[5]")
    private WebElement expYearInput;

    @FindBy(xpath="//button[@id='submit']")
    private WebElement payAndConfirmOrderBtn;

    @FindBy(xpath="(//div[contains(text(), 'successfully')])[1]")
    private WebElement successText;

    @FindBy(xpath ="//p[contains(text(), 'Congratulations!')]")
    private WebElement paymentSuccessText;

    public void enterCardInfo(){
        nameOnCardInput.sendKeys(ConfigReader.getProperty("nameOnCard"));
        cardNumberInput.sendKeys(ConfigReader.getProperty("cardNumber"));
        cvcInput.sendKeys(ConfigReader.getProperty("cvc"));
        expMonthInput.sendKeys(ConfigReader.getProperty("expMonth"));
        expYearInput.sendKeys(ConfigReader.getProperty("expMonth"));
    }
    public void clickOnPayBtn(){
        payAndConfirmOrderBtn.click();
    }
    public void verifySuccessText(){
        Assert.assertTrue("Success text is not visible", successText.isDisplayed());
    }

    public void verifyPaymentSuccessPage(){
        Assert.assertTrue("Payment successfully completed page is not visible",paymentSuccessText.isDisplayed());
    }
}
