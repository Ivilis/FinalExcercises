package autotests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class BankInsurance extends BasePage{

    @FindBy(xpath = "//H1[not(@class='sr_only')]")
    public WebElement pageTitle;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']")
    WebElement tabContainer;

    @FindBy(xpath = "//a//img[contains(@src,'banner-zashita-traveler')]")
    public WebElement bigBannerButton;

    public BankInsurance(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    //метод выбора типа заявки: онлайн/в офисе
    public void chooseRequestType (String requesttype) {
        switch (requesttype) {
            case "онлайн":
                tabContainer.findElement(By.xpath(".//*[contains(text(),'онлайн')]")).click();
                break;
            case "оффлайн":
                tabContainer.findElement(By.xpath(".//*[contains(text(),'в отделении')]")).click();
                break;
            default:
                throw new AssertionError("Поле '" + requesttype + "' не объявлено на странице");
        }
    }

    public void checkTitleText(String inputData){
        assertEquals(inputData,pageTitle.getText());
    }

    public void waitElement () {
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
    }


}
