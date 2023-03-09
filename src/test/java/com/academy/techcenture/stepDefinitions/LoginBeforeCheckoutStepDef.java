package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class LoginBeforeCheckoutStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private LoginPage loginPage;
    private CartPage cartPage;
    private Checkout checkout;

    private PaymentPage paymentPage;

    @Given("user navigates to the homepage and the homepage is visible")
    public void user_navigates_to_the_homepage_and_the_homepage_is_visible() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Given("user clicks on signup login button")
    public void user_clicks_on_signup_login_button() {
        homePage.clickOnSingInSignUpBtn();
    }
    @Then("enters email, password and clicks on Login btn")
    public void enters_email_password_and_clicks_on_login_btn() {
        loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPasswordOnLogInLine();
        loginPage.clickLogInBtn();
    }
    @Then("verifies Logged in as username at top of the page")
    public void verifies_logged_in_as_username_at_top_of_the_page() {
        homePage = new HomePage(driver);
        homePage.verifyLogInAsUser();
    }
    @Then("adds products to the cart")
    public void adds_products_to_the_cart() throws InterruptedException {
        homePage.addRandomProductToCart();
        homePage.continueShopping();
        homePage.addRandomProductToCart();
        homePage.continueShopping();
    }
    @Then("clicks on Cart button in the navbar")
    public void clicks_on_cart_button_in_the_navbar() {
        homePage.scrollUpToTopOfThePage();
        homePage.clickOnCartLink();
    }
    @When("verifies that cart page is displayed")
    public void verifies_that_cart_page_is_displayed() {
        cartPage = new CartPage(driver);
        cartPage.verifyUserIsOnCartPage();
    }
    @When("clicks on proceed to checkout")
    public void clicks_on_proceed_to_checkout() {
        cartPage.clickOnProceedToCheckoutBtn();
    }
    @Then("verifies address details and reviews the order")
    public void verifies_address_details_and_reviews_the_order(List<Map<String, String>> data) {
        checkout = new Checkout(driver);
        Map<String, String> shippingInfo = data.get(0);
        String name=shippingInfo.get("Name");
        ConfigReader.setProperty("shippingName", name);
        String address = shippingInfo.get("Address");
        ConfigReader.setProperty("shippingAddress", address);
        String stateZipcode = shippingInfo.get("StateZipcode");
        ConfigReader.setProperty("shippingStateZip", stateZipcode);
        String country = shippingInfo.get("Country");
        ConfigReader.setProperty("shippingCountry", country);
        String phoneNum = shippingInfo.get("Mobile");
        ConfigReader.setProperty("shippingPhone", phoneNum);
        checkout.verifyShippingInfoForLogin();
    }
    @Then("enters description in the comment text area and places the order")
    public void enters_description_in_the_comment_text_area_and_places_the_order() throws InterruptedException {
        checkout.makeACommentForTheOrder();
        checkout.clickOnPlaceOrderBtn();
        checkout.closeAd();
    }
    @When("enters payment details; name on card, card number, cvc, exp date")
    public void enters_payment_details_name_on_card_card_number_cvc_exp_date() {
        paymentPage = new PaymentPage(driver);
        paymentPage.enterCardInfo();

    }
    @Then("clicks on pay and confirm order")
    public void clicks_on_pay_and_confirm_order() {
        paymentPage.clickOnPayBtn();
    }
    @Then("verifies the success message Your order has been placed successfully!")
    public void verifies_the_success_message_your_order_has_been_placed_successfully() {
        paymentPage.verifyPaymentSuccessPage();
    }


}
