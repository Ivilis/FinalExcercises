package autotests.Steps;
import autotests.Pages.BankInsurance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class BankInsuranceSteps{

    @Step("Загрузилась страница с заголовком")
    public void stepWaitElement (){
        new BankInsurance(BaseSteps.getDriver()).waitElement();
    }

    @Step("Текст заголовка соответствует ожидаемому - {0}")
    public void stepCheckTitleText (String inputData){
        new BankInsurance(BaseSteps.getDriver()).checkTitleText(inputData);
    }

    @Step("Выбран тип заявки - {0}")
    public void stepChooseRequestType (String requesttype) {
        new BankInsurance(BaseSteps.getDriver()).chooseRequestType(requesttype);
    }

    @Step("Нажата кнопка - Оформит онлайн")
    public void stepBannerButtonClick () {
        new BankInsurance(BaseSteps.getDriver()).bigBannerButton.click();
    }
}
