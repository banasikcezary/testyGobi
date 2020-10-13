package Tests;

  import PageObject.LoginPage;
import PageObject.UserList;
import PageObject.ConnectionsSettingsPage;
import PageObject.Dialog;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class EdycjaUstawienNagrywania extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
 UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        String nazwaUzytkownika="fana";
        userList.typeIntoSearchfield(nazwaUzytkownika);
        userList.checkIfTheUserYouAreLookingForExists(nazwaUzytkownika);
        userList.clickOnUser();

        ConnectionsSettingsPage connectionsSettingsPage = new ConnectionsSettingsPage(driver);
        connectionsSettingsPage.clickIntoEditButton();
        connectionsSettingsPage.clickIntoToAgreeRecordingVPABXConnections();
        connectionsSettingsPage.clickIntoToAgreeRecordingConnections();
        connectionsSettingsPage.clickIntoToAgreeDisableOutgoingCalls();
        connectionsSettingsPage.clickIntoToAgreeRecordingOutgoingCalls();

        connectionsSettingsPage.clickIntoSaveSettingsButton();
        connectionsSettingsPage.verifySaveSettings();

}}