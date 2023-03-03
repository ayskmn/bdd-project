package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LogInWithExistEmailStepDef {
    private final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private LoginPage logInPage;
    @Given("user is on the homePage")
    public void user_is_on_the_home_page() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
    }

    @Then("user verify the homePage is visible")
    public void user_verify_the_home_page_is_visible() {
        homePage.verifyUserIsOnAHomePage();
    }

    @When("user  clicks the SignUp  Login button")
    public void user_clicks_the_sign_up_login_button() {
        homePage.clickOnSingInSignUpBtn();
    }

    @When("user verify new  user Signup! is visible")
    public void user_verify_new_user_signup_is_visible() {
        logInPage = new LoginPage(driver);
        logInPage.verifyNewUserSignupIsVisible();
    }

    @When("user enter name and already registered email address")
    public void user_enter_name_and_already_registered_email_address() {
        logInPage.enterExistEmailInLogInField();
    }

    @Then("user clicks on singUp button log in button")
    public void user_clicks_on_sing_up_button_log_in_button() {
        logInPage.clickOnSubmitSignUpBtn();

    }

    @Then("user verify error Email address already exist! is visible")
    public void user_verify_error_email_address_already_exist_is_visible() {
        logInPage.verifyErrorEmailAddressAlreadyExist();

    }
}
