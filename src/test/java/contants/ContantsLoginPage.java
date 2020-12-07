package contants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContantsLoginPage {

    @FindBy(how = How.LINK_TEXT,using = "Login")
    public WebElement mainLoginButton;
    @FindBy(how = How.ID,using = "xl-form-email")
    public WebElement loginpageEmail;
    @FindBy(how = How.ID,using = "xl-form-submit")
    public WebElement loginpageButtonLogin;
    @FindBy(how = How.ID,using = "xl-form-password")
    public WebElement loginpagePassword;
    @FindBy(how = How.LINK_TEXT,using = "Log in to Xero")
    public WebElement loginpageTitleText;

    @FindBy(how = How.CSS,using = ".global-ceiling-bar-tagline")
    public WebElement mainPageText;



}
