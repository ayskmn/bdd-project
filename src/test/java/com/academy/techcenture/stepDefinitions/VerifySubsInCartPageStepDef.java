package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CartPage;
import com.academy.techcenture.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class VerifySubsInCartPageStepDef {
    private final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private CartPage cartPage;


    @Given("user landing on a home Page")
    public void user_landing_on_a_home_page() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @When("user clicks on a cart button")
    public void user_clicks_on_a_cart_button() {
        homePage.clickOnCartLink();
    }
    @When("user Scrolls down to footer")
    public void user_scrolls_down_to_footer() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    @When("Verify text SUBSCRIPTION is displayed")
    public void verify_text_subscription_is_displayed() {
        cartPage = new CartPage(driver);
        cartPage.verifySubscriptionTitleIsVisible();
    }
    @Then("Enter email address in input field and click arrow button")
    public void enter_email_address_in_input_field_and_click_arrow_button() {
        cartPage.subscribe();
    }
    @Then("Verify success message \\(You have been successfully subscribed!) is visible")
    public void verify_success_message_you_have_been_successfully_subscribed_is_visible() {
        homePage.verifySubscriptionText();
    }




}
