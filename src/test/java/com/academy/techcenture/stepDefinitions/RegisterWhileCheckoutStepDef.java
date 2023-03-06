package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;


public class RegisterWhileCheckoutStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private LoginPage loginPage;
    private Select select;
    private AccountCreatedSuccessfullyPage accountCreatedSuccessfullyPage;

    private Checkout checkout;


    @Given("User verify that the home page is visible successfully")
    public void user_verify_that_the_home_page_is_visible_successfully() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Then("Useradd products to cart")
    public void useradd_products_to_cart() throws InterruptedException{
        homePage.clickOnProductBtn();
        homePage.closeAd();
        productPage = new ProductPage(driver);
        productPage.addFirstProductToCart();
        productPage.clickOnContinueBtn();
        productPage.addSecondProductToCart();
        productPage.clickOnContinueBtn();
    }
    @Then("User clicks on the Cart link in navbar")
    public void user_clicks_on_the_cart_link_in_navbar() {
        productPage.clickOnCartAfterScrollingToTop();
    }
    @Then("User verifies that the cart page is displayed")
    public void user_verifies_that_the_cart_page_is_displayed() {
        cartPage = new CartPage(driver);
        cartPage.verifyUserIsOnCartPage();
        cartPage.verifyTotalPrice();
    }
    @Then("User clicks on the Proceed To Checkout button in the cart page")
    public void user_clicks_on_the_proceed_to_checkout_button_in_the_cart_page() {
        cartPage.clickOnProceedToCheckoutBtn();
    }
    @When("User click on the Register  Login button")
    public void user_click_on_the_register_login_button() {
        cartPage.clickOnRegisterLinkAtCheckout();
    }
    @When("user fill details: <First name>, <Last name>, <Company>, <Address>, <Address2>, <Country>, <State>, <City>, <Zipcode>, <Mobile>")
    public void user_fill_all_details_in_signup_and_create_an_account(List<Map<String,String>> data) {
        loginPage = new LoginPage(driver);
        Map<String, String> userInfo =data.get(0);
        loginPage.enterNameAndEmail();
        loginPage.clickOnSubmitSignUpBtn();
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
    @Then("User verify ACCOUNT CREATED! and click the Continue button")
    public void user_verify_account_created_and_click_the_continue_button() {
        accountCreatedSuccessfullyPage = new AccountCreatedSuccessfullyPage(driver);
        accountCreatedSuccessfullyPage.verifyNavigatedToAccountCreatedSuccessfullyPage();
        accountCreatedSuccessfullyPage.clickOnContinueBtn();
    }
    @Then("User verify Logged in as username at the top")
    public void user_verify_logged_in_as_username_at_the_top() {
        homePage = new HomePage(driver);
        homePage.verifyLogInAsUser();
    }
    @When("User clicks on the Cart btn after registering")
    public void user_clicks_on_the_cart_btn_after_registering() {
        homePage.clickOnCartLink();
    }
    @When("User clicks on Proceed To Checkout button")
    public void user_clicks_on_proceed_to_checkout_button() {
        cartPage = new CartPage(driver);
        cartPage.clickOnProceedToCheckoutBtn();
    }
    @Then("User verify Address Details and Review Your Order")
    public void user_verify_address_details_and_review_your_order() {
        checkout = new Checkout(driver);
        checkout.verifyShippingInfo();

    }
    @When("User enters a description in the comment text area")
    public void user_enters_a_description_in_the_comment_text_area() {
        checkout.makeACommentForTheOrder();
    }
    @When("User clicks on the Place Order button")
    public void user_clicks_on_the_place_order_button() {
        checkout.clickOnPlaceOrderBtn();
    }
    @Then("User enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void user_enter_payment_details_name_on_card_card_number_cvc_expiration_date() {

    }
    @Then("User clicks on the Pay and Confirm Order button")
    public void user_clicks_on_the_pay_and_confirm_order_button() {

    }
    @Then("User verifies the success message Your order has been placed successfully!")
    public void user_verifies_the_success_message_your_order_has_been_placed_successfully() {

    }
}
