package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.wait =new WebDriverWait(driver, 14);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    private WebElement singInSignUpButton;

    @FindBy(xpath = "//div[@id='dismiss-button']/div/span")
    private WebElement dismissBtn;
    @FindBy(xpath = "//iframe[@title='Advertisement']")
    private WebElement iframe;
    @FindBy(xpath = "//iframe[@id='aswift_6']")
    private WebElement parentIframe;
    @FindBy(xpath = "//a[text()=' Logged in as ']")
    private WebElement loginAsUserText;
    @FindBy(xpath = "//a[text()=' Contact us']")
    private WebElement contactUsBtn;
    @FindBy(xpath = " //a[text()=' Test Cases']")
    private WebElement testCasesBtn;
    @FindBy(xpath = "//a[text()=' Products']")
    private WebElement productsBtn;
    @FindBy(xpath="//h2[text()='Subscription']")
    private WebElement subscriptionText;
    @FindBy(xpath="//input[@id='susbscribe_email']")
    private WebElement subscribeInput;
    @FindBy(xpath="//button[@id='subscribe']")
    private WebElement subscribeBtn;
    @FindBy(xpath="//div/div/div[contains(@class,  'alert-success')]")
    private WebElement successMsgBox;
    @FindBy(xpath="//a[text()=' Cart']")
    private WebElement cartLink;
    @FindBy(xpath="//button[text()='Continue Shopping']")
    private WebElement continueShoppingBtn;
    @FindBy(xpath = "//div[@id='accordian']")
    private WebElement categoryBox;
    @FindBy(xpath="//div[@id='accordian']/div/div/h4/a[contains(.,'Women')]")
    private WebElement womenLink;
    @FindBy(xpath="//div[@id='accordian']/div/div/h4/a[contains(.,'Men')]")
    private WebElement menLink;
    @FindBy(xpath="//div[@id='Women']/div/ul/li/a[contains(text(), 'Dress')]")
    private WebElement dressLink;
    @FindBy(xpath="//div[@id='Men']/div/ul/li/a[contains(text(), 'Jeans')]")
    private WebElement jeansLink;
    @FindBy(xpath="//h2[text()='Women - Dress Products']")
    private WebElement dressesHeader;
    @FindBy(xpath="//h2[text()='recommended items']")
    private WebElement recommendedItemsHeader;
    @FindBy(xpath="//div[@id='recommended-item-carousel']")
    private WebElement recommendedItemsCarousel;
    @FindBy(xpath="(//div[@id='recommended-item-carousel']/div/div/div)[1]/div/div/div/a")
    private WebElement addFirstRecommendedItemToCartBtn;
    @FindBy(xpath="(//a[@data-product-id='1' and text()='Add to cart'])[1]/i")
    private WebElement addFirstToCartBtn;
    @FindBy(xpath="(//a[@data-product-id='2' and text()='Add to cart'])[1]/i")
    private WebElement addSecondToCartBtn;


    public void clickOnSingInSignUpBtn(){
        singInSignUpButton.click();
    }
    public void verifyLogInAsUser(){
        Assert.assertTrue("Log in as user not visible",loginAsUserText.getText().trim().equalsIgnoreCase("Logged in as "+ ConfigReader.getProperty("name")));
    }
    public void verifyUserIsOnAHomePage(){
        Assert.assertTrue(driver.getTitle().trim().equalsIgnoreCase("Automation Exercise"));
    }
    public void clickOnContactUsBtn(){
        contactUsBtn.click();
    }
    public void clickTestCasesBtn(){
        testCasesBtn.click();
    }
    public void clickOnProductBtn(){
        productsBtn.click();
    }
    public void closeAd() throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().frame(parentIframe);
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    public void verifySubscriptionText(){
        Assert.assertTrue(subscriptionText.isDisplayed());
    }
    public void enterEmailAndSubsribe(){
        subscribeInput.sendKeys(ConfigReader.getProperty("email1"));
        subscribeBtn.click();
    }
    public void verifySuccessMsgIsVisible(){
        Assert.assertTrue(successMsgBox.getText().equalsIgnoreCase("You have been successfully subscribed!"));
    }
    public void clickOnCartLink(){
        cartLink.click();
    }

    public void addProductsToCartOnTheHomepage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        int random = Utils.generateRandomNumber(1,3);
        driver.findElement(By.xpath("(//div[@class='single-products']/following-sibling::div/ul/li/a)["+random+"]/i")).click();
        closeAd();
    }

    public void scrollUpToTopOfThePage(){
        WebElement element = driver.findElement(By.tagName("header"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void continueShopping(){
        Assert.assertTrue("Continue btn is not enabled",continueShoppingBtn.isEnabled());
        continueShoppingBtn.click();
    }
    public void addRandomProductToCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        int random = Utils.generateRandomNumber(1,3);
        driver.findElement(By.xpath("//div[@class='single-products']/div/a[@data-product-id='"+random+"' and @class='btn btn-default add-to-cart']/i[1]")).click();
    }
    public void verifyCategoryIsDisplayed(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        Assert.assertTrue("Categories are not displayed", categoryBox.isDisplayed());
    }
    public void clickOnWomenCategory(){
        Assert.assertTrue("WOMEN link is not enabled", womenLink.isEnabled());
        womenLink.click();
    }
    public void clickOnDressLink(){
        Assert.assertTrue("Dress link is not enabled", dressLink.isEnabled());
        dressLink.click();
    }
    public void verifyDressPage(){
        Assert.assertTrue("Dresses page is visible", dressesHeader.isDisplayed());
    }
    public void clickOnMenCategory(){
        Assert.assertTrue("MEN link is not enabled", menLink.isEnabled());
        menLink.click();
        Assert.assertTrue("Jeans link is not enabled", jeansLink.isEnabled());
        jeansLink.click();
    }
    public void verifyUserIsOnCategoryPage(){
        String title = driver.getTitle();
        Assert.assertTrue("Category page title is not correct", title.equalsIgnoreCase("Automation Exercise - Jeans Products"));
    }
    public void scrollDownToRecommendedItems(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", recommendedItemsHeader);
    }
    public void verifyRecommendedItemsHeader(){
        Assert.assertTrue("Recommended items header is not displayed", recommendedItemsHeader.isDisplayed());
    }
    public void addRecommendedToCart(){
        wait.until(ExpectedConditions.visibilityOf(addFirstRecommendedItemToCartBtn));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView", recommendedItemsCarousel);
        Assert.assertTrue("First recommended item's add to cart btn is not displayed",
                addFirstRecommendedItemToCartBtn.isDisplayed());
        addFirstRecommendedItemToCartBtn.click();
    }
    public void clickOnViewCart(){
        driver.findElement(By.xpath("//a/u[text()='View Cart']")).click();
    }
    public void addFirstProductToCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        addFirstToCartBtn.click();
        continueShoppingBtn.click();
    }
    public void addSecondProductToCart(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,550)", "");
        addSecondToCartBtn.click();
    }

}
