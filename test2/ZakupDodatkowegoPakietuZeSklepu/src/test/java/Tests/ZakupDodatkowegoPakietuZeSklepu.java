package Tests;

  import PageObject.LoginPage;
import PageObject.Dialog;
import PageObject.ShopPage;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class ZakupDodatkowegoPakietuZeSklepu extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
 ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.clickOnAdditionalFundsAvailableTab();
        shopPage.selectValuePackageWithList();
        shopPage.clickOnBuyPackageButton();

        shopPage.checkSavingAdditionalPackageConfirmationText();


}}