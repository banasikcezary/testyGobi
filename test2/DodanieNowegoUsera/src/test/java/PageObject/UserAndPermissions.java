package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import static org.testng.Assert.*;

public class UserAndPermissions {

    @FindBy(id = "privileges_component_link")
    WebElement userAndPermission;
    @FindBy(id = "users")
    WebElement users;
    @FindBy(id = "add_user_button")
    WebElement addUserButton;
    @FindBy(id = "add_login")
    WebElement loginField;
    @FindBy(id = "add_first_name")
    WebElement firstNameField;
    @FindBy(id = "add_last_name")
    WebElement lastNameField;
    @FindBy(id = "add_email")
    WebElement emailField;
    @FindBy(id = "add_phone")
    WebElement phoneField;
    @FindBy(id = "user_add")
    WebElement saveUserButton;
    @FindBy(id = "filter_value_input")
    WebElement searchUserField;
    @FindBy(id = "search_button")
    WebElement searchButton;
    @FindBy(xpath = "(//button[text()=\"Pokaż role \"])[last()]")
    WebElement showRoleButton;
    @FindBy(id = "add_assignment_button")
    WebElement addAssignmentButton;
    @FindBy(id = "choose_role")
    WebElement selectRole;
    @FindBy(id = "privilege_add")
    WebElement addRoleButton;
    @FindBy(xpath = "(//button[text()=\"Usuń \"])[last()]")
    WebElement deleteUser;
    @FindBy(xpath = "(//p[contains(@id,\"username\")])[last()]")
    WebElement assertRoleName;
    @FindBy(id = "page_message")
    WebElement pageMessage;

    @FindBy(id = "Super Admin_option")
    WebElement role;

    @FindBy(xpath = "(//*[contains(@id, \"role_\")])[last()]")
    WebElement assertUserRole;

    @FindBy(id = "next_page_button")
    WebElement btnNextPage;


    @FindBy (xpath = "(//button[text()=\" Certyfikat \"])[last()]")
    WebElement btnCertificate;
    @FindBy(xpath = "(//input[@type=\"file\"])[last()]")
    WebElement addCertificate;
    @FindBy(xpath = "(//button[text()=\"Pobierz\"])[last()]")
    WebElement downloadCert;
    @FindBy(xpath = "(//button[text()=\"Usuń\"])[last()]")
    WebElement deleteCert;

    @FindBy(id = "clear_button")
    WebElement clearbutton;



    private WebDriver driver;

    public UserAndPermissions(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickOnUserAndPermissionButton")

    public void clickOnUserAndPermissionButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userAndPermission));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(userAndPermission).click().build().perform();
      //  userAndPermission.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", userAndPermission);

    }

    @Step("clickOnUserButton")
    public void clickOnUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(users));
        Actions actions = new Actions(driver);
        actions.moveToElement(users).click().build().perform();
    }

    @Step("clickOnAddUserButton")
    public void clickOnAddUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addUserButton));

        addUserButton.click();
    }
    @Step("clickOnClearButton")
    public void clickOnClearButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(clearbutton));

        clearbutton.click();
    }

    @Step("typeIntoLoginField")
    public void typeIntoLoginField(String login) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(loginField));
        webDriverWait.ignoring(TimeoutException.class);

        loginField.sendKeys(login);
    }

    @Step("typeIntoFirstNameField")
    public void typeIntoFirstNameField(String firstName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(firstName);
    }

    @Step("typeIntoLastName")
    public void typeIntoLastName(String lastName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(lastNameField));
        lastNameField.sendKeys(lastName);
    }

    @Step("typeIntoEmailField")
    public void typeIntoEmailField(String email) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }

    @Step("typeIntoPhoneField")
    public void typeIntoPhoneField(String phone) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(phoneField));
        phoneField.sendKeys(phone);
    }

    @Step("clickOnSaveNewUserButton")
    public void clickOnSaveNewUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveUserButton));
        saveUserButton.click();
        driver.findElement(By.xpath("//html")).click();

    }

    @Step("assertUser")
    public void assertUser(String user) {


        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(assertRoleName));



        String name = assertRoleName.getText();


            assertEquals(name, user);


    }

    @Step("assertDeleteUser")
    public void assertDeleteUser(String user) {
        Dialog dialog=new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(pageMessage));

        String name = pageMessage.getText();
        assertEquals(name, "Nie ma użytkowników");
    }

    @Step("typeIntoSearchUserField")
    public void typeIntoSearchUserField(String searchUser) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchUserField));
        searchUserField.sendKeys(searchUser);
    }

    @Step("clickOnSearchButton")
    public void clickOnSearchButton(){
          WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
          webDriverWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();


    }

    @Step("clickOnShowRoleButton")
    public void clickOnShowRoleButton() {



        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoleButton));
            showRoleButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoleButton));
            showRoleButton.click();
        }
    }

    @Step("clickOnAddAssignmentButton")
    public void clickOnAddAssignmentButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addAssignmentButton));
        addAssignmentButton.click();

    }

    @Step("selectRole")
    public void selectRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectRole));

        selectRole.click();
        role.click();

    }

    @Step("clickAddRoleButton")
    public void clickAddRoleButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addRoleButton));
        addRoleButton.click();
    }

    @Step("assertionAddRoleForUser")
    public void assertionAddRoleForUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(assertUserRole));
        String userRola = assertUserRole.getText();
        assertEquals(userRola,"Super Admin");
    }




    @Step("clickOnDeleteUser")
    public void clickOnDeleteUser(String user) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(assertRoleName));

        String name = assertRoleName.getText();

        if(name.equals(user)) {

            try {

                webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteUser));
                deleteUser.click();
            } catch (org.openqa.selenium.StaleElementReferenceException ex) {

                webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteUser));
                deleteUser.click();
            }


        }else{
            throw new IllegalArgumentException("Nie ma takiego usera");

        }
    }
    @Step("clickIntoCertificateButton")
    public void clickIntoCertificateButton(){



        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnCertificate));
            btnCertificate.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnCertificate));
            btnCertificate.click();
        }

    }


    @Step("clickIntoAddCertificateButton")
    public void clickIntoAddCertificateButton() {

        addCertificate.sendKeys("src/test/java/resources/123.crt");

    }

    @Step("assertAddCertificate")
    public void assertAddCertificate(){
        Dialog dialog=new Dialog(driver);
        dialog.clickOnAcceptPopupButton();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnCertificate));
            btnCertificate.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(btnCertificate));
            btnCertificate.click();
        }
        webDriverWait.until(ExpectedConditions.elementToBeClickable(downloadCert));

        downloadCert.isDisplayed();
    }

    @Step("clickIntoDownloadCertificateButton")
    public void clickIntoDownloadCertificateButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(downloadCert));
        downloadCert.click();
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
    public void verifyDownloadFile(String name, String downloadPath){


        File folder = new File(downloadPath);

        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches(name)) {

                    assertEquals(fileName,name);

                    listOfFile.delete();
                }
            }
        }


    }

    @Step("clickIntoDeleteCertificateButton")
    public void clickIntoDeleteCertificateButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteCert));
        deleteCert.click();
    }
}