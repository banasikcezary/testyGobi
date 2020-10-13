package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class LoginPage {

    @FindBy(id = "telNumber")
    WebElement telNumber;
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement logIn;
    @FindBy(id = "logout_button")
    WebElement logoutButton;
    @FindBy(xpath = "/html/body/app-root/cookie-law/cookie-law-component/div/div/a")
    WebElement cooki;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("typeIntoPhoneNumberField")

    public void typeIntoPhoneNumberField(String phoneNumber) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(telNumber));
        telNumber.sendKeys(phoneNumber);
        System.out.println("phone");

    }
    @Step("typeIntoUsernameField")

    public void typeIntoUsernameField(String user) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(user);

        System.out.println("user");

    }
    @Step("typeIntoPasswordField")

    public void typeIntoPasswordField(String pass) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pass);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(cooki));
        cooki.click();
    }
    @Step("typeIntoPasswordFieldFailed")

    public void typeIntoPasswordFieldFailed(String passFail) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(passFail);

        System.out.println("pass");

    }
    @Step("clickIntoLogInButton")

    public void clickIntoLogInButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logIn));
        Actions actions = new Actions(driver);
        actions.moveToElement(logIn).click().build().perform();
          // logIn.click();

        System.out.println("click login");




    }
    @Step("checkPositiveLoginToApp")

    public void checkPositiveLoginToApp() {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(logoutButton));
            assertEquals(logoutButton.getText(), "Wyloguj");
        }
    @Step("checkNegativeLoginToApp")

        public void checkNegativeLoginToApp() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());

        try {
            Alert alert = driver.switchTo().alert();
           String text= alert.getText();
            alert.accept();

            assertEquals(text, "Nie udało się zalogować");

        } catch(UnhandledAlertException noe) {
            // No alert found on page, proceed with test.
        }

        }
    }


