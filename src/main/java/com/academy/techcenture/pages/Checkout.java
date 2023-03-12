package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
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
    @FindBy(xpath="//iframe[@id='aswift_4']")
    private WebElement parentIframe;
    @FindBy(xpath = "//iframe[@title='Advertisement']")
    private WebElement iframe;
    @FindBy(xpath="(//li[contains(@class, 'address_firstname')])[1]")
    private WebElement shippingName;
    @FindBy(xpath="(//li[contains(@class, 'address_firstname')])[2]")
    private WebElement billingName;
    @FindBy(xpath="(//li[contains(@class, 'address_address1')])[2]")
    private WebElement shippingAdd1;
    @FindBy(xpath="(//li[contains(@class, 'address_address1')])[5]")
    private WebElement billingAdd1;
    @FindBy(xpath="(//li[contains(@class, 'address_city')])[1]")
    private WebElement shippingAddressCity;
    @FindBy(xpath="(//li[contains(@class, 'address_city')])[2]")
    private WebElement billingAddressCity;
    @FindBy(xpath="(//li[contains(@class, 'address_country')])[1]")
    private WebElement shippingCountry;
    @FindBy(xpath="(//li[contains(@class, 'address_country')])[2]")
    private WebElement billingCountry;
    @FindBy(xpath="(//li[contains(@class, 'address_phone')])[1]")
    private WebElement shippingPhone;
    @FindBy(xpath="(//li[contains(@class, 'address_phone')])[2]")
    private WebElement billingPhone;

    @FindBy(xpath="//div[@id='cart_info']")
    private WebElement reviewYourOrderItems;

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
    public void verifyBillingInfo(){
        Assert.assertTrue(shippingName.getText().equalsIgnoreCase(billingName.getText()));
        Assert.assertTrue(shippingAdd1.getText().equalsIgnoreCase(billingAdd1.getText()));
        Assert.assertTrue(shippingAddressCity.getText().equalsIgnoreCase(billingAddressCity.getText()));
        Assert.assertTrue(shippingCountry.getText().equalsIgnoreCase(billingCountry.getText()));
        Assert.assertTrue(shippingPhone.getText().equalsIgnoreCase(billingPhone.getText()));
    }
    public void verifyShippingInfoForLogin(){
        String nameText = name.getText().trim();
        String streetAddressText = streetAddress.getText().trim();
        String cityStateZipText = cityStateZip.getText().trim();
        String countryText = country.getText().trim();
        String phoneNumberText = phoneNumber.getText().trim();
        String expectedName = ConfigReader.getProperty("shippingName");
        String expectedAdd = ConfigReader.getProperty("shippingAddress");
        String expectedStateZip = ConfigReader.getProperty("shippingStateZip");
        String expectedCountry = ConfigReader.getProperty("shippingCountry");
        String expectedPhoneNum = ConfigReader.getProperty("shippingPhone");
        Assert.assertTrue("name doesn't match", nameText.equalsIgnoreCase(expectedName));
        Assert.assertTrue("street address doesn't match", streetAddressText.equalsIgnoreCase(expectedAdd));
        Assert.assertTrue("City/state/zip info is not correct", cityStateZipText.equalsIgnoreCase(expectedStateZip));
        Assert.assertTrue("Country is not correct", countryText.equalsIgnoreCase(expectedCountry));
        Assert.assertTrue("phone number is not correct", phoneNumberText.equalsIgnoreCase(expectedPhoneNum));
    }

    public void closeAd() throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().frame(parentIframe);
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
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

    public void reviewYourOrder(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", reviewYourOrderItems);
        Assert.assertTrue("The review your orders list is not diplayed", reviewYourOrderItems.isDisplayed());
    }
}
