import Steps.*;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.HashMap;

public class RefactoringWithAllureReportTest extends BaseSteps {

    @Test
    @Title("Страхование путешественников")

    public void testInsurance () {
        BaseSteps.getDriver().get(baseUrl);
        MainPersonSteps mainPersonSteps = new MainPersonSteps();
        BankInsuranceSteps bankInsuranceSteps = new BankInsuranceSteps();
        TravelInsurance1Steps travelInsurance1Steps = new TravelInsurance1Steps();
        TravelInsurance2Steps travelInsurance2Steps = new TravelInsurance2Steps();

        HashMap<String,String> testData = new HashMap<>();
        testData.put("Фамилия страхуемого","Tokugawa");
        testData.put("Имя страхуемого","Ieyasy");
        testData.put("Дата рождения страхуемого","31.01.1941");
        testData.put("Имя страхователя","Нобунага");
        testData.put("Фамилия страхователя","Ода");
        testData.put("Отчество страхователя","Нобухидэ");
        testData.put("Дата рождения страхователя","23.06.1934");
        testData.put("Серия паспорта страхователя","1212");
        testData.put("Номер паспорта страхователя","123123");
        testData.put("Дата выдачи паспорта страхователя","23.06.1946");
        testData.put("Кем выдан паспорт страхователя","УВД замка Фураватари в провинции Овари");

        mainPersonSteps.stepSelectMainMenu("Застраховать себя");
        mainPersonSteps.stepSelectSubMenu("Страхование путешественников");

        bankInsuranceSteps.stepCheckTitleText("Страхование путешественников");
        bankInsuranceSteps.stepChooseRequestType("онлайн");
        bankInsuranceSteps.stepBannerButtonClick();

        for (String winHandle : BaseSteps.getDriver().getWindowHandles()) {

            BaseSteps.getDriver().switchTo().window(winHandle);
        }

        travelInsurance1Steps.stepSelectInsuranceSum("Минимальная");
        travelInsurance1Steps.stepAcceptButtonClick();

        travelInsurance2Steps.stepChooseCitizenship("гражданинРФ");
        travelInsurance2Steps.stepChooseGender("мужской");
        travelInsurance2Steps.stepFillAllFields(testData);
    }
}
