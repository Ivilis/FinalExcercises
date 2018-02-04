package autotests.Steps;
import autotests.Pages.TravelInsurance1step;
import autotests.Pages.TravelInsurance2step;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsurance1Steps{

    @Step("Загрузилась страница для выбора суммы страховки")
    public void stepWaitElements (){
        new TravelInsurance1step(BaseSteps.getDriver()).waitElements();
    }

    @Step("Выбрана сумма страховки - {0}")
    public void stepSelectInsuranceSum (String insuranceSum) {
        new TravelInsurance1step(BaseSteps.getDriver()).selectInsurance(insuranceSum);
    }

    @Step("Нажата кнопка - Оформить")
    public void stepAcceptButtonClick () {
        new TravelInsurance1step(BaseSteps.getDriver()).acceptButton.click();
    }
}
