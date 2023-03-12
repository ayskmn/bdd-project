package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement newUserSignup;
    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement logInToAccountText;
    @FindBy(xpath = "//button[text()='Signup']")
    private WebElement singUpBtn;
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameInput;
    @FindBy(xpath = "//input[@name='email' and @data-qa='signup-email']")
    private WebElement emailInput;
    @FindBy(xpath = "//h2[text()='New User Signup!']//following-sibling::form/button[@type='submit']")
    private WebElement submitBtnForSignUp;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement signInEmail;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement logInBtn;
    @FindBy(xpath = "//p[contains(text(),'incorrect!')]")
    private WebElement incorrectLogInText;
    @FindBy(xpath = "//a[text()=' Logout']")
    private WebElement logoutBtn;
    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElement emailAddressAlreadyExistErrorText;
    @FindBy(xpath="//button[text()='Create Account']")
    private WebElement createAccountBtn;

    public void verifyNewUserSignupIsVisible(){
        Assert.assertTrue("The message new user sing up is not displayed",newUserSignup.isDisplayed());

    }
    public void enterNameAndEmail(){
        nameInput.sendKeys(ConfigReader.getProperty("name"));
        emailInput.sendKeys(getRandomEmail());

    }
    public void verifyLogInToAccountIsVisible(){
        Assert.assertTrue("Log In to account is not visible",logInToAccountText.isDisplayed());
    }

    public void clickSignInBtn(){
        singUpBtn.click();
    }
    public void  clickOnSubmitSignUpBtn(){
        submitBtnForSignUp.click();
    }
    private String getRandomEmail(){
        String saurse = "qwertyuioplkjhgfdsazxcvbnm567412309";
        String email = "";
        for (int i = 0; i <5; i++) {
            int v = (int)(Math.random() * saurse.length());
            email+=saurse.charAt(v);
        }
        email+="@gmail.com";
        return email;
    }

    public void enterEmailAndPasswordOnLogInLine(){
        signInEmail.sendKeys(ConfigReader.getProperty("email1"));
        passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
    }
    public void clickLogInBtn(){
        logInBtn.click();
    }

    public  void logInWithIncorrectCredentials(){
        signInEmail.sendKeys(ConfigReader.getProperty("incorrectEmail"));
        passwordInput.sendKeys(ConfigReader.getProperty("incorrectPassword"));
    }
    public void verifyIncorrectLogInTextIsVisible(){
        Assert.assertTrue("Incorrect log in text is not visible", incorrectLogInText.isDisplayed());
    }
    public void logOutUser(){
        logoutBtn.click();
    }
    public void enterExistEmailInLogInField(){
        emailInput.sendKeys(ConfigReader.getProperty("email1"));
        nameInput.sendKeys(ConfigReader.getProperty("name"));
    }
    public void verifyErrorEmailAddressAlreadyExist(){
        Assert.assertTrue("Email Address already exist! is not display",emailAddressAlreadyExistErrorText.isDisplayed());
    }
    public void clickOnCreateAccountBtn(){
        Assert.assertTrue("Create account btn is not enabled", createAccountBtn.isEnabled());
        createAccountBtn.click();
    }
    public void clickOnSignupBtn(){
        Assert.assertTrue("Signup button is not enabled", singUpBtn.isEnabled());
        singUpBtn.click();
    }

}
