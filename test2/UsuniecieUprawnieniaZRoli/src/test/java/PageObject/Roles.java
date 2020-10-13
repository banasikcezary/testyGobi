package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.*;

public class Roles {

    @FindBy(xpath = "//*[@id=\"roles\"]")
    WebElement rolesButton;

    @FindBy(id = "add_privilege_button")
    WebElement addRoleButton;
    @FindBy(id = "add_role_name")
    WebElement addRoleNameField;
    @FindBy(id = "add_role_description")
    WebElement addRoleDescriptionField;
    @FindBy(id = "role_add")
    WebElement saveNewRole;

    @FindBy(xpath = "(//button[text()=\"Edytuj\"])[last()]")
    WebElement editRole;
    @FindBy(id = "edit_role_name")
    WebElement editRoleNameField;
    @FindBy(id = "edit_role_description")
    WebElement editRoleDesc;
    @FindBy(id = "role_edit")
    WebElement saveEditRole;


    @FindBy(xpath = "(//button[text()=\"Dodaj uprawnienie\"])[last()]")
    WebElement addPrivilageForNewRole;
    @FindBy(id = "choose_privilege")
    WebElement choosePrivilage;
    @FindBy(id="Definiowanie zakresów userów telefonicznych: numer, ID, num. kadrowy, tel_option")
    WebElement selectPrivilage;
    @FindBy(id = "privilege_add")
    WebElement savePrivilege;

    @FindBy(xpath = "(//div[contains(@id, \"open_folder_button_\")])[last()]")
    WebElement openRole;
    @FindBy(xpath = "(//button[contains(@id, \"delete_privilege_\")])[last()]")
    WebElement deletePrivilegeFromRole;

    @FindBy(xpath = "(//button[(text()=\"Usuń\")])[last()]")
    WebElement deleteRole;

    @FindBy(xpath = "(//p[contains(@id,'role_name')])[last()]")
    WebElement verifyAddNewRole;
    @FindBy(xpath = "(//div[contains(@id,'open_folder_button_')])[last()]")
    WebElement showPermissionRole;
    @FindBy(id = "privilege_12_0")
    WebElement checkPermissionRole;


    private WebDriver driver;
    public Roles(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickOnRolesButton")

    public void clickOnRolesButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rolesButton));
//        Actions actions=new Actions(driver);
//        actions.moveToElement(rolesButton).click().build().perform();
       rolesButton.click();
    }
    @Step("clickOnAddRoleButton")

    public void clickOnAddRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addRoleButton));
        addRoleButton.click();}
    @Step("typeIntoAddRoleNameField")

    public void typeIntoAddRoleNameField(String name){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addRoleNameField));
        addRoleNameField.sendKeys(name);}
    @Step("typeIntoAddRoleDescriptionField")

    public void typeIntoAddRoleDescriptionField(String description){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addRoleDescriptionField));
        addRoleDescriptionField.sendKeys(description);}
    @Step("clickOnSaveNewRole")

    public void clickOnSaveNewRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveNewRole));
        saveNewRole.click();}
    @Step("clickOnEditRole")

    public void clickOnEditRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editRole));
        editRole.click();}
    @Step("typeIntoEditRoleNameField")

    public void typeIntoEditRoleNameField(String editName){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(editRoleNameField));
        editRoleNameField.clear();
        editRoleNameField.sendKeys(editName);}
    @Step("typeIntoEditRoleDescription")
    public void typeIntoEditRoleDescription(String editDescription){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(editRoleDesc));
        editRoleDesc.clear();
        editRoleDesc.sendKeys(editDescription);}
    @Step("clickOnSaveEditRoleButton")
    public void clickOnSaveEditRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveEditRole));
        saveEditRole.click();}

    @Step("clickAddPrivilegeForNewRole")
    public void clickAddPrivilegeForNewRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addPrivilageForNewRole));
        addPrivilageForNewRole.click();}
    @Step("selectChoosePrivilege")
    public void selectChoosePrivilege(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(choosePrivilage));
        choosePrivilage.click();
        selectPrivilage.click();
    }
    @Step("clickOnSavePrivilege")
    public void clickOnSavePrivilege(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(savePrivilege));
        savePrivilege.click();}
    @Step("clickOpenRole")
    public void clickOpenRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(openRole));
        openRole.click();}
    @Step("clickOnDeletePrivilegeFromRoleButton")
    public void clickOnDeletePrivilegeFromRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deletePrivilegeFromRole));
        deletePrivilegeFromRole.click();}
    @Step("clickDeleteRoleButton")
    public void clickDeleteRoleButton(String deleteRoles) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));

        String roleName=verifyAddNewRole.getText();


        if (roleName.equals(deleteRoles)) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteRole));
            deleteRole.click();
        }else{
            throw new IllegalArgumentException("Nie ma takiej roli");

        }
    }

    @Step("validateAddRole")
    public void validateAddRole(String addRole) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));

        String roleName=verifyAddNewRole.getText();

        if(roleName !=addRole) {
            WebDriverWait webDriverWait1 = new WebDriverWait(driver, 30);
            webDriverWait1.until(ExpectedConditions.visibilityOf(verifyAddNewRole));

            String roleName1=verifyAddNewRole.getText();

            assertEquals(roleName1, addRole);
        }else{
            assertEquals(roleName, addRole);
        }
    }

    @Step("validateEditRole")
    public void validateEditRole(String editRole) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));

        String roleName=verifyAddNewRole.getText();


        assertEquals(roleName, editRole);
    }

    @Step("validateDeleteRole")
    public void validateDeleteRole(String editRole) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));


        String result = verifyAddNewRole.getText();

        assertNotEquals(result, editRole);
    }

    @Step("validateAddPermissionForRole")
    public void validateAddPermissionForRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));
        showPermissionRole.click();



        List<WebElement> allElement = driver.findElements(By.xpath("(//p[contains(@id,'privilege_')])[last()]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertEquals(result, "Definiowanie zakresów userów telefonicznych: numer, ID, num. kadrowy, tel");
    }

    @Step("validateDeletePermissionForRole")
    public void validateDeletePermissionForRole() {




        List<WebElement> allElement = driver.findElements(By.xpath("(//button[contains(@id, \"delete_privilege_\")])[last()]"));
        assertTrue(allElement.isEmpty());

    }

}
