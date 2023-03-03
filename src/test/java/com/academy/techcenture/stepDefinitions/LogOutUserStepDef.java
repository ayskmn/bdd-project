package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LogOutUserStepDef {
    private final WebDriver driver = Driver.getDriver();
    private LoginPage loginPage;
    private HomePage homePage;
    @Given("user navigated to home page and page is visible")
    public void userNavigatesToHomePageAndPageIsVisible() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
    }
    @When("user clicks on Signup Login button")
    public void userClickingOnSignupLoginButton() {
        homePage.clickOnSingInSignUpBtn();
    }
    @And("user Verifies Login to your account Is visible")
    public void userVerifiesLoginToYourAccountIsVisible() {
        loginPage = new LoginPage(driver);
        loginPage.verifyLogInToAccountIsVisible();

    }
    @Then("user Enters correct email address and password")
    public void user_enter_correct_email_address_and_password() {
        loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPasswordOnLogInLine();

    }
    @Then("user  Click login button")
    public void user_clicks_login_button() {
        loginPage.clickLogInBtn();
    }
    @Then("user verifies  log in success is visible")
    public void user_verify_log_in_success_is_visible() {
        homePage.verifyLogInAsUser();
    }
    @When("user click log out button")
    public void user_clicks_log_out_button() {
        loginPage = new LoginPage(driver);
        loginPage.logOutUser();
    }
    @Then("user navigated to home page")
    public void user_navigates_to_home_page() {
        homePage = new HomePage(driver);

    }

}
