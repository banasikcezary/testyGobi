package Tests;

  import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import PageObject.Dialog;
import PageObject.Roles;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class DodanieUprawnieniaDoRoli extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
 UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Roles role = new Roles(driver);
        role.clickOnRolesButton();
        role.clickAddPrivilegeForNewRole();
        role.selectChoosePrivilege();
        role.clickOnSavePrivilege();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        user.clickOnUserAndPermissionButton();
        role.clickOnRolesButton();


        role.validateAddRole("testRoleName");
        role.validateAddPermissionForRole();

}}