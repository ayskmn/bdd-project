package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement allProducts;
    @FindBy(xpath = "(//div[@class='features_items']/div/following-sibling::div)[1]/div/div/following-sibling::div/ul/li/a/i")
    private WebElement firstProduct;

    @FindBy(xpath="(//div[@class='features_items']/div/following-sibling::div)[2]/div/div/following-sibling::div/ul/li/a/i")
    private WebElement secondProduct;
    @FindBy(id = "search_product")
    private WebElement searchProductInput;
    @FindBy(id = "submit_search")
    private WebElement submitSearchBtn;

    @FindBy(xpath = "//p[contains(text(),'Top')]")
    private List<WebElement> searchedProducts;
    @FindBy(xpath="(//a[@data-product-id='1' and text()='Add to cart'])[1]/i")
    private WebElement addFirstToCartBtn;
    @FindBy(xpath="(//a[@data-product-id='2' and text()='Add to cart'])[1]/i")
    private WebElement addSecondToCartBtn;
    @FindBy(xpath="//button[text()='Continue Shopping']")
    private WebElement continueShoppingBtn;
    @FindBy(xpath="//p/a/u[text()='View Cart']")
    private WebElement viewCartLink;
    @FindBy(xpath="(//div[@class='single-products']/div/img/following-sibling::h2)[1]")
    private WebElement firstProductPrice;
    @FindBy(xpath="(//div[@class='single-products']/div/img/following-sibling::h2)[2]")
    private WebElement secondProductPrice;


    public void verifyUserOnAProductPage(){
        Assert.assertTrue("User is not on a product page",driver.getTitle().trim().equalsIgnoreCase("Automation Exercise - All Products"));
    }
    public void verifyAllProductsIsVisible(){
        Assert.assertTrue("Products Are not visible",allProducts.isDisplayed());
    }
    public void clickOnFirstProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        firstProduct.click();
    }
    public void addFirstProductToCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        addFirstToCartBtn.click();
    }
    public void addSecondProductToCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        addSecondToCartBtn.click();
    }
    public void clickOnContinueBtn(){
        Assert.assertTrue("Continue btn is not enabled",continueShoppingBtn.isEnabled());
        continueShoppingBtn.click();
    }
    public void clickOnViewCart(){
        Assert.assertTrue("View Cart link is not displayed", viewCartLink.isDisplayed());
        viewCartLink.click();
    }

    public void searchProduct(String str){
        searchProductInput.sendKeys(str);
        submitSearchBtn.click();
    }

    public void saveFirstPriceData(){
        String price1 = firstProductPrice.getText().trim();
        ConfigReader.setProperty("price1",price1);
    }
    public void saveSecondPriceData(){
        String price2 = secondProductPrice.getText().trim();
        ConfigReader.setProperty("price2", price2);
    }
    public void verifyVisibilitySearchedProducts(String str){
        List<WebElement> products = driver.findElements(By.xpath("//p[contains(text(),'"+str+"')]/../../../../.."));
        for (int i = 0; i < products.size(); i++) {
            Assert.assertTrue("Product"+products.get(i)+"is not visible",products.get(i).isDisplayed());

        }
    }
    public void selectRandomProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        int random = Utils.generateRandomNumber(1,3);
        System.out.println("RANDOM NUMBER IS: "+ random);
        driver.findElement(By.xpath("(//div[@class='single-products']/following-sibling::div/ul/li/a)["+random+"]/i")).click();
    }
}
