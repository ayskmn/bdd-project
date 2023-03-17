package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.BrandPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class VerifyCartAndBrandStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductPage productPage;

    private BrandPage brandPage;

    @Given("user has landed on the homepage")
    public void user_has_landed_on_the_homepage() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Then("Click on Products button in the navigation menu on the homepage")
    public void click_on_products_button_on_the_homepage() throws InterruptedException {
        homePage.clickOnProductBtn();

    }
    @Then("Verify that Brands are visible on left side bar")
    public void verify_that_brands_are_visible_on_left_side_bar() {
        productPage = new ProductPage(driver);
        productPage.verifyBrandsAreVisible();
    }
    @Then("Click on any brand name")
    public void click_on_any_brand_name() {
        productPage.clickOnABrandLink();
    }
    @When("Verify that user is navigated to brand page and brand products are displayed")
    public void verify_that_user_is_navigated_to_brand_page_and_brand_products_are_displayed() {
        brandPage = new BrandPage(driver);
        brandPage.verifyUserIsOnBrandPage("Babyhug");
        brandPage.verifyBabyhugProducts();
    }
    @Then("On left side bar, click on any other brand link")
    public void on_left_side_bar_click_on_any_other_brand_link() {
        brandPage.clickOnBrandPolo();
    }
    @Then("Verify that user is navigated to that brand page and can see products")
    public void verify_that_user_is_navigated_to_that_brand_page_and_can_see_products() {
        brandPage.verifyUserIsOnBrandPage("Polo");
        brandPage.verifyPoloProducts();
    }

}
