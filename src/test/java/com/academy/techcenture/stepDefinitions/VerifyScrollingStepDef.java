package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class VerifyScrollingStepDef {
    private WebDriver driver = Driver.getDriver();

    private HomePage homePage;
    @Given("user is navigated to homepage and homepage is loaded successfully")
    public void user_is_navigated_to_homepage_and_homepage_is_loaded_successfully() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Then("Scroll down page to bottom")
    public void scroll_down_page_to_bottom() throws InterruptedException {
        homePage.scrollDownToSubscribe();
        Thread.sleep(2000);
    }
    @Then("Verify SUBSCRIPTION is visible")
    public void verify_subscription_is_visible() {
        homePage.verifySubscribeText();
    }
    @Then("Click on arrow at bottom right side to move upward")
    public void click_on_arrow_at_bottom_right_side_to_move_upward() {
        homePage.clickOnScrollUpArrow();
    }
    @Then("Verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen")
    public void verify_that_page_is_scrolled_up_and_full_fledged_practice_website_for_automation_engineers_text_is_visible_on_screen() {
        homePage.verifyCarouselText();
    }

}
