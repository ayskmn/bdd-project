package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div/ol/li[text()='Shopping Cart']")
    private WebElement shoppingCartText;

    @FindBy(xpath="//h2[text()='Subscription']")
    private WebElement subscriptionTitle;

    @FindBy(xpath="//input[@id='susbscribe_email']")
    private WebElement subscribeInput;

    @FindBy(xpath="//button[@id='subscribe']")
    private WebElement subscribeBtn;
    @FindBy(xpath="//tr[@id='product-1']/td[@class='cart_price']/p")
    private WebElement firstProductPrice;
    @FindBy(xpath="//tr[@id='product-2']/td[@class='cart_price']/p")
    private WebElement secondProductPrice;
    @FindBy(xpath="//div[@id='cart_info']/table/tbody/tr")
    private List<WebElement> productsInCart;
    @FindBy(xpath = "//tr[@id='product-1']/td[@class='cart_quantity']/button")
    private WebElement quantityFirstItem;
    @FindBy(xpath = "//tr[@id='product-2']/td[@class='cart_quantity']/button")
    private WebElement quantitySecondItem;
    @FindBy(xpath = "//tr[@id='product-1']/td[@class='cart_total']/p")
    private WebElement cartTotalFirstItem;
    @FindBy(xpath = "//tr[@id='product-2']/td[@class='cart_total']/p")
    private WebElement cartTotalSecondItem;

    @FindBy(xpath = "//div/a[text()='Proceed To Checkout']")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath="//div/p/following-sibling::p/a/u")
    private WebElement registerLoginLink;

    public void verifySubscriptionTitleIsVisible(){
        Assert.assertTrue(subscriptionTitle.isDisplayed());
    }

    public void subscribe(){
        subscribeInput.sendKeys(ConfigReader.getProperty("email1"));
        subscribeBtn.click();
    }
    public void verifyHowManyProductsInCart(int i){
        Assert.assertTrue("The quantity of the items were added are not correct",productsInCart.size()==i);
    }
    public void verifyQuantityOfSingleProduct(){
        Assert.assertTrue("quantity is not equals to 4",
                driver.findElement(By.xpath("//tr/td/button[text()='4']")).getText().trim()
                        .equals(ConfigReader.getProperty("quantityOfProduct")));
    }
    public void verifyTotalPrice(){
        String first = firstProductPrice.getText().trim();
        String second = secondProductPrice.getText().trim();
        int firstPrice = Integer.parseInt(first.substring(first.length() - 3));
        int secondPrice = Integer.parseInt(second.substring(second.length() - 3));
        int count1 = Integer.parseInt(quantityFirstItem.getText().trim());
        int count2 = Integer.parseInt(quantitySecondItem.getText().trim());
        String cart1 = cartTotalFirstItem.getText().trim();
        String cart2 = cartTotalSecondItem.getText().trim();
        int cartTotal1 = Integer.parseInt(cart1.substring(cart1.length()-3));
        int cartTotal2 = Integer.parseInt(cart2.substring(cart2.length()-3));
        Assert.assertEquals("Total is not correct", cartTotal1, count1 * firstPrice);
        Assert.assertEquals("Total is not correct", cartTotal2, count2 * secondPrice);
    }
    public void verifyUserIsOnCartPage(){
        Assert.assertTrue("Shopping Cart Text is not displayed", shoppingCartText.isDisplayed());
    }
    public void clickOnProceedToCheckoutBtn(){
        Assert.assertTrue("proceed to checkout btn is not enabled", proceedToCheckoutBtn.isEnabled());
        proceedToCheckoutBtn.click();
    }
    public void clickOnRegisterLinkAtCheckout(){
        Assert.assertTrue("Login/Register link is not displayed", registerLoginLink.isDisplayed());
        registerLoginLink.click();
    }

}
