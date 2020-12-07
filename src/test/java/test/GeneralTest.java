package test;

import methods.BussinessMethods;
import methods.LoginMethods;
import org.testng.annotations.Test;
import pages.BasePage;

public class GeneralTest extends BasePage {
    LoginMethods loginPage ;
    BussinessMethods bussinessPage;

    @Test(description = "Başarılı login işlemi gerçekleşmesi beklenir.")
    public void successLogin() {
        loginPage= new LoginMethods(driver);
        loginPage
                .login("nurhilalylmz@gmail.com", "123456hy")
                .checkUserPage("https://go.xero.com/app/onboarding-ui");
    }
    @Test(description = "Başarılı kayıt işlemi gerçekleşmesi beklenir.")
    public void successCreateBussinessPage() {
        bussinessPage= new BussinessMethods(driver);
        bussinessPage
                .createBussiness("Yılmaz", "")
                .checkUserPage("https://go.xero.com/app/onboarding-ui");
    }

}
