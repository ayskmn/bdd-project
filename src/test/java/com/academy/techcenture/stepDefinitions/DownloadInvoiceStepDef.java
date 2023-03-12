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

public class DownloadInvoiceStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private CartPage cartPage;
    private ViewCartPage viewCartPage;
    private Select select;
    private LoginPage loginPage;
    private AccountCreatedSuccessfullyPage accountCreatedSuccessfullyPage;

    private PaymentDonePage paymentDonePage;

    private PaymentPage paymentPage;

    private Checkout checkout;
    @Given("user is on the homepage, homepage is visible successfully")
    public void user_is_on_the_homepage_homepage_is_visible_successfully() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Given("user adds products to cart and clicks on the cart button")
    public void user_adds_products_to_cart_and_clicks_on_the_cart_button() {
        homePage.addFirstProductToCart();
        homePage.addSecondProductToCart();
        homePage.clickOnViewCart();
    }
    @Then("verify that cart page is displayed successfully")
    public void verify_that_cart_page_is_displayed_successfully() {
        cartPage = new CartPage(driver);
        cartPage.verifyUserIsOnCartPage();
    }
    @Then("clicks on proceed to checkout button in the cart page")
    public void clicks_on_proceed_to_checkout_button_in_the_cart_page() {
        cartPage.clickOnProceedToCheckoutBtn();
    }
    @Then("clicks on Register Login button and creates a new account")
    public void clicks_on_register_login_button_and_creates_a_new_account(List<Map<String,String>> data) {
        viewCartPage = new ViewCartPage(driver);
        viewCartPage.clickOnRegisterLoginLink();
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
    @Then("verifies the account created successfully page and clicks the continue button")
    public void verifies_the_account_created_successfully_page_and_clicks_the_continue_button() {
        accountCreatedSuccessfullyPage = new AccountCreatedSuccessfullyPage(driver);
        accountCreatedSuccessfullyPage.verifyNavigatedToAccountCreatedSuccessfullyPage();
        accountCreatedSuccessfullyPage.clickOnContinueBtn();
    }
    @Then("verifies Logged in as username at top is displayed")
    public void verifies_logged_in_as_username_at_top_is_displayed() {
        homePage = new HomePage(driver);
        homePage.verifyLogInAsUser();
    }
    @Then("clicks on the cart link in the navbar")
    public void clicks_on_the_cart_link_in_the_navbar() {
        homePage.clickOnCartLink();
    }
    @Then("clicks on proceed to checkout btn")
    public void clicks_on_proceed_to_checkout_btn() {
        cartPage = new CartPage(driver);
        cartPage.clickOnProceedToCheckoutBtn();
    }
    @When("verifies address details and review your order")
    public void verifies_address_details_and_review_your_order() {
        checkout = new Checkout(driver);
        checkout.verifyShippingInfo();
        checkout.reviewYourOrder();
    }
    @Then("Enter description in comment text area and click Place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {
        checkout.makeACommentForTheOrder();
        checkout.clickOnPlaceOrderBtn();
    }
    @Then("Enter payment details: Name on Card,Card Number,CVC,Expiration date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {
        paymentPage = new PaymentPage(driver);
        paymentPage.enterCardInfo();
    }
    @When("clicks on pay and confirm order button")
    public void clicks_on_pay_and_confirm_order_button() {
        paymentPage.clickOnPayBtn();
    }
    @Then("verify success message Your order has been placed successfully")
    public void verify_success_message_your_order_has_been_placed_successfully() {
        paymentDonePage = new PaymentDonePage(driver);
        paymentDonePage.verifyUserIsOnPaymentDonePage();
    }
    @Then("clicks on Download Invoice button and verifies invoice is downloaded successfully")
    public void clicks_on_download_invoice_button_and_verifies_invoice_is_downloaded_successfully() {
        paymentDonePage.clickOnDownloadInvoiceBtn();
        paymentDonePage.verifyInvoiceDownloaded();
    }
}
