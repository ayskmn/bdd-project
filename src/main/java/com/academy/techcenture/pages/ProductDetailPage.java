package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='product-information']/h2")
    private WebElement productName;
    @FindBy(xpath = "//div[@class='product-information']/h2/following-sibling::p")
    private WebElement productCategory;
    @FindBy(xpath = "//div[@class='product-information']/span")
    private WebElement productPrice;
    @FindBy(xpath = "//div[@class='product-information']/p")
    private List<WebElement> productDetails;

    @FindBy(xpath="//span/input[@id='quantity']/following-sibling::input[@value='1']")
    private WebElement qtyInput;
    @FindBy(xpath = "//div[@class='product-information']/span/button")
    private WebElement addToCartBtn;
    @FindBy(xpath="//p/a/u[text()='View Cart']")
    private WebElement viewCartLink;

    @FindBy(xpath="//input[@id='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath="//textarea[@id='review']")
    private WebElement reviewTextArea;

    @FindBy(xpath = "//button[@id='button-review']")
    private WebElement submitReviewBtn;

    @FindBy(xpath="//a[text()='Write Your Review']")
    private WebElement writeYourReviewText;

    @FindBy(xpath="//div/span[text()='Thank you for your review.']")
    private WebElement thankYouForYourReviewText;

    public void verifyUserIsOnProductDetailsPage(){
        Assert.assertTrue("User is not on a product details page",driver.getTitle().trim().equalsIgnoreCase("Automation Exercise - Product Details"));
    }
    public void verifyProductsDetailsIsVisible(){
        verifyProductDetailsIsVisible();
        verifyProductCategoryIsVisible();
        verifyProductPriceIsVisible();
        verifyProductIsVisible();
    }
    private void verifyProductIsVisible(){
        Assert.assertTrue("Product name is not visible",productName.isDisplayed());
    }
    private void verifyProductCategoryIsVisible(){
        Assert.assertTrue("Product category is not visible",productCategory.isDisplayed());
    }
    private void verifyProductPriceIsVisible(){
        Assert.assertTrue("Product price is not visible",productPrice.isDisplayed());
    }
    private void verifyProductDetailsIsVisible(){
        for (int i = 0; i < productDetails.size(); i++) {
            Assert.assertTrue("Product , condition, brand availability, is not visible",productDetails.get(i).isDisplayed());
        }
    }
    public void increaseQuantity(){
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.getElementById('product_id').setAttribute('value', '4')");
        WebElement inputField = driver.findElement(By.xpath("//input[@id='quantity']"));
        inputField.clear();
        inputField.sendKeys("4");
        ConfigReader.setProperty("quantityOfProduct", "4");

    }
    public void addToCart(){
        Assert.assertTrue("add to cart button is not enabled", addToCartBtn.isEnabled());
        addToCartBtn.click();
    }
    public void clickOnViewCartLink(){
        Assert.assertTrue("View Cart link is not displayed", viewCartLink.isDisplayed());
        viewCartLink.click();
    }
    public void verifyWriteYourReviewText(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,410)", "");
        Assert.assertTrue("Write your review text is not displayed", writeYourReviewText.isDisplayed() );
    }
    public void submitReviewForAProduct(){
        nameInput.sendKeys(ConfigReader.getProperty("name"));
        emailInput.sendKeys(ConfigReader.getProperty("email1"));
        reviewTextArea.sendKeys("This product runs small.");
    }
    public void clickOnSubmitBtn(){
        Assert.assertTrue("submit button is not enabled", submitReviewBtn.isEnabled());
        submitReviewBtn.click();
    }
    public void verifyThankYouText(){
        Assert.assertTrue("Thank you for your review txt is not displayed", thankYouForYourReviewText.isDisplayed());
    }
}
