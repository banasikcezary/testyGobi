package Tests;

  import PageObject.LoginPage;
import PageObject.RecordingPage;
import PageObject.Dialog;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class DodanieTaguDoNagrania extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();

        recordingPage.clickOnEditTagsButton();
        recordingPage.typeIntoEditTagsField("test");
        recordingPage.clickOnSaveEditTagsButton();

}}