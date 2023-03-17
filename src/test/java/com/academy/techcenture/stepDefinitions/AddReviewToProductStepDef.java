package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductDetailPage;
import com.academy.techcenture.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddReviewToProductStepDef {

    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductPage productPage;

    private ProductDetailPage productDetailPage;

    @Given("user is on the homepage, verifies homepage is loaded successfully")
    public void user_is_on_the_homepage_verifies_homepage_is_loaded_successfully() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Then("user goes to product link and navigated to ALL PRODUCTS page successfully")
    public void user_goes_to_product_link_and_navigated_to_all_products_page_successfully() throws InterruptedException {
        homePage.clickOnProductBtn();
        productPage = new ProductPage(driver);
    }
    @Then("clicks on view product to navigate to that products page")
    public void clicks_on_view_product_to_navigate_to_that_products_page() {
        productPage.verifyUserOnAProductPage();
    }
    @Then("clicks on view product btn")
    public void clicks_on_view_product_btn() {
        productPage.clickOnViewFirstProduct();
    }
    @When("verifies Write Your Review is visible")
    public void verifies_write_your_review_is_visible() {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.verifyWriteYourReviewText();
    }
    @Then("enters name, email and review")
    public void enters_name_email_and_review() {
        productDetailPage.submitReviewForAProduct();
    }
    @Then("clicks on submit button")
    public void clicks_on_submit_button() {
        productDetailPage.clickOnSubmitBtn();
    }
    @Then("verifies success message Thank you for your review is visible")
    public void verifies_success_message_thank_you_for_your_review_is_visible() {
        productDetailPage.verifyThankYouText();
    }
}
