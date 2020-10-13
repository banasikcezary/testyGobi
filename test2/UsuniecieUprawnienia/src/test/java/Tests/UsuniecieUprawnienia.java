package Tests;

  import PageObject.Dialog;
  import PageObject.LoginPage;

  import PageObject.Privileges;
  import PageObject.UserAndPermissions;
  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class UsuniecieUprawnienia extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Privileges privileges = new Privileges(driver);
        privileges.clickOnPrivilegeButton();
        String privilege ="testNameField";

        privileges.clickOnDeletePrivilegeButton(privilege);

        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        privileges.clickOnPrivilegeButton();


        privileges.validateDeletePrivileges(privilege);

}}