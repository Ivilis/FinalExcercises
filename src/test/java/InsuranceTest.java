
import Steps.BaseSteps;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.io.FileWriter;

import static org.junit.Assert.assertEquals;

public class InsuranceTest extends BaseSteps {

    @Test
@Ignore
    public void testInsurance () throws Exception {


        try {

            BaseSteps.getDriver().get(baseUrl);

            FileWriter writer = new FileWriter("G:\\GitHub\\Lesson1\\stuff\\logs.txt", true);
            writer.write("Step 1: Переход на сайт Сбербанка http://www.sberbank.ru/ru/person - Ok - " + LocalDateTime.now() + "\n");


            BaseSteps.getDriver().findElement(By.xpath("//div[contains(@data-pid,'widget_3719')]//*[@aria-label='Раздел Застраховать себя  и имущество']")).click();
            writer.write("Step 2: Нажать на – Застраховать себя и имущество - Оk - " + LocalDateTime.now().toString() + "\n");



            Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
            wait.until(ExpectedConditions.visibilityOf(
                    BaseSteps.getDriver().findElement(By.xpath("//div[contains(@class,'bp-area header-container')]//a[contains(text(),'Страхование путешественников')]"))
            )).click();


           // driver.findElement(By.xpath("//A[@class='kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1' and @href='/ru/person/bank_inshure/insuranceprogram/life/travel']")).click();
            writer.write("Step 3: Выбрать – Страхование путешественников - Ok - " + LocalDateTime.now().toString() + "\n");


            assertEquals("Страхование путешественников",
                    BaseSteps.getDriver().findElement(By.xpath("//H1[not(@class='sr_only')]")).getText());
            writer.write("Step 4: Проверка наличия заголовка формы  - Страхование путешественников - Ok - " + LocalDateTime.now().toString() + "\n");


            BaseSteps.getDriver().findElement(By.xpath("//*[text()='Оформить онлайн']")).click();
            BaseSteps.getDriver().findElement(By.xpath("//a//img[contains(@src,'banner-zashita-traveler')]")).click();

            writer.write("Step 5: Нажать – Оформит онлайн - Ok - " + LocalDateTime.now().toString() + "\n");

            for (String winHandle : BaseSteps.getDriver().getWindowHandles()) {

                BaseSteps.getDriver().switchTo().window(winHandle);
            }

// //div[text()='Минимальная']   //DIV[@class='b-form-box-title ng-binding'][text()='Минимальная']

            wait.until(ExpectedConditions.elementToBeClickable(BaseSteps.getDriver().findElement(By.xpath("//*[contains(text(),\"Минимальная\")]")))).click();
            //driver.findElement(By.xpath("//DIV[@class='b-form-box-title ng-binding'][text()='Минимальная']/..")).click();
            writer.write("Step 6: Выбрать минимальную сумму страховой защиты - Ok - " + LocalDateTime.now().toString() + "\n");

            BaseSteps.getDriver().findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Оформить']")).click();
            writer.write("Step 7: Нажать оформить - Ok - " + LocalDateTime.now().toString() + "\n");




            //Заполнение данных страхуемого
            fillField(By.name("insured0_surname"), "PETROV");

            fillField(By.name("insured0_name"), "PETR");


            //ввод даты
            //driver.findElement(By.name("insured0_birthDate")).click();
            fillField(By.name("insured0_birthDate"), "01011990");

            writer.write("Step 8: Заполнить данные страхуемого - Ok - " + LocalDateTime.now().toString() + "\n");


       /* работа с элементами даты
        driver.findElement(By.xpath("//INPUT[@id='dp1515951862770']")).click();
        new Select(driver.findElement(By.xpath("//SELECT[@class='ui-datepicker-year']"))).selectByVisibleText("1990");
        new Select(driver.findElement(By.xpath("//SELECT[@class='ui-datepicker-month']"))).selectByVisibleText("Янв");
        driver.findElement(By.xpath("//A[@class='ui-state-default ui-state-hover'][text()='1']")).click();
       */

            //Заполнение данных страхователя
            BaseSteps.getDriver().findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.CITIZENSHIP' and @value='0']")).click();

            fillField(By.name("surname"), "ПЕТРОВ");

            fillField(By.name("name"), "ПЕТРО");

            fillField(By.name("middlename"), "ПЕТРОВИЧ");

            fillField(By.name("birthDate"), "02021960");

            BaseSteps.getDriver().findElement(By.xpath("//*[@id=\"views\"]/section/form/section/section[2]/div/fieldset[8]/span[1]/input")).click();

            writer.write("Step 9: Заполнить данные страхователя - Ok - " + LocalDateTime.now().toString() + "\n");


        /* работа с элементами даты
        driver.findElement(By.xpath("//INPUT[@id='dp1515951862768']")).click();
        new Select(driver.findElement(By.xpath("//SELECT[@class='ui-datepicker-year']"))).selectByVisibleText("1960");
        new Select(driver.findElement(By.xpath("//SELECT[@class='ui-datepicker-month']"))).selectByVisibleText("Фев");
        driver.findElement(By.xpath("//A[@class='ui-state-default ui-state-hover'][text()='2']")).click();
       */

            //Заполнение паспортных данных
            fillField(By.xpath("//input[@placeholder='Серия']"), "4444");

            fillField(By.xpath("//input[@placeholder='Номер']"), "666666");

            fillField(By.xpath("//TEXTAREA[@name='issuePlace']"), "Отделением номер из города Энск тогда-то");

            fillField(By.name("issueDate"), "02022005");

            writer.write("Step 10: Заполнить паспортные данные страхователя и пропустить контактные данные - Ok - " + LocalDateTime.now().toString() + "\n");


            //проверяем правильность заполнения страхуемого
            checkFillField("PETROV",By.name("insured0_surname"));
            checkFillField("PETR",By.name("insured0_name"));
            checkFillField("01.01.1990",By.name("insured0_birthDate"));

          /*  assertEquals("PETROV", driver.findElement(By.xpath("//INPUT[@name='insured0_surname']")).getAttribute("value"));
            assertEquals("PETR", driver.findElement(By.xpath("//INPUT[@name='insured0_name']")).getAttribute("value"));
            assertEquals("01.01.1990", driver.findElement(By.name("insured0_birthDate")).getAttribute("value")); */

            writer.write("Step 11: Проверка правильности данных страхуемого - Ok - " + LocalDateTime.now().toString() + "\n");


            //проверяем правильность заполнения страхователя
            checkFillField("ПЕТРОВ",By.name("surname"));
            checkFillField("ПЕТРО",By.name("name"));
            checkFillField("ПЕТРОВИЧ",By.name("middlename"));
            checkFillField("02.02.1960",By.name("birthDate"));

           /* assertEquals("ПЕТРОВ", driver.findElement(By.xpath("//INPUT[@name='surname']")).getAttribute("value"));
            assertEquals("ПЕТРО", driver.findElement(By.xpath("//INPUT[@name='name']")).getAttribute("value"));
            assertEquals("ПЕТРОВИЧ", driver.findElement(By.xpath("//INPUT[@name='middlename']")).getAttribute("value"));
            assertEquals("02.02.1960", driver.findElement(By.name("birthDate")).getAttribute("value")); */

            writer.write("Step 12: Проверка правильности данных страхователя - Ok - " + LocalDateTime.now().toString() + "\n");


            //проверяем правильность заполнения паспортных данных
            checkFillField("4444",By.xpath("//input[@placeholder='Серия']"));
            checkFillField("666666",By.xpath("//input[@placeholder='Номер']"));
            checkFillField("Отделением номер из города Энск тогда-то",By.name("issuePlace"));
            checkFillField("02.02.2005",By.name("issueDate"));

           /* assertEquals("4444", driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")).getAttribute("value"));
            assertEquals("666666", driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")).getAttribute("value"));
            assertEquals("Отделением номер из города Энск тогда-то", driver.findElement(By.xpath("//TEXTAREA[@name='issuePlace']")).getAttribute("value"));
            assertEquals("02.02.2005", driver.findElement(By.name("issueDate")).getAttribute("value")); */

            writer.write("Step 13: Проверка правильности паспортных данных страхователя - Ok - " + LocalDateTime.now().toString() + "\n");


            BaseSteps.getDriver().findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Продолжить']")).click();
            writer.write("Step 14: Нажать продолжить - Ok - " + LocalDateTime.now().toString() + "\n");


            assertEquals("Заполнены не все обязательные поля",
                    BaseSteps.getDriver().findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid']")).getText());

            writer.write("Step 15: Проверка вывода сообщения об ошибке - Ok - " + LocalDateTime.now().toString() + "\n");


            writer.close();
        }
        catch (IOException E){System.out.println(E.getMessage());}
        System.out.println("Тест завершился без ошибок\n");
        throw new Exception("Exception какой-то");

    }

}
