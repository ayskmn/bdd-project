package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CartPage;
import com.academy.techcenture.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DownloadInvoiceStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private CartPage cartPage;

    @Given("user is on the homepage, homepage is visible successfully")
    public void user_is_on_the_homepage_homepage_is_visible_successfully() {

    }
    @Given("user adds products to cart and clicks on the cart button")
    public void user_adds_products_to_cart_and_clicks_on_the_cart_button() {

    }
    @Then("verify that cart page is displayed successfully")
    public void verify_that_cart_page_is_displayed_successfully() {

    }
    @Then("clicks on proceed to checkout button in the cart page")
    public void clicks_on_proceed_to_checkout_button_in_the_cart_page() {

    }
    @Then("clicks on Register Login button and creates a new account")
    public void clicks_on_register_login_button_and_creates_a_new_account() {

    }
    @Then("verifies the account created successfully page and clicks the continue button")
    public void verifies_the_account_created_successfully_page_and_clicks_the_continue_button() {

    }
    @Then("verifies Logged in as username at top is displayed")
    public void verifies_logged_in_as_username_at_top_is_displayed() {

    }
    @Then("clicks on the cart link in the navbar")
    public void clicks_on_the_cart_link_in_the_navbar() {

    }
    @Then("clicks on proceed to checkout btn")
    public void clicks_on_proceed_to_checkout_btn() {

    }
    @When("verifies address details and review your order")
    public void verifies_address_details_and_review_your_order() {

    }
    @Then("Enter description in comment text area and click Place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {

    }
    @Then("Enter payment details: Name on Card,Card Number,CVC,Expiration date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {

    }
    @When("clicks on pay and confirm order button")
    public void clicks_on_pay_and_confirm_order_button() {

    }
    @Then("verify success message Your order has been placed successfully")
    public void verify_success_message_your_order_has_been_placed_successfully() {

    }
    @Then("clicks on Download Invoice button and verifies invoice is downloaded successfully")
    public void clicks_on_download_invoice_button_and_verifies_invoice_is_downloaded_successfully() {

    }
}
