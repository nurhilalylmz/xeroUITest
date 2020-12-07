package methods;

import contants.ContantsCreateBussinessPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BussinessMethods extends BaseMethods
{
    ContantsCreateBussinessPage bussinessPage = PageFactory.initElements(driver, ContantsCreateBussinessPage.class);

    public BussinessMethods(WebDriver webDriver) {
        super(webDriver);
    }
    //"Girilen bilgilerle birlikte kullanıcı login olur.")
    public BussinessMethods createBussiness(String bussinessName, String industry) {
        waitSeconds(4);
        writeText(bussinessPage.textBussinessName, bussinessName);
        waitSeconds(2);
        writeText(bussinessPage.textIndustry, industry);
        waitSeconds(2);
        clickElement(bussinessPage.radioButtonNoJustMe);
        waitSeconds(2);
        clickElement(bussinessPage.buttonBuyNow);
        waitSeconds(5);
        return new BussinessMethods(driver);
    }

    //("Kullanıcının hangi sayfada olduğu kontrol edilir.")
    public LoginMethods checkUserPage(String expectingUrl) {
        //   waitForPageLoad(loginPage.copyrightText);
        Assert.assertEquals("İstenen sayfada olmadığı görüldü.",expectingUrl,driver.getCurrentUrl());
        return new LoginMethods(driver);
    }

}
