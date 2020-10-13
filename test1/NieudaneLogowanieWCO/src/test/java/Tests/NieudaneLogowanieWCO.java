package Tests;

  import PageObject.LoginPage;
import PageObject.Dialog;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class NieudaneLogowanieWCO extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("jan.nowak");
        loginPage.typeIntoPasswordFieldFailed("aaaa");
        loginPage.clickIntoLogInButton();

        loginPage.checkNegativeLoginToApp();

}}