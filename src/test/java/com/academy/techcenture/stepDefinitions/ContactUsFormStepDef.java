package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.ContactUsPage;
import com.academy.techcenture.pages.HomePage;
import com.google.common.base.CharMatcher;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class ContactUsFormStepDef {
    private static WebDriver driver = Driver.getDriver();

    private HomePage homePage;
    private ContactUsPage contactUsPage;
    @Given("user is on a Home Page and home page is visible")
    public void user_is_on_a_home_page_and_home_page_is_visible() throws InterruptedException{
        homePage = new HomePage(driver);
//        homePage.closeAd();
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @When("user Clicks on Contact Us button")
    public void user_clicks_on_contact_us_button() {
        homePage = new HomePage(driver);
        homePage.clickOnContactUsBtn();
    }
    @When("user verifies get in touch is visible")
    public void user_verifies_get_in_touch_is_visible() {
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.VerifyGetInTouchMSG();
    }
    @Then("user enters name, email, subject and message")
    public void user_enters_name_email_subject_and_message(List<Map<String,String>> data) {
        Map<String, String> userInfo =data.get(0);
        contactUsPage.enterName(userInfo.get("name"));
        contactUsPage.enterEmail(userInfo.get("email"));
        contactUsPage.enterMsg(userInfo.get("message"));
    }
    @When("user uploads a file")
    public void user_uploads_a_file() {

        String filePath = "/Users/ayse/Desktop/cat03.jpg";
        contactUsPage.uploadFile(filePath);
    }
    @When("user clicks on a submit button")
    public void user_clicks_on_a_submit_button() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        contactUsPage.clickOnSubmitBtn();
    }
    @Then("user clicks ok button")
    public void user_clicks_ok_button() {
        driver.switchTo().alert().accept();
    }
    @Then("user veryfies Verify success message \\(Success! Your details have been submitted successfully.) is visible")
    public void user_veryfies_verify_success_message_success_your_details_have_been_submitted_successfully_is_visible() {
        contactUsPage.verifySuccessMsgIsDisplayed();
    }
    @Then("user clicks on Home button and verify that landed to home page successfully")
    public void user_clicks_on_home_button_and_verify_that_landed_to_home_page_successfully() {
        contactUsPage.clickOnHomeBtn();
      //  homePage.verifyUserIsOnAHomePage();
    }

}
