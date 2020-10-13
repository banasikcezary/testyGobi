package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class ShopPage {

    @FindBy(id = "shop_component_link")
    WebElement shopTab;
    @FindBy(id = "UMN_input")
    WebElement presentationByMajorNumberField;
    @FindBy(id = "save_changes")
    WebElement saveChangeButton;
    @FindBy(id = "buy_package")
    WebElement buyPackage;
    @FindBy(xpath = "//*[@id=\"navbarNav\"]/ul/li[3]/a")
    WebElement additionalFundsAvailableTab;
    @FindBy(id = "choose_package")
    WebElement valuePackage;
    @FindBy(xpath = "//p[contains(text(),'Funkcjonalności zostały zapisane')]")
    WebElement checkTextDialog;
    @FindBy(xpath = "//p[contains(text(),'Kupiono pakiet')]")
    WebElement checkTextDialogAdditionalPackage;

    @FindBy(id = "USR_input")
    WebElement userField;

    @FindBy(id = "save_modal_button")
    WebElement saveModalButton;
    @FindBy(id = "7 zł_option")
    WebElement chooseOption;


    private WebDriver driver;

    public ShopPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("clickOnShopTab")

    public void upValueUser() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(userField));

        Integer a = Integer.parseInt(userField.getAttribute("value"));
        Integer newValue = a + 1;
        userField.clear();
        userField.sendKeys(newValue.toString());
    }

    @Step("clickOnShopTab")

    public void clickOnShopTab() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(shopTab));
        webDriverWait.ignoring(TimeoutException.class);

        shopTab.click();
    }

    //    @Step("buyNewFaxFunctionalitiesWithExceedingTheAmount")
//    public void buyNewFaxFunctionalitiesWithExceedingTheAmount (){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
//        webDriverWait.until(ExpectedConditions.visibilityOf(presentationByMajorNumberField));
//        webDriverWait.ignoring(TimeoutException.class);
//
//        presentationByMajorNumberField.clear();
//        presentationByMajorNumberField.sendKeys("20000");
//    }
    @Step("buyNewFaxFunctionalities")
    public void buyNewPresentationByMajorNumberFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(presentationByMajorNumberField));

        Integer a = Integer.parseInt(presentationByMajorNumberField.getAttribute("value"));
        Integer newValue = a + 1;

        presentationByMajorNumberField.clear();
        presentationByMajorNumberField.sendKeys(newValue.toString());
    }

    @Step("sellFaxFunctionalities")
    public void sellPresentationByMajorNumberFunctionalities() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(presentationByMajorNumberField));


        Integer a = Integer.parseInt(presentationByMajorNumberField.getAttribute("value"));
        Integer newValue = a - 1;

        presentationByMajorNumberField.clear();
        presentationByMajorNumberField.sendKeys(newValue.toString());
    }

    @Step("clickOnSaveChangeButton")
    public void clickOnSaveChangeButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveChangeButton));
        saveChangeButton.click();
    }

    @Step("clickOnBuyPackageButton")
    public void clickOnBuyPackageButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buyPackage));
        buyPackage.click();
    }

    @Step("clickOnAdditionalFundsAvailableTab")
    public void clickOnAdditionalFundsAvailableTab() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(additionalFundsAvailableTab));
        additionalFundsAvailableTab.click();
    }

    @Step("selectValuePackageWithList")
    public void selectValuePackageWithList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(valuePackage));
       valuePackage.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(chooseOption));

        chooseOption.click();
    }

    public void checkSavingConfirmationText() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkTextDialog));
       assertEquals(checkTextDialog.getText(), "Funkcjonalności zostały zapisane");

        webDriverWait.until(ExpectedConditions.visibilityOf(saveModalButton));
        saveModalButton.click();
    }

    public void checkSavingAdditionalPackageConfirmationText() {

        assertEquals(checkTextDialogAdditionalPackage.getText(), "Kupiono pakiet");
    }

}
