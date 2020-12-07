package contants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContantsCreateBussinessPage
{
    @FindBy(how = How.ID,using = "0bc24df0-b4c0-4e37-83df-c10c9327c7c7-control")
    public WebElement textBussinessName;
    @FindBy(how = How.ID,using = "52357294-48e3-4e60-97c0-6381f218838a-control")
    public WebElement textIndustry;
    @FindBy(how = How.CSS,using = "div:nth-of-type(2) > label[role='presentation'] > .xui-styledcheckboxradio--radio.xui-styledcheckboxradio--radio-small")
    public WebElement radioButtonNoJustMe;
    @FindBy(how = How.CSS,using = ".button__2_4F-.xui-actions--secondary.xui-button.xui-button-fullwidth.xui-button-medium.xui-button-standard")
    public WebElement buttonBuyNow;
}
