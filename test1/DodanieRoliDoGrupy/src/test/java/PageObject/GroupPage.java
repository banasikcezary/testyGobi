package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.List;

import static org.testng.Assert.*;

public class GroupPage {

    @FindBy(id = "groups")
    WebElement groupsButton;
    @FindBy(xpath = "/html/body/app-root/app-main-view/div/app-user-priv/app-groups-management/div/div/div[1]/span")
    WebElement addGroupButton;
    @FindBy(id = "add_name")
    WebElement addNameField;
    @FindBy(id = "add_description")
    WebElement addDescriptionField;
    @FindBy(id = "group_add")
    WebElement saveNewGroupButton;
    @FindBy(xpath = "(//*[@class=\"mat-list-item-content\"])[last()]")
    WebElement chooseGroup;
    @FindBy(id = "choose_role")
    WebElement chooseRole;
    @FindBy(id = "Super Admin_option")
    WebElement selectRole;
    @FindBy(id = "add_role_button")
    WebElement addRoleButton;
    @FindBy(xpath = "(//button[text()=\"Usuń\"])[last()]")
    WebElement deleteRoleButton;
    @FindBy(id = "delete_group")
    WebElement deleteGroupButton;
    @FindBy(id = "edit_group")
    WebElement editGroupButton;
    @FindBy(xpath = "(//p[contains(@id,'role_')])[last()]")
    WebElement checkRoleInGroup;
    @FindBy(xpath = "(//button[contains(@id,'_list_element')])[last()]")
    WebElement checkAddNewGroup;



    private WebDriver driver;
    public GroupPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickOnGroupButton")
    public void clickOnGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(groupsButton));
        groupsButton.click();}
    @Step("clickOnAddGroupButton")

    public void clickOnAddGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addGroupButton));
        addGroupButton.click();}
    @Step("typeIntoAddNameField")

    public void typeIntoAddNameField(String addName){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addNameField));
        addNameField.clear();
        addNameField.sendKeys(addName);}
    @Step("typeIntoAddDescriptionField")

    public void typeIntoAddDescriptionField(String description){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addDescriptionField));
        addDescriptionField.clear();
        addDescriptionField.sendKeys(description);}
    @Step("clickOnSaveNewGroupButton")

    public void clickOnSaveNewGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveNewGroupButton));
        saveNewGroupButton.click();}
    @Step("clickOnChooseGroup")

    public void clickOnChooseGroup(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseGroup));
        chooseGroup.click();}
    @Step("selectChooseRole")

    public void selectChooseRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseRole));
        chooseRole.click();
       selectRole.click();}
    @Step("clickAddRoleButton")

    public void clickAddRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addRoleButton));
        addRoleButton.click();}
    @Step("clickDeleteRoleButton")

    public void clickDeleteRoleButton() {


            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteRoleButton));
            deleteRoleButton.click();
        }


    @Step("clickOnDeleteGroupButton")

    public void clickOnDeleteGroupButton(String groupName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkAddNewGroup));


        String result = checkAddNewGroup.getText();


        if (result.equals(groupName)) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteGroupButton));
            deleteGroupButton.click();

        }else{
            throw new IllegalArgumentException("Nie ma takiej grupy");

        }

    }
    @Step("clickOnEditGroupButton")

    public void clickOnEditGroupButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editGroupButton));
        editGroupButton.click();}


    @Step("validateAddRoleForGroup")
    public void validateAddRoleForGroup() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkRoleInGroup));


        String result = checkRoleInGroup.getText();

        assertEquals(result, "Super Admin");
    }

    @Step("validateDeleteRoleForGroup")
    public void validateDeleteRoleForGroup() {


        List<WebElement> allElement = driver.findElements(By.xpath("(//p[contains(@id,'role_')])[last()]"));

        assertTrue(allElement.isEmpty());


    }

    @Step("validateAddNewGroup")
    public void validateAddNewGroup(String groupName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkAddNewGroup));


        String result = checkAddNewGroup.getText();

        assertEquals(result, groupName);
    }


    @Step("validateDeleteGroup")
    public void validateDeleteGroup(String groupName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkAddNewGroup));

        String result = checkAddNewGroup.getText();


        assertNotEquals(result, groupName);
    }

}
