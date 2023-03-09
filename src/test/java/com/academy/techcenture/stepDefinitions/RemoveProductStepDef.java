package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CartPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ja.且つ;
import org.openqa.selenium.WebDriver;

public class RemoveProductStepDef {

    private WebDriver driver = Driver.getDriver();

    private HomePage homePage;

    private ProductPage productPage;

    private CartPage cartPage;

    @Given("user navigates to homepage successfully")
    public void user_navigates_to_homepage_successfully() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Then("adds products to cart")
    public void adds_products_to_cart() throws InterruptedException{
        homePage.clickOnProductBtn();
        homePage.closeAd();
        productPage = new ProductPage(driver);
        productPage.verifyUserOnAProductPage();
        productPage.addFirstProductToCart();
        productPage.clickOnContinueBtn();
        productPage.clickOnCartAfterScrollingToTop();
    }
    @Then("clicks on the cart btn and verifies cart page is displayed")
    public void clicks_on_the_cart_btn_and_verifies_cart_page_is_displayed() {
        cartPage = new CartPage(driver);
        cartPage.verifyUserIsOnCartPage();

    }
    @When("clicks X btn corresponding to particular product")
    public void clicks_x_btn_corresponding_to_particular_product() {
        cartPage.removeFirstProductFromCart();
    }
    @Then("verifies that product is removed from the cart")
    public void verifies_that_product_is_removed_from_the_cart() throws InterruptedException {
        Thread.sleep(3000);
        cartPage.verifyCartIsEmpty();
    }

}
