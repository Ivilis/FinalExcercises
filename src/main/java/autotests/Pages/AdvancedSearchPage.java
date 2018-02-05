package autotests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdvancedSearchPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'n-snippet-card2 i-bem')]//div[@class='n-snippet-card2__title'][1]")
    WebElement firstOfHeadEars;

    @FindBy(xpath = "//input[contains(@value,'list')]")
    public WebElement viewtypeList;

    @FindBy(xpath = "//div[contains(@class,'n-snippet-card2 i-bem')]//div[@class='n-snippet-card2__title']")
    List<WebElement> foundedStuff;
    //[1]//div[@class='n-snippet-cell2__header']//a[@title]

    @FindBy(name = "glf-pricefrom-var")
    WebElement priceFrom;

    @FindBy(name = "glf-priceto-var")
    WebElement priceTo;

    @FindBy(xpath = "//div[@class='n-filter-panel-aside__apply']")
    public WebElement acceptFilterBtn;

    @FindBy(xpath = "//a[contains(@class,'button button_size_l')]")
    public WebElement advFiltersAcceptBtn;

    @FindBy(xpath = "//div[@data-filter-id='7893318']")
    WebElement vendorBlock;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement marketRequestField;

    @FindBy(xpath = "//span[@class='search2__button']")
    public WebElement searchButton;

    @FindBy(xpath = "//h1[contains(@class,'title')]")
    public WebElement expectedNameTitle;

    @FindBy(xpath = "//a[contains(text(),'Перейти ко всем фильтрам')]")
    public WebElement advancedFiltersButton;

    public AdvancedSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Wait<WebDriver> wait = new WebDriverWait(driver, 30, 2000);
        wait.until(ExpectedConditions.visibilityOf(searchButton));
    }

    public void chooseVendor (String vendorName) {
        vendorBlock.findElement(By.xpath(".//*[contains(text(),'"+vendorName+"')]")).click();
    }

    public void fillPriceFrom (String value) {
        priceFrom.clear();
        priceFrom.sendKeys(value);
    }

    public void fillPriceTo (String value) {
        priceTo.clear();
        priceTo.sendKeys(value);
    }

    public int getCountProductOnPage() {
        return foundedStuff.size();
    }

    public void checkCountProductOnPage(int expectedValue) {
        assertEquals(expectedValue, getCountProductOnPage());
    }

    public String getElement(int index) {
        return foundedStuff.get(index).getText();
    }

    public void fillMarketRequestField(String expName) {
        marketRequestField.sendKeys(expName);
    }

    public void getFirstOfHeadEars(){
        firstOfHeadEars.click();
    }
}
