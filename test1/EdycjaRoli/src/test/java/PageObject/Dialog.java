package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dialog {

    @FindBy(id = "close_dialog")
    WebElement acceptPopupButton;

    private WebDriver driver;

    public Dialog(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("clickOnAcceptPopupButton")

    public void clickOnAcceptPopupButton(){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(acceptPopupButton));
        acceptPopupButton.click();
    }
}
