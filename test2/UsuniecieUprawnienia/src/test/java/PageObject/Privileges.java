package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Privileges {


    @FindBy(xpath = "//*[@id=\"privileges\"]")
    WebElement privilegesButton;
    @FindBy(id = "add_privilege_button")
    WebElement addNewPrivillegeButton;
    @FindBy(id = "add_name")
    WebElement addNameField;
    @FindBy(id = "privilege_add")
    WebElement saveNewPrivilege;
    @FindBy(xpath = "(//button[text()=\"Usuń\"])[last()]")
    WebElement deletePrivilege;

    @FindBy(xpath = "//p[contains(@id,'name')]")
    WebElement verifyAddPrivilege;



    private WebDriver driver;

    public Privileges(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickOnPrivilegeButton")

    public void clickOnPrivilegeButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(privilegesButton));
        webDriverWait.ignoring(TimeoutException.class);

        privilegesButton.click();
    }
    @Step("clickOnAddPrivilegeButton")

    public void clickOnAddPrivilegeButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addNewPrivillegeButton));
        addNewPrivillegeButton.click();
    }
    @Step("typeIntoAddNameField")

    public void typeIntoAddNameField(String name) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addNameField));
        addNameField.sendKeys(name);
    }
    @Step("clickOnSaveNewPrivilege")

    public void clickOnSaveNewPrivilege() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveNewPrivilege));
        saveNewPrivilege.click();
    }

    public void clickOnDeletePrivilegeButton(String privilege) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddPrivilege));

        List<WebElement> allElement = driver.findElements(By.xpath("//p[contains(@id,'name')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();


        if(result.equals(privilege)) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(deletePrivilege));
            deletePrivilege.click();

        }else{
            throw new IllegalArgumentException("Nie ma takiego uprawnienia");

        }
    }

    @Step("validateThePrivilegesCreation")
    public void validateThePrivilegesCreation(String privilege) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddPrivilege));

        List<WebElement> allElement = driver.findElements(By.xpath("//p[contains(@id,'name')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertEquals(result, privilege);
    }

    @Step("validateDeletePrivileges")
    public void validateDeletePrivileges(String privilege) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddPrivilege));

        List<WebElement> allElement = driver.findElements(By.xpath("//p[contains(@id,'name')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertNotEquals(result, privilege);
    }
}