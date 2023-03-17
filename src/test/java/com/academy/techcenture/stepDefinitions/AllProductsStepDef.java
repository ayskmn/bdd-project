package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductDetailPage;
import com.academy.techcenture.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AllProductsStepDef {
    private static final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductPage productPage;
    private ProductDetailPage productDetailPage;
    @Given("user is on the HomePage")
    public void user_is_on_the_home_page() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @When("user Clicks on Products button")
    public void user_clicks_on_products_button() {
        homePage.clickOnProductBtn();
    }
    @Then("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_user_is_navigated_to_all_products_page_successfully() {
        productPage = new ProductPage(driver);
        productPage.verifyUserOnAProductPage();
    }
    @Then("user verifies The products list is visible")
    public void user_verifies_the_products_list_is_visible() {
        productPage.verifyAllProductsIsVisible();
    }
    @Then("user  Clicks on View Product of first product")
    public void user_clicks_on_view_product_of_first_product() {
        productPage.clickOnFirstProduct();
    }
    @When("user User is landed to product detail page")
    public void user_user_is_landed_to_product_detail_page() {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.verifyUserIsOnProductDetailsPage();
    }
    @Then("user Verifies that detail is visible: product name, category, price, availability, condition, brand")
    public void user_verifies_that_detail_is_visible_product_name_category_price_availability_condition_brand() {
        productDetailPage.verifyProductsDetailsIsVisible();
    }

}
