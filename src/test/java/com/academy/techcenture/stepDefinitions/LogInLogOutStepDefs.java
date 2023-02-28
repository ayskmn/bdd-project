package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LogInLogOutStepDefs {
    private final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private LoginPage logInPage;
    @Given("user navigates to home page and page is visible")
    public void userNavigatesToHomePageAndPageIsVisible() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
    }
    @When("user clicking on Signup Login button")
    public void userClickingOnSignupLoginButton() {
        homePage.clickOnSingInSignUpBtn();

    }
    @And("user Verifies Login to your account is visible")
    public void userVerifiesLoginToYourAccountIsVisible() {
        logInPage = new LoginPage(driver);
        logInPage.verifyLogInToAccountIsVisible();

    }

    @Then("user Enter correct email address and password")
    public void user_enter_correct_email_address_and_password() {
        logInPage = new LoginPage(driver);
        logInPage.enterEmailAndPasswordOnLogInLine();

    }
    @Then("user  Clicks login button")
    public void user_clicks_login_button() {
        logInPage.clickLogInBtn();
    }
    @Then("user verify  log in success is visible")
    public void user_verify_log_in_success_is_visible() {
        homePage.verifyLogInAsUser();
    }
    @Then("user Enter incorrect email address and password")
    public void user_enter_incorrect_email_address_and_password() {
        logInPage = new LoginPage(driver);
        logInPage.logInWithIncorrectCredentials();
    }
    @Then("user  Clicks login button after")
    public void user_clicks_login_button_after() {
        logInPage.clickLogInBtn();
    }
    @Then("user verify error Your email or password is incorrect! is visible")
    public void user_verify_error_your_email_or_password_is_incorrect_is_visible() {
        logInPage.verifyIncorrectLogInTextIsVisible();
    }








}
