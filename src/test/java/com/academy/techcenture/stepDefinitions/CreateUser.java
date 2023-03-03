package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.AccountCreatedSuccessfullyPage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.UserInfopage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.academy.techcenture.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class CreateUser {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private LoginPage logInPage;
    private UserInfopage userInfopage;
    private Select select;
    private AccountCreatedSuccessfullyPage accountSuccessfullyCreatedPage;

    @When("user on home page, home page is visible")
    public void user_on_home_page_home_page_is_visible() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
    }
    @When("user clicks on sing up button log in button")
    public void user_clicks_on_sing_up_button_log_in_button() {

        homePage.clickOnSingInSignUpBtn();
    }
    @Then("user is been navigated to login page")
    public void user_is_been_navigated_to_login_page() {
        logInPage= new LoginPage(driver);
        logInPage.verifyNewUserSignupIsVisible();
    }
    @Then("user enters name and email")
    public void user_enters_name_and_email() {
        logInPage=new LoginPage(driver);
        logInPage.enterNameAndEmail();
    }
    @Then("user clicks sing up")
    public void user_clicks_sing_up() {
        logInPage=new LoginPage(driver);
        logInPage.clickOnSubmitSignUpBtn();
    }
    @Then("user navigates to create an account page")
    public void user_navigates_to_create_an_account_page() {
        userInfopage = new UserInfopage(driver);
        userInfopage.verifyEnterAccountInfoTextIsVisible();
    }
    @Then("user enters <Title>, <Name>, <Email>, <Password>, <Date of birth>")
    public void user_enters_title_name_email_password_date_of_birth(List<Map<String,String>> data) {
        Map<String, String> userInfo =data.get(0);
        String password = userInfo.get("Password").trim();
        String title = userInfo.get("Title");
        String date = userInfo.get("Date").trim();
        String month = userInfo.get("Month").trim();
        String year = userInfo.get("Year");
        driver.findElement(By.xpath("//label[text()='Title']/following-sibling::div/label/div/span/input[@value='"+title+"']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.id("password")).sendKeys(password);
        WebElement days = driver.findElement(By.id("days"));
        select = new Select(days);
        select.selectByVisibleText(date);
        WebElement months = driver.findElement(By.id("months"));
        select = new Select(months);
        select.selectByVisibleText(month);
        WebElement years = driver.findElement(By.id("years"));
        select = new Select(years);
        select.selectByValue(year);
    }
    @Then("user  Select checkbox {string}")
    public void user_select_checkbox(String string) {
        String str = "Sign up for our newsletter!";
        userInfopage = new UserInfopage(driver);
        userInfopage.clickOnNewsLettersBtnSingUp(str);
    }
    @Then("user Select checkbox 'Receive special offers from our partners!")
    public void user_select_checkbox_receive_special_offers_from_our_partners() {
        userInfopage=new UserInfopage(driver);
        userInfopage.clickOnReceiveSpecialOffersFromOurPartners();
    }
    @Then("user Fill details: <First name>, <Last name>, <Company>, <Address>, <Address2>, <Country>, <State>, <City>, <Zipcode>, <Mobile>")
    public void user_fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile(List<Map<String,String>> data) {
        Map<String, String> userInfo =data.get(0);
        String first_name = userInfo.get("First name");
        String last_name = userInfo.get("Last name");
        String company = userInfo.get("Company");
        String address = userInfo.get("Address");
        String country = userInfo.get("Country");
        String state = userInfo.get("State");
        String city = userInfo.get("City");
        String zipcode = userInfo.get("Zipcode");
        String mobile = userInfo.get("Mobile");
        driver.findElement(By.id("first_name")).sendKeys(first_name);
        driver.findElement(By.id("last_name")).sendKeys(last_name);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("address1")).sendKeys(address);
        WebElement country1 = driver.findElement(By.id("country"));
        select = new Select(country1);
        select.selectByValue(country);
        driver.findElement(By.id("state")).sendKeys(state);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("zipcode")).sendKeys(zipcode);
        driver.findElement(By.id("mobile_number")).sendKeys(mobile);
    }
    @Then("user Clicks {string}")
    public void user_clicks(String string) {
        userInfopage = new UserInfopage(driver);
        userInfopage.clickOnCreateAccountBtn();
    }
    @Then("user navigated to account created successfully page")
    public void user_navigated_to_account_created_successfully_page() {
        accountSuccessfullyCreatedPage=new AccountCreatedSuccessfullyPage(driver);
        accountSuccessfullyCreatedPage.verifyNavigatedToAccountCreatedSuccessfullyPage();
    }
    @Then("user clicks continue button")
    public void user_clicks_continue_button() {
        accountSuccessfullyCreatedPage= new AccountCreatedSuccessfullyPage(driver);
        accountSuccessfullyCreatedPage.clickOnContinueBtn();
    }
    @Then("user navigated to the home page")
    public void user_navigated_to_the_home_page() {

    }
}
