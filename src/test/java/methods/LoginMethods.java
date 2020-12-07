package methods;


import contants.ContantsLoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginMethods extends BaseMethods {
    ContantsLoginPage loginPage = PageFactory.initElements(driver, ContantsLoginPage.class);

    public LoginMethods(WebDriver driver) {
        super(driver);
    }

    //"Girilen bilgilerle birlikte kullanıcı login olur.")
    public LoginMethods login(String email, String password) {
        waitForPageLoad(loginPage.mainPageText);
        clickElement(loginPage.mainLoginButton);
        waitSeconds(3);
        writeText(loginPage.loginpageEmail, email);
        waitSeconds(2);
        writeText(loginPage.loginpagePassword, password);
        waitSeconds(2);
        clickElement(loginPage.loginpageButtonLogin);
        waitSeconds(5);
        return new LoginMethods(driver);
    }

    //("Kullanıcının hangi sayfada olduğu kontrol edilir.")
    public LoginMethods checkUserPage(String expectingUrl) {
     //   waitForPageLoad(loginPage.copyrightText);
        Assert.assertEquals("İstenen sayfada olmadığı görüldü.",expectingUrl,driver.getCurrentUrl());
        return new LoginMethods(driver);
    }


}
