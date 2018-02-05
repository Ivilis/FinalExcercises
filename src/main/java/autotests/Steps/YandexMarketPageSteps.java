package autotests.Steps;

import autotests.Pages.YandexMarketPage;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMarketPageSteps {

    @Step("Выбран пункт меню {0}")
    public void stepMoveToElement (String menuItem) {
        new YandexMarketPage(BaseSteps.getDriver()).moveMouseToElement(menuItem);
    }

    @Step("Выбран пункт подменю {0}")
    public void stepChooseSubMenu (String subMenuItem) {
        new YandexMarketPage(BaseSteps.getDriver()).chooseSubMenu(subMenuItem);
    }

    @Step("Появилось выпадающее меню")
    public void stepWaitSubMenuTab () {new YandexMarketPage(BaseSteps.getDriver()).waitSubMenuTab();}

    @Step("Появилось окно подтверждения домашнего региона")
    public void stepWaitRegionAcceptor () {new YandexMarketPage(BaseSteps.getDriver()).waitRegionAcceptor();}

    @Step("Нажата кнопка подтверждения домашнего региона")
    public void stepAcceptRegionButtonClick () {
        new YandexMarketPage(BaseSteps.getDriver()).regionAccepter.findElement(By.xpath
                (".//span[@class='button2 button2_size_m button2_theme_action button2_width_max n-region-notification__actions-btn n-region-notification__ok i-bem button2_js_inited']"))
                .click();}

    @Step("Нажат пункт меню {0}")
    public void stepMenuClick (String menuItem) {new YandexMarketPage(BaseSteps.getDriver()).menuClick(menuItem);}
}
