package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.ProductPage;
import com.academy.techcenture.pages.ViewCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SearchProductsAndAddToCartStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductPage productPage;
    private ViewCartPage viewCartPage;

    private LoginPage loginPage;
    @Given("user has landed on the Homepage")
    public void user_has_landed_on_the_homepage() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @When("user clicks on products button user lands on the all products page")
    public void user_clicks_on_products_button_user_lands_on_the_all_products_page() throws InterruptedException {
        homePage.clickOnProductBtn();
        homePage.closeAd();
    }
    @When("Enter product name in search input and click search button")
    public void enter_product_name_in_search_input_and_click_search_button() {
        productPage = new ProductPage(driver);
        productPage.searchProduct();
    }
    @Then("Verify SEARCHED PRODUCTS is visible")
    public void verify_searched_products_is_visible() {
        productPage.verifySearchedProductsTitle();
    }
    @Then("Verify all the products related to search are visible")
    public void verify_all_the_products_related_to_search_are_visible() {
        productPage.verifySearchProducts("Dress");
        productPage.scrollToTop();
    }
    @Then("Add those products to cart")
    public void add_those_products_to_cart() throws InterruptedException {
        productPage.addSearchProductsToCart();
        productPage.scrollToTop();
    }
    @Then("Click Cart button and verify that products are visible in cart")
    public void click_cart_button_and_verify_that_products_are_visible_in_cart() {
        productPage.clickOnCartLink();
        viewCartPage = new ViewCartPage(driver);
        viewCartPage.verifyUserIsOnViewCartPage();
        viewCartPage.verifyProductsAddedToCart();
    }
    @Then("Click Signup Login button and submit login details")
    public void click_signup_login_button_and_submit_login_details() {
        viewCartPage.scrollToTop();
        viewCartPage.clickOnSignUpLoginLink();
        loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPasswordOnLogInLine();
        loginPage.clickLogInBtn();
    }
    @Then("Again go to Cart page")
    public void again_go_to_cart_page() {
        homePage = new HomePage(driver);
        homePage.clickOnCartLink();
    }
    @Then("Verify that those products are visible in cart after login as well")
    public void verify_that_those_products_are_visible_in_cart_after_login_as_well() {
        viewCartPage = new ViewCartPage(driver);
        viewCartPage.verifyProductsInCartAfterLogin();
    }
}
