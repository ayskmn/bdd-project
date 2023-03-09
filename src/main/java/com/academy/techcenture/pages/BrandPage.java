package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrandPage extends BasePage {

    public BrandPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='single-products']")
    private List<WebElement> listOfProducts;

    @FindBy(xpath="//div[@class='brands-name']/ul/li/a[text()='Polo']")
    private WebElement poloLink;
    public void verifyUserIsOnBrandPage(String brand){
        String title = driver.getTitle();
        Assert.assertEquals("Automation Exercise - "+brand+" Products", title);
    }
    public void verifyBabyhugProducts(){
        Assert.assertTrue("All products are not displayed", listOfProducts.size()==4);
    }
    public void clickOnBrandPolo(){
        Assert.assertTrue("Polo link is not enabled", poloLink.isEnabled());
        poloLink.click();
    }
    public void verifyPoloProducts(){
        Assert.assertTrue("All products are not displayed", listOfProducts.size()==6);
    }

}
