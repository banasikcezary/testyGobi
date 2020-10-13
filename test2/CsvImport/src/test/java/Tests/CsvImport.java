package Tests;

  import PageObject.LoginPage;
import PageObject.UserList;
import PageObject.Dialog;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class CsvImport extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();


 UserList userList = new UserList(driver);
        userList.clickOnButtonImportCsv();
        userList.clickOnButtonChooseFile("src/test/java/resources/1.csv");
        userList.clickOnButtonSendFileToApp();


}}