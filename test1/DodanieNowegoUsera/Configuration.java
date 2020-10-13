package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.testng.Assert.assertEquals;

public class Configuration {

    @FindBy(id = "configuration_component_link")
    WebElement lnkConfiguration;
    @FindBy(xpath = "//*[contains(@id,'mat-expansion-panel-header-')][1]")
    WebElement lnkUserList;
    @FindBy(xpath = "//*[contains(@id,'_list_element')][last()]")
    WebElement lastUserButton;
    @FindBy(id = "enable_gui_application_access_checkbox")
    WebElement chkShowInGui;
    @FindBy(id = "save_button")
    WebElement btnSave;

    @FindBy(id = "login_input")
    WebElement loginInput;
    @FindBy(id = "firstName_input")
    WebElement firstNameInput;
    @FindBy(id = "lastName_input")
    WebElement lastNameInput;
    @FindBy(id = "number_input")
    WebElement numberInput;
    @FindBy(id = "email_input")
    WebElement emailInput;
    @FindBy(xpath = "(//mat-dialog-container[contains(@id,\"mat-dialog\")])")
    WebElement confirmText;


    private WebDriver driver;
    public Configuration(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("clickConfigurationLink")
    public void clickConfigurationLink(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkConfiguration));
        Actions actions=new Actions(driver);
        actions.moveToElement(lnkConfiguration).click().perform();
//        lnkConfiguration.click();
    }
    @Step("clickLinkUserList")
    public void clickLinkUserList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkUserList));
        lnkUserList.click();
    }
    @Step("typeIntoTxtLoginField")
    public void selectNewUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lastUserButton));
        lastUserButton.click();
    }

    @Step("clickInCheckboxShowInGui")
    public void clickInCheckboxShowInGui(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chkShowInGui));
        chkShowInGui.click();
    }

    @Step("clickInCheckboxShowInGui")
    public void clickSaveButton() throws AWTException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSave));


        btnSave.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(confirmText));
               confirmText.isDisplayed();

        driver.findElement(By.xpath("//html")).click();


//        assertEquals(confirmText.getText(), "Konfiguracja zostala zaaktualizowana");
    }

    @Step("typeIntoLoginField")
    public void typeIntoLoginField(String login){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        loginInput.sendKeys(login);
    }

    @Step("typeIntoFirstNameField")
    public void typeIntoFirstNameField(String firstName){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        firstNameInput.sendKeys(firstName);
    }

    @Step("typeIntoLastNameInputField")
    public void typeIntoLastNameInputField(String lastName){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        lastNameInput.sendKeys(lastName);
    }

    @Step("typeIntoLastNameInputField")
    public void typeIntoNumberInputField(String number){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        numberInput.sendKeys(number);
    }

    @Step("typeIntoEmailInputField")
    public void typeIntoEmailInputField(String email){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        emailInput.sendKeys(email);
    }


}
