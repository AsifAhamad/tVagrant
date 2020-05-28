package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class GoodreadsPage extends Base {

    WebDriver driver;
    //private static final String PAGE_URL = "http://goodreads.com";

    @FindBy(id="userSignInFormEmail")
    WebElement signInEmail;

    @FindBy(id="user_password")
    WebElement signInPassword;

    @FindBy(xpath = "//input[@value='Sign in']")
    WebElement signInButton;

    public GoodreadsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Login to Account method
    public void loginToAccount (String mail, String password) {
        signInEmail.sendKeys(mail);
        signInPassword.sendKeys(password);
        signInButton.click();
    }

}
