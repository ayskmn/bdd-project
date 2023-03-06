package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends BasePage{
    public Checkout(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//ul[@id='address_delivery']/li[2]")
    private WebElement name;

    @FindBy(xpath="//ul[@id='address_delivery']/li[4]")
    private WebElement streetAddress;

    @FindBy(xpath="//ul[@id='address_delivery']/li[6]")
    private WebElement cityStateZip;

    @FindBy(xpath="//ul[@id='address_delivery']/li[7]")
    private WebElement country;

    @FindBy(xpath="//ul[@id='address_delivery']/li[8]")
    private WebElement phoneNumber;

    @FindBy(xpath = "//textarea")
    private WebElement commentTextBox;

    @FindBy(xpath = "//div/a[text()='Place Order']")
    private WebElement placeOrderBtn;

    public void verifyShippingInfo(){
        String nameText = name.getText().trim();
        String streetAddressText = streetAddress.getText().trim();
        String cityStateZipText = cityStateZip.getText().trim();
        String countryText = country.getText().trim();
        String phoneNumberText = phoneNumber.getText().trim();
        String fullName = ConfigReader.getProperty("title")+". "+ConfigReader.getProperty("firstName")+" "+ConfigReader.getProperty("lastName");
        String expectedStreetAdd = ConfigReader.getProperty("streetAddress");
        String expectedCityStateZip = ConfigReader.getProperty("cityStateZip");
        String expectedCountry = ConfigReader.getProperty("country");
        String expectedPhoneNum = ConfigReader.getProperty("phoneNumber");
        Assert.assertTrue("name doesn't match", nameText.equalsIgnoreCase(fullName));
        Assert.assertTrue("street address doesn't match", streetAddressText.equalsIgnoreCase(expectedStreetAdd));
        Assert.assertTrue("City/state/zip info is not correct", cityStateZipText.equalsIgnoreCase(expectedCityStateZip));
        Assert.assertTrue("Country is not correct", countryText.equalsIgnoreCase(expectedCountry));
        Assert.assertTrue("phone number is not correct", phoneNumberText.equalsIgnoreCase(expectedPhoneNum));

    }

    public void makeACommentForTheOrder(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)", "");
        commentTextBox.click();
        commentTextBox.sendKeys("Make a gift wrap for my orders.");
    }

    public void clickOnPlaceOrderBtn(){
        placeOrderBtn.click();
    }
}
