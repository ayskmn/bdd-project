package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CartPage;
import com.academy.techcenture.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;


public class AddToCartFromRecommendedStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;

    private CartPage cartPage;

    @Given("browser is launched and user is navigated to homepage")
    public void browser_is_launched_and_user_is_navigated_to_homepage() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
    }
    @Then("scrolls down to footer")
    public void scrolls_down_to_footer() {
        homePage.scrollDownToRecommendedItems();
    }
    @Then("verifies RECOMMENDED ITEMS are visible")
    public void verifies_recommended_items_are_visible() {
        homePage.verifyRecommendedItemsHeader();
    }
    @Then("Click on Add To Cart on Recommended product")
    public void click_on_add_to_cart_on_recommended_product() {
        homePage.addRecommendedToCart();
    }
    @Then("clicks on view cart button after adding product")
    public void clicks_on_view_cart_button_after_adding_product() {
        homePage.clickOnViewCart();
    }
    @Then("Verifies that product is displayed in cart page")
    public void verifies_that_product_is_displayed_in_cart_page() {
        cartPage = new CartPage(driver);
        cartPage.verifyFirstProductIsInCart();
    }
}
