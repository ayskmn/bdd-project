package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class VerifySubscriptionStepDef {
    private final WebDriver driver = Driver.getDriver();
    private HomePage homePage;

    @Given("User navigates to home page and page is visible")
    public void user_navigates_to_home_page_and_page_is_visible() {
       homePage = new HomePage(driver);
       homePage.navigate_to_home_page();
       homePage.verifyUserIsOnAHomePage();
    }
    @Given("Scroll down to footer")
    public void scroll_down_to_footer() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    @Then("Verify text SUBSCRIPTION")
    public void verify_text() {
        homePage.verifySubscriptionText();
    }
    @When("Enter email address in input and click arrow button")
    public void enter_email_address_in_input_and_click_arrow_button() {
        homePage.enterEmailAndSubsribe();

    }
    @Then("Verify success message You have been successfully subscribed! is visible")
    public void verify_success_message_you_have_been_successfully_subscribed_is_visible() {
        homePage.verifySuccessMsgIsVisible();
    }

}
