package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static org.testng.Assert.*;

public class UserList {
    @FindBy(id = "user_list_link")
    WebElement userListLink;
    @FindBy(id = "filterValue_placeholder")
    WebElement searchField;
    @FindBy(xpath = "//*[@id=\"users_list_mat_table\"]/mat-row[1]")
    WebElement checkList;

    @FindBy(id = "fana_select_checkbox")
    WebElement checkbox;
    @FindBy(id = "export_csv_button")
    WebElement exportCsvButton;
    @FindBy(id = "import_csv_button")
    WebElement importCsv;
    @FindBy(id = "file")
    WebElement chooseFileButton;
    @FindBy(id = "send_button")
    WebElement sendFileButton;


    private WebDriver driver;
    public UserList(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickIntoUserListLink")

    public void clickIntoUserListLink(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userListLink));
        userListLink.click();}
    @Step("typeIntoSearchfield")
    public void typeIntoSearchfield(String searchUser){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(searchUser);
    searchField.sendKeys(Keys.ENTER);}
    @Step("checkIfTheUserYouAreLookingForExists")
    public void checkIfTheUserYouAreLookingForExists(String user){
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(checkList));
            assertTrue(checkList.getText().contains(user));
            System.out.println(checkList.getText());
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(checkList));
            assertTrue(checkList.getText().contains(user));
            System.out.println(checkList.getText());
        }

        }
    @Step("clickOnUser")
    public void clickOnUser(){
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(checkList));
            Actions action = new Actions(driver);
            action.moveToElement(checkList).click().build().perform();
    }
    @Step("clickOnCheckboxUSR")
    public void clickOnCheckboxUSR(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkbox));

        checkbox.click();
    }
    @Step("clickOnButtonExportToCsv")
    public void clickOnButtonExportToCsv(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(exportCsvButton));
//        Actions action = new Actions(driver);
//        action.moveToElement(exportCsvButton).click().build().perform();
        exportCsvButton.click();
    }

    public void waitForFileDownloaded(String fileName, int timeoutSeconds, String downloadPath) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until((x) -> {
            File[] files = new File(downloadPath).listFiles();
            for (File file : files) {
                if (file.getName().contains(fileName)) {
                    return true;
                }
            }
            return false;
        });
    }
    public void verifyDownloadFile(String downloadPath){


        File folder = new File(downloadPath);

        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("fileName.csv")) {

                    assertEquals(fileName,"fileName.csv");

                    listOfFile.delete();
                }
            }
        }


    }
    @Step("clickOnButtonImportCsv")
    public void clickOnButtonImportCsv(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(importCsv));
        importCsv.click();
    }
    @Step("clickOnButtonChooseFile")
    public void clickOnButtonChooseFile(String lokalizacja){

        chooseFileButton.sendKeys(lokalizacja);
    }
    @Step("clickOnButtonSendFileToApp")
    public void clickOnButtonSendFileToApp(){

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendFileButton));
        sendFileButton.click();
    }

}
