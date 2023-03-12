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
    @FindBy(xpath="//a[text()=' Cart']")
    private WebElement cartLink;
    @FindBy(xpath="//div[@class='brands-name']")
    private WebElement brandsLinkBox;
    @FindBy(xpath="//div[@class='brands-name']/ul/li/a[text()='Babyhug']")
    private WebElement babyHugLink;
    @FindBy(xpath="//input[@id='search_product']")
    private WebElement searchInput;
    @FindBy(xpath="//button[@id='submit_search']")
    private WebElement searchBtn;
    @FindBy(xpath="//h2[text()='Searched Products']")
    private WebElement searchedProductsHeader;
    @FindBy(xpath = "(//ul/li/a[text()='View Product'])[1]")
    private WebElement viewFirstProductBtn;

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
        driver.findElement(By.xpath("(//div[@class='single-products']/following-sibling::div/ul/li/a)["+random+"]/i")).click();
    }
    public void addRandomProductToCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        int random = Utils.generateRandomNumber(1,3);
        driver.findElement(By.xpath("(//a[@data-product-id='"+random+"' and text()='Add to cart']/i)[1]")).click();

    }

    public void clickOnCartAfterScrollingToTop(){
        WebElement element = driver.findElement(By.tagName("header"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        cartLink.click();
    }
    public void clickOnCartLink(){
        Assert.assertTrue("Cart link in the navbar is not enabled", cartLink.isEnabled());
        cartLink.click();
    }

    public void verifyBrandsAreVisible(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)", "");
        Assert.assertTrue("Brands are not displayed on the left menu", brandsLinkBox.isDisplayed());
    }
    public void clickOnABrandLink(){
        Assert.assertTrue("Babyhug link is not enabled", babyHugLink.isEnabled());
        babyHugLink.click();
    }

    public void searchProduct(){
        Assert.assertTrue("Search input is not enabled", searchInput.isEnabled());
        searchInput.click();
        searchInput.sendKeys("Dress");
        Assert.assertTrue("Search button is not enabled", searchBtn.isEnabled());
        searchBtn.click();
    }
    public void scrollToTop(){
        WebElement element = driver.findElement(By.tagName("header"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void verifySearchedProductsTitle(){
        Assert.assertTrue("SEARCHED PRODUCTS header is not displayed", searchedProductsHeader.isDisplayed());
    }
    public void verifySearchProducts(String keyword){
        List<WebElement> searchResults = driver.findElements(By.xpath
                ("//div[@class='single-products']/div/img/following-sibling::h2/following-sibling::p[contains(., '"+keyword+"')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i=0;i<searchResults.size();i++){
            js.executeScript("window.scrollBy(0,110)", "");
            Assert.assertTrue("products are not displayed", searchResults.get(i).isDisplayed());
            js.executeScript("window.scrollBy(0,310)", "");
        }
    }
    public void addSearchProductsToCart() throws InterruptedException {
        List<WebElement> addToCartBtns = driver.findElements(By.xpath("//p[contains(text(), 'Dress')]/following-sibling::a[text()='Add to cart']"));
        for(int i=0; i<addToCartBtns.size(); i++){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,410)", "");
            Thread.sleep(3000);
            addToCartBtns.get(i).click();
            clickOnContinueBtn();
            js.executeScript("window.scrollBy(0,510)", "");
            Thread.sleep(3000);
            i++;
        }
        ConfigReader.setProperty("ProductsSize", String.valueOf(addToCartBtns.size()));
    }

    public void clickOnViewFirstProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,410)", "");
        Assert.assertTrue("View Product button is not enabled", viewFirstProductBtn.isEnabled());
        viewFirstProductBtn.click();
    }
}
