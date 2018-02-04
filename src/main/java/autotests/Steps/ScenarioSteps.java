package autotests.Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainPersonSteps mainPersonSteps = new MainPersonSteps();
    BankInsuranceSteps bankInsuranceSteps = new BankInsuranceSteps();
    TravelInsurance1Steps travelInsurance1Steps = new TravelInsurance1Steps();
    TravelInsurance2Steps travelInsurance2Steps = new TravelInsurance2Steps();



    @When("^Выбираем пункт меню \"(.*)\"$")
    public void stepSelectMainMenuItem (String menuItem) {
        mainPersonSteps.stepSelectMainMenu(menuItem);
    }

    @Then("^Выбираем пункт подменю \"(.*)\"$")
    public void stepSelectSubMenuItem (String menuItem) {
        mainPersonSteps.stepSelectSubMenu(menuItem);
    }

    @When("Ожидаем загрузки заголовка")
    public void stepWaitLoading () {
        bankInsuranceSteps.stepWaitElement();
    }

    @When("^Проверяем текст заголовка страницы соответствует тексту - \"(.*)\"$")
    public void stepCheckTitle (String titleText) {
        bankInsuranceSteps.stepCheckTitleText(titleText);
    }

    @Then("^Выбираем вид заявки - \"(.*)\"$")
    public void stepSelectRequestType (String requestType) {
        bankInsuranceSteps.stepChooseRequestType(requestType);
    }

    @Then("^Нажимаем кнопку-баннер - Оформить Онлайн")
    public void stepBannerButtonClick () {
        bankInsuranceSteps.stepBannerButtonClick();
    }

    @Then("^Переключаемся на новую вкладку")
    public void stepGetNewWindow () {
        for (String winHandle : BaseSteps.getDriver().getWindowHandles()) {

            BaseSteps.getDriver().switchTo().window(winHandle);
        }
    }

    @When("Ожидаем загрузки страницы для выбора суммы страхования")
    public void stepWaitInsuranceSumLoading () {
        travelInsurance1Steps.stepWaitElements();
    }

    @When("^Выбираем сумму страховки - \"(.*)\"$")
    public void stepSelectInsuranceSum (String insuranceSum) {
        travelInsurance1Steps.stepSelectInsuranceSum(insuranceSum);
    }

    @Then("^Нажимаем кнопку - Оформить")
    public void stepAcceptButtonClick () {
        travelInsurance1Steps.stepAcceptButtonClick();
    }

    @When("^Выбираем гражданство - \"(.*)\"$")
    public void stepChooseCitizenship (String citizenornot) {
        travelInsurance2Steps.stepChooseCitizenship(citizenornot);
    }

    @When("^Выбираем пол - \"(.*)\"$")
    public void stepChooseGender (String gender) {
        travelInsurance2Steps.stepChooseGender(gender);
    }

    @When("Заполняем поля:")
    public void stepFillFields (DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (key,value) -> travelInsurance2Steps.stepFillField(key, value)
        );
    }

    @Then ("^Проверяем значения полей:$")
    public void stepCheckFields (DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (key,value) -> travelInsurance2Steps.stepCheckField(key, value)
        );
    }

    @Then("^Нажимаем кнопку - Продолжить")
    public void stepContinueButtonClick () {
        travelInsurance2Steps.stepContinueButtonClick();
    }

    @Then("^Проверяем текст ошибки на соответствие шаблону - \"(.*)\"$")
            public void stepErrorText (String errorText) {
        travelInsurance2Steps.stepCheckErrorMessage(errorText);
    }



}
