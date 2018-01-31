package Steps;
import Pages.TravelInsurance2step;
import ru.yandex.qatools.allure.annotations.Step;
import com.sun.tools.javac.*;
import java.util.HashMap;

public class TravelInsurance2Steps extends BaseSteps{

    @Step("Выбран тип гражданства - {0}")
    public void stepChooseCitizenship (String citizenornot) {
        new TravelInsurance2step(BaseSteps.getDriver()).chooseCitezenship(citizenornot);
    }

    @Step("Выбран пол - {0}")
    public void stepChooseGender (String gender) {
        new TravelInsurance2step(BaseSteps.getDriver()).chooseGender(gender);
    }

    @Step("Поле {0} заполнено значением - {1}")
    public void stepFillField (String field, String value) {
        new TravelInsurance2step(BaseSteps.getDriver()).fillOurPainFields(field, value);
    }

    @Step("Заполняются поля:")
    public void stepFillAllFields (HashMap<String,String> fields) {
        fields.forEach(this::stepFillField);

    }
}
