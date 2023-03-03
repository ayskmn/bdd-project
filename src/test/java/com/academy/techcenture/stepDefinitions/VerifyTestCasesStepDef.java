package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.VerifyTestCasesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class VerifyTestCasesStepDef {
    private final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    VerifyTestCasesPage verifyTestCasesPage;

    @Given("Given user navigates to home page and page is visible")
    public void userNavigatesToHomePageAndPageIsVisible() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
    }
    @Then("user Click on  Test Cases button")
    public void user_click_on_test_cases_button() throws InterruptedException {
        homePage.clickTestCasesBtn();
        homePage.closeAd();
    }
    @Then("User verify is navigate to test cases page successfully")
    public void user_verify_is_navigate_to_test_cases_page_successfully() {
        verifyTestCasesPage = new VerifyTestCasesPage(driver);
        verifyTestCasesPage.verifyUserIsOnTestCasesPage();
    }
}
