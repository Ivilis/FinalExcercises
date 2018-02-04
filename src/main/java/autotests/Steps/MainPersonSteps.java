package autotests.Steps;

import autotests.Pages.MainPerson;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPersonSteps{

        @Step("Выбран пункт меню - {0}")
    public void stepSelectMainMenu (String menuItem) {
        new MainPerson(BaseSteps.getDriver()).selectMainMenuItem(menuItem);
    }

    @Step("Выбран пункт субменю - {0}")
    public void stepSelectSubMenu(String menuItem) {
        new MainPerson(BaseSteps.getDriver()).selectSubMenuItem(menuItem);
    }

}
