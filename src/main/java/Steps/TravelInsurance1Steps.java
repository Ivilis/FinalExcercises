package Steps;
import Pages.TravelInsurance1step;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsurance1Steps extends BaseSteps{

    @Step("Выбрана сумма страховки - {0}")
    public void stepSelectInsuranceSum (String insuranceSum) {
        new TravelInsurance1step(BaseSteps.getDriver()).selectInsurance(insuranceSum);
    }

    @Step("Нажата кнопка - Оформить")
    public void stepAcceptButtonClick () {
        new TravelInsurance1step(BaseSteps.getDriver()).acceptButton.click();
    }
}
