package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CartPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddProductsStepDef {
    private final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductPage productPage;

    private CartPage cartPage;

    @Given("user landing on the homePage")
    public void user_landing_on_the_home_page() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Given("Click Products button")
    public void click_products_button() throws InterruptedException {
        homePage.clickOnProductBtn();
        homePage.closeAd();
    }
    @Then("Hover over first product and click Add to cart")
    public void hover_over_first_product_and_click_add_to_cart() {
        productPage = new ProductPage(driver);
        productPage.saveFirstPriceData();
        productPage.addFirstProductToCart();

    }
    @When("Click Continue Shopping button")
    public void click_continue_shopping_button() {
        productPage.clickOnContinueBtn();
    }
    @Then("Hover over second product and click Add to cart")
    public void hover_over_second_product_and_click_add_to_cart() {
        productPage.saveSecondPriceData();
        productPage.addSecondProductToCart();
    }
    @Then("Click View Cart button")
    public void click_view_cart_button() throws InterruptedException {
        Thread.sleep(3000);
        productPage.clickOnViewCart();
    }
    @Then("Verify both products are added to Cart")
    public void verify_both_products_are_added_to_cart() {
        cartPage = new CartPage(driver);
        cartPage.verifyHowManyProductsInCart(2);

    }
    @Then("Verify their prices, quantity and total price")
    public void verify_their_prices_quantity_and_total_price() {

    }
}
