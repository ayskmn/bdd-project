package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewCartPage extends BasePage{

    public ViewCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//div[@class='breadcrumbs']/ol/li/following-sibling::li[text()='Shopping Cart']")
    private WebElement shoppingCartText;

    @FindBy(xpath="//tbody/tr")
    private List<WebElement> products;

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    private WebElement signupLoginLink;



    public void verifyUserIsOnViewCartPage(){
        Assert.assertTrue("Shopping cart txt is not displayed", shoppingCartText.isDisplayed());
    }
    public void verifyProductsAddedToCart(){
        int productsInCartSize = products.size();
        int savedProductsSize = Integer.parseInt(ConfigReader.getProperty("ProductsSize"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i=0;i<products.size();i++){
            js.executeScript("window.scrollBy(0,110)", "");
            Assert.assertTrue("products are not displayed", products.get(i).isDisplayed());
            js.executeScript("window.scrollBy(0,310)", "");
        }
        Assert.assertTrue("All products are not added to cart", productsInCartSize==(savedProductsSize/2));
    }
    public void scrollToTop(){
        WebElement element = driver.findElement(By.tagName("header"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickOnSignUpLoginLink(){
        Assert.assertTrue("Signup/Login link is not enabled", signupLoginLink.isEnabled());
        signupLoginLink.click();
    }
    public void verifyProductsInCartAfterLogin(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i=0;i<products.size();i++){
            js.executeScript("window.scrollBy(0,110)", "");
            Assert.assertTrue("products are not displayed", products.get(i).isDisplayed());
            js.executeScript("window.scrollBy(0,310)", "");
        }
        Assert.assertTrue("All products are not added to cart", products.size()==9);
    }

}
