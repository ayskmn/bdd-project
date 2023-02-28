package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SearchProductStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductPage productPage;
    @Given("user navigates to the home page")
    public void user_navigates_to_the_home_page() {
       homePage = new HomePage(driver);
       homePage.navigate_to_home_page();
       homePage.verifyUserIsOnAHomePage();
    }
    @When("user Click on Products button")
    public void user_click_on_products_button() throws InterruptedException {
        homePage.clickOnProductBtn();
        homePage.closeAd();
    }
    @When("user Verify user is navigated to ALL PRODUCTS page successfully")
    public void user_verify_user_is_navigated_to_all_products_page_successfully() {
        productPage = new ProductPage(driver);
        productPage.verifyUserOnAProductPage();
    }
    @When("user Enter product name in search input and click search button")
    public void user_enter_product_name_in_search_input_and_click_search_button() {
        productPage.searchProduct(ConfigReader.getProperty("product"));


    }
    @Then("user Verify SEARCHED PRODUCTS is visible")
    public void user_verify_searched_products_is_visible() {

       productPage.verifyAllProductsIsVisible();
    }
    @Then("user Verify all the products related to search are visible")
    public void user_verify_all_the_products_related_to_search_are_visible() {
        productPage.verifyVisibilitySearchedProducts(ConfigReader.getProperty("product"));
    }
}
