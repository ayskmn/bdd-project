package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class VerifyAddressDetailsInCheckoutStepDef {
    private WebDriver driver = Driver.getDriver();
    private Select select;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountCreatedSuccessfullyPage accountCreatedSuccessfullyPage;
    private CartPage cartPage;
    private Checkout checkout;

    @Given("Navigate to automationexercise.com and verify homepage is visible")
    public void navigate_to_http_automationexercise_com_and_verify_homepage_is_visible() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Given("click signupLogin button when on homepage")
    public void click_signup_login_button_when_on_homepage() {
        homePage.clickOnSingInSignUpBtn();
    }
    @Then("fill all details and create a new account")
    public void fill_all_details_and_create_a_new_account(List<Map<String,String>> data) {
        loginPage = new LoginPage(driver);
        loginPage.enterNameAndEmail();
        loginPage.clickOnSignupBtn();
        Map<String, String> userInfo =data.get(0);
        String password = userInfo.get("Password").trim();
        String title = userInfo.get("Title");
        String date = userInfo.get("Date").trim();
        String month = userInfo.get("Month").trim();
        String year = userInfo.get("Year");
        String first_name = userInfo.get("First name");
        String last_name = userInfo.get("Last name");
        ConfigReader.setProperty("firstName", first_name.trim());
        ConfigReader.setProperty("lastName", last_name.trim());
        ConfigReader.setProperty("title", title.trim());
        String address = userInfo.get("Address");
        ConfigReader.setProperty("streetAddress", address);
        String country = userInfo.get("Country");
        ConfigReader.setProperty("country", country);
        String state = userInfo.get("State");
        String city = userInfo.get("City");
        String zipcode = userInfo.get("Zipcode");
        ConfigReader.setProperty("cityStateZip", city+" "+state+" "+zipcode);
        String mobile = userInfo.get("Mobile");
        ConfigReader.setProperty("phoneNumber", mobile);
        WebElement country1 = driver.findElement(By.id("country"));
        driver.findElement(By.xpath("//label[text()='Title']/following-sibling::div/label/div/span/input[@value='"+title+"']")).click();
        driver.findElement(By.id("password")).sendKeys(password);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement days = driver.findElement(By.id("days"));
        select = new Select(days);
        select.selectByVisibleText(date);
        WebElement months = driver.findElement(By.id("months"));
        select = new Select(months);
        select.selectByVisibleText(month);
        WebElement years = driver.findElement(By.id("years"));
        select = new Select(years);
        select.selectByValue(year);
        driver.findElement(By.id("first_name")).sendKeys(first_name);
        driver.findElement(By.id("last_name")).sendKeys(last_name);
        driver.findElement(By.id("address1")).sendKeys(address);
        select = new Select(country1);
        select.selectByValue(country);
        driver.findElement(By.id("state")).sendKeys(state);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("zipcode")).sendKeys(zipcode);
        driver.findElement(By.id("mobile_number")).sendKeys(mobile);
        loginPage.clickOnCreateAccountBtn();
    }
    @Then("verify ACCOUNT CREATED! and click on continue button")
    public void verify_account_created_and_click_on_continue_button() throws InterruptedException {
        accountCreatedSuccessfullyPage = new AccountCreatedSuccessfullyPage(driver);
        accountCreatedSuccessfullyPage.verifyNavigatedToAccountCreatedSuccessfullyPage();
        accountCreatedSuccessfullyPage.clickOnContinueBtn();
    }
    @Then("verify logged in as username text at top")
    public void verify_logged_in_as_username_text_at_top() {
        homePage = new HomePage(driver);
        homePage.verifyLogInAsUser();
    }
    @Then("add some products to cart")
    public void add_some_products_to_cart() throws InterruptedException {
        homePage.addFirstProductToCart();
        homePage.addSecondProductToCart();
        homePage.clickOnViewCart();
    }
    @Then("click on the cart link and verify the cart page is displayed")
    public void click_on_the_cart_link_and_verify_the_cart_page_is_displayed() {
        cartPage = new CartPage(driver);
        cartPage.verifyUserIsOnCartPage();
    }
    @Then("click proceed to checkout button")
    public void click_proceed_to_checkout_button() {
        cartPage.clickOnProceedToCheckoutBtn();
    }
    @Then("Verify that the delivery address is same address filled at the time registration of account")
    public void verify_that_the_delivery_address_is_same_address_filled_at_the_time_registration_of_account() {
        checkout = new Checkout(driver);
        checkout.verifyShippingInfo();
    }
    @Then("Verify that the billing address is same address filled at the time registration of account")
    public void verify_that_the_billing_address_is_same_address_filled_at_the_time_registration_of_account() {
        checkout.verifyBillingInfo();
    }
}
