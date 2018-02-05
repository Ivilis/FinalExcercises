package autotests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexBasePage extends BasePage {

    @FindBy(xpath = "//div[@class='home-arrow__tabs']")
    WebElement mainMenu;

    @FindBy(xpath = "//input[@aria-label='Запрос']")
    WebElement requestField;

    @FindBy(xpath = "//*[contains(text(),'Найти')]")
    WebElement searchButton;

    public YandexBasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Wait<WebDriver> wait = new WebDriverWait(driver,30, 2000);
        wait.until(ExpectedConditions.visibilityOf(mainMenu));
    }

    public void selectMenuItem (String menuItem){
        switch (menuItem) {
            case "Видео":
                mainMenu.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();
                break;
            case "Картинки":
                mainMenu.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();
                break;
            case "Новости":
                mainMenu.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();
                break;
            case "Карты":
                mainMenu.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();
                break;
            case "Маркет":
                mainMenu.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();
                break;
            case "Переводчик":
                mainMenu.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();
                break;
            case "Музыка":
                mainMenu.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();
                break;
            case "ТВ онлайн":
                mainMenu.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();
                break;
            case "ещё":
                mainMenu.findElement(By.xpath("//*[contains(text(),'"+menuItem+"')]")).click();
                break;
            default:
                throw new AssertionError("Поле '" + menuItem + "' не объявлено на странице");
        }
    }

    public void fillRequestField (String value)
    {
        requestField.clear();
        requestField.sendKeys(value);
    }
}
