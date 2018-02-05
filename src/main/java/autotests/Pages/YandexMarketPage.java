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

public class YandexMarketPage extends BasePage {

    Actions actions;

    @FindBy(xpath = "//ul[@class='topmenu__list']")
    WebElement marketMainMenu;

    @FindBy(xpath = "//div[@class='catalog-menu i-bem catalog-menu_js_inited']")
    WebElement marketSubMenu;

    @FindBy(xpath = "//div//div[@class='topmenu__sublist'][@style='left: 23px;']")
    WebElement subMenuTab;

    @FindBy(xpath = "//div[@class='n-region-notification_layout_init']")
    public WebElement regionAccepter;

    //@FindBy(xpath = "//span[@class='button2 button2_size_m button2_theme_action button2_width_max n-region-notification__actions-btn n-region-notification__ok i-bem button2_js_inited']")
   // public WebElement acceptRegionButton;

    @FindBy(xpath = "//span[contains(text(),'Нет')]")
    public WebElement declineRegionButton;

    public YandexMarketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actions = new Actions(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, 30, 2000);
        wait.until(ExpectedConditions.visibilityOf(marketMainMenu));
    }



    public void moveMouseToElement(String menuItem) {
        switch (menuItem) {
            case "Электроника":
                actions.moveToElement(marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"']"))).build().perform();
                break;
            case "Компьютеры":
                actions.moveToElement(marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"']"))).build().perform();
                //marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"'")).click();
                break;
            case "Бытовая техника":
                actions.moveToElement(marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"']"))).build().perform();
                //marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"'")).click();
                break;
            case "Детские товары":
                actions.moveToElement(marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"']"))).build().perform();
                //marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"'")).click();
                break;
            case "Зоотовары":
                actions.moveToElement(marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"']"))).build().perform();
                //marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"'")).click();
                break;
            case "Дом, дача, ремонт":
                actions.moveToElement(marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"']"))).build().perform();
                //marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"'")).click();
                break;
            case "Одежда и обувь":
                actions.moveToElement(marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"']"))).build().perform();
                //marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"'")).click();
                break;
            case "Красота и здоровье":
                actions.moveToElement(marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"']"))).build().perform();
                //marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"'")).click();
                break;
            case "Авто":
                actions.moveToElement(marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"']"))).build().perform();
                //marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"'")).click();
                break;
            case "Ещё":
                actions.moveToElement(marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"']"))).build().perform();
                //marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"'")).click();
                break;
            default:
                throw new AssertionError("Поле '" + menuItem + "' не объявлено на странице");
        }
    }

    public void chooseSubMenu (String subMenuItem) {
        switch (subMenuItem) {
            case "Телевизоры":
                marketMainMenu.findElement(By.xpath
                        (".//div//div[@class='topmenu__sublist'][@style='left: 23px;']//*[contains(text(),'"+subMenuItem+"')]"))
                        .click();
                break;
            case "Наушники":
                marketMainMenu.findElement(By.xpath
                        (".//div//div[@class='topmenu__sublist'][@style='left: 23px;']//*[contains(text(),'"+subMenuItem+"')]"))
                        .click();
                //marketMainMenu.findElement(By.xpath("//li[@data-department='"+menuItem+"'")).click();
                break;
            default:
                throw new AssertionError("Поле '" + subMenuItem + "' не объявлено на странице");
        }
    }

    public void menuClick (String menuItem) {
        marketMainMenu.findElement(By.xpath("//li[@data-department='" + menuItem + "']")).click();
    }

    public void waitSubMenuTab () {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 2000);
        wait.until(ExpectedConditions.visibilityOf(subMenuTab));
    }

    public void waitRegionAcceptor () {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 2000);
        wait.until(ExpectedConditions.visibilityOf(regionAccepter));
    }

    public void selectMarketSubMenuItem(String menuItem) {
        switch (menuItem) {
            case "Электроника":
                marketSubMenu.findElement(By.xpath("//li[@data-department='" + menuItem + "'")).click();
                break;
            case "Компьютеры":
                marketSubMenu.findElement(By.xpath("//li[@data-department='" + menuItem + "'")).click();
                break;
            default:
                throw new AssertionError("Поле '" + menuItem + "' не объявлено на странице");
        }
    }
}
