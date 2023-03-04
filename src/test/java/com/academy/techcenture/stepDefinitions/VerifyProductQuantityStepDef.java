package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CartPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductDetailPage;
import com.academy.techcenture.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyProductQuantityStepDef {
    private final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductPage productPage;
    private ProductDetailPage productDetailPage;

    private CartPage cartPage;
    @Given("the user is navigated to homepage")
    public void the_user_is_navigated_to_homepage() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Given("Click View Product for any product on home page")
    public void click_view_product_for_any_product_on_home_page() throws InterruptedException {
        homePage.clickOnProductBtn();
        homePage.closeAd();
    }
    @When("Verify product detail is opened")
    public void verify_product_detail_is_opened() {
        productPage = new ProductPage(driver);
        productPage.selectRandomProduct();
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.verifyProductsDetailsIsVisible();
    }
    @When("Increase quantity to four")
    public void increase_quantity_to_four() throws InterruptedException{
        productDetailPage.increaseQuantity();
    }

    @Then("Click Add to cart button after increasing qty")
    public void click_add_to_cart_button_after_increasing_qty() {
        productDetailPage.addToCart();
    }
    @Then("Click View Cart link")
    public void click_view_cart_link() throws InterruptedException {
        Thread.sleep(3000);
        productDetailPage.clickOnViewCartLink();
    }
    @Then("Verify that product is displayed in cart page with exact quantity")
    public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity() {
        cartPage = new CartPage(driver);
        cartPage.verifyQuantityOfSingleProduct();
    }
}
