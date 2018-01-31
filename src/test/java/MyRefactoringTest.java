import Pages.*;
import Steps.BaseSteps;
import org.junit.*;




public class MyRefactoringTest extends BaseSteps {

    @Ignore
    @Test

    public void newInsuranceTest() throws InterruptedException {
        BaseSteps.getDriver().get(baseUrl);
        MainPerson mainPerson = new MainPerson(BaseSteps.getDriver());
        mainPerson.selectMainMenuItem("Застраховать себя"); //наводимся на нужное меню
        mainPerson.selectSubMenuItem("Страхование путешественников"); //выбираем пункт в подменю

        BankInsurance bankInsurance = new BankInsurance(BaseSteps.getDriver());

        //проверям заголовок на странице
        bankInsurance.checkTitleText("Страхование путешественников");
        /*
        String actualTitle = bankInsurance.pageTitle.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));*/

        bankInsurance.chooseRequestType("онлайн");
        bankInsurance.bigBannerButton.click();

        //переключаемся на новое окно
        for (String winHandle : BaseSteps.getDriver().getWindowHandles()) {

            BaseSteps.getDriver().switchTo().window(winHandle);
        }

        TravelInsurance1step travelInsurance1step = new TravelInsurance1step(BaseSteps.getDriver());

        //выбираем сумму страховой защиты
        travelInsurance1step.selectInsurance("Минимальная");
        travelInsurance1step.acceptButton.click();

        TravelInsurance2step travelInsurance2step = new TravelInsurance2step(BaseSteps.getDriver());
        //вводим данные страхуемого
        travelInsurance2step.fillOurPainFields("Фамилия страхуемого","Tokugawa");
        travelInsurance2step.fillOurPainFields("Имя страхуемого","Ieyasy");
        travelInsurance2step.fillOurPainFields("Дата рождения страхуемого","31.01.1941");

        //выбираем гражданство страхователя
        travelInsurance2step.chooseCitezenship("гражданинРФ");
        //заполняем ФИО и ДР страхователя
        travelInsurance2step.fillOurPainFields("Имя страхователя","Нобунага");
        travelInsurance2step.fillOurPainFields("Фамилия страхователя","Ода");
        travelInsurance2step.fillOurPainFields("Отчество страхователя","Нобухидэ");
        travelInsurance2step.fillOurPainFields("Дата рождения страхователя","23.06.1934");
        //выбираем пол страхователя
        travelInsurance2step.chooseGender("мужской");

        //заполняем паспортные данные страхователя
        travelInsurance2step.fillOurPainFields("Серия паспорта страхователя","1212");
        travelInsurance2step.fillOurPainFields("Номер паспорта страхователя","123123");
        travelInsurance2step.fillOurPainFields("Дата выдачи паспорта страхователя","23.06.1946");
        travelInsurance2step.fillOurPainFields("Кем выдан паспорт страхователя","УВД замка Фураватари в провинции Овари");

        //проверяем правильность заполнения полей
        travelInsurance2step.checkThemPay("Фамилия страхуемого","Tokugawa");
        travelInsurance2step.checkThemPay("Имя страхуемого","Ieyasy");
        travelInsurance2step.checkThemPay("Дата рождения страхуемого","31.01.1941");
        travelInsurance2step.checkThemPay("Имя страхователя","Нобунага");
        travelInsurance2step.checkThemPay("Фамилия страхователя","Ода");
        travelInsurance2step.checkThemPay("Отчество страхователя","Нобухидэ");
        travelInsurance2step.checkThemPay("Дата рождения страхователя","23.06.1934");
        travelInsurance2step.checkThemPay("Серия паспорта страхователя","1212");
        travelInsurance2step.checkThemPay("Номер паспорта страхователя","123123");
        travelInsurance2step.checkThemPay("Дата выдачи паспорта страхователя","23.06.1946");
        travelInsurance2step.checkThemPay("Кем выдан паспорт страхователя","УВД замка Фураватари в провинции Овари");

        //жмём кнопку и проверяем сообщение об ошибке
        travelInsurance2step.continueButton.click();
        travelInsurance2step.checkErrorMessage("Заполнены не все обязательные поля");

        System.out.println("Test successfully completed\n");
        throw new InterruptedException("Что-то прервалось");
    }

}
