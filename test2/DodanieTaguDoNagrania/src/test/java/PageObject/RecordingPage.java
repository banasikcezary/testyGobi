package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecordingPage {

    @FindBy(id = "recording_list_link")
    WebElement recordingTab;
    @FindBy(id = "headingOne")
    WebElement filterCriteria;
    @FindBy(id = "numberHeader")
    WebElement filterNumber;
    @FindBy(id = "mainNumber")
    WebElement filterNumberField;
    @FindBy(id = "filter_button")
    WebElement filter;
    @FindBy(xpath= "(//*[contains(@id,'_edit_tags')])[1]")
    WebElement editTags;
    @FindBy(id = "new_tag_input")
    WebElement tagsField;
    @FindBy(id = "save_button")
    WebElement saveEditTagsButton;
    @FindBy(id = "add_new_tag")
    WebElement addTag;



    private WebDriver driver;
    public RecordingPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickOnRecordingTab")

    public void clickOnRecordingTab(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recordingTab));
        recordingTab.click();
    }

//    public void clickOnButtonfilterCriteria(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filterCriteria));
//        filterCriteria.click();
//    }

//    public void clickOnButtonFilterNumber(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filterNumber));
//        filterNumber.click();
//    }
//    public void typeIntoFilterNumberField(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filterNumberField));
//        filterNumberField.sendKeys("48222903841");
//    }
//    public void clickOnFilterButton(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filter));
//        filter.click();
//    }

    @Step("clickOnEditTagsButton")

    public void clickOnEditTagsButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editTags));

        Actions action = new Actions(driver);
        action.moveToElement(editTags).click().perform();
    }



    @Step("typeIntoEditTagsField")

    public void typeIntoEditTagsField(String editTags){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(tagsField));


        tagsField.clear();
        tagsField.sendKeys(editTags);
        addTag.click();



    }
    @Step("clickOnSaveEditTagsButton")

    public void clickOnSaveEditTagsButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveEditTagsButton));
        saveEditTagsButton.click();
    }

}


