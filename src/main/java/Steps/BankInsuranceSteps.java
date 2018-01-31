package Steps;
import Pages.BankInsurance;
import ru.yandex.qatools.allure.annotations.Step;

public class BankInsuranceSteps extends BaseSteps{

    @Step("Текст заголовка соответствует ожидаемому - {0}")
    public void stepCheckTitleText (String inputData){
        new BankInsurance(BaseSteps.getDriver()).checkTitleText(inputData);
    }

    @Step("Выбираем тип заявки - {0}")
    public void stepChooseRequestType (String requesttype) {
        new BankInsurance(BaseSteps.getDriver()).chooseRequestType(requesttype);
    }

    @Step("Нажимаем кнопку - Оформит онлайн")
    public void stepBannerButtonClick () {
        new BankInsurance(BaseSteps.getDriver()).bigBannerButton.click();
    }
}
