package methods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

import java.time.Duration;


public class BaseMethods extends BasePage
{
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BaseMethods(WebDriver webDriver) {
        this.driver=webDriver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //"Console'a mesaj yazdırılmasını sağlar."
    protected void logMessage(String text) {
        System.out.println(text);
    }

    //("İlgili elemente tıklanmasını,eğer tıklanamazsa uyarı çıkması sağlanır.")
    protected void clickElement(WebElement element) {
        try {
            element.click();
            waitSeconds(1);
            logMessage(element.getText() + " elementine tıklandı.");
        } catch (Exception e) {
            logMessage("Elemente tıklanamadı. Element: " + element + " Hata: " + e.getMessage());
        }

    }

    protected void waitForPageLoad(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //"İlgili elemente string ifade girilmesini sağlar."
    protected void writeText(WebElement element, String text) {
        try {
            if (element.getText().equals("")) {
                element.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            }
            element.sendKeys(text);

        } catch (Exception e) {
            logMessage("İlgili elemente yazı yazılırken hata oluştu. Element:"+ element +"Hata: " + e.getMessage());
        }
    }

    //("Sayfada belirtilen saniye kadar beklmesini sağlar.")
    protected void waitSeconds(int seconds) {
        try {
            logMessage(seconds + " saniye kadar bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logMessage(e.getMessage());
        }
    }



    //("Beklenen ve Aslında olan text ifadelerini karşılaştırır, ona göre değer döner.")
    protected boolean controlTextWithEquality(String expectingText,WebElement actualText){
        boolean isTextEqual=false;
        if(actualText.getText().equals(expectingText)){
            isTextEqual=true;
        }
        return isTextEqual;
    }



    //("Beklenen sayfanın Url bilgisi verilmişse, sayfanın doğruluğunu kontrol eder.")
    protected void controlCurrentPageURL(String expectedUrl){
        try {
            if(!expectedUrl.isEmpty()){
                if(expectedUrl.equals(driver.getCurrentUrl())){
                    Assert.fail("Verilen URL'ler eş değil. Aslında : "+driver.getCurrentUrl()+"/ Beklenen: "+expectedUrl);
                }
            }
        }catch (Exception e){
            logMessage("Sayfa kontrolü yapılırken hata alındı. Hata : "+e.getMessage());
        }

    }
}
