package autotests.Steps;

import autotests.Pages.AdvancedSearchPage;
import autotests.Pages.BasePage;
import cucumber.api.java.uk.Нехай;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.security.PublicKey;

import static org.junit.Assert.assertEquals;

public class AdvancedSearchPageSteps {

    String rememberedElementTitle;

    @Step("Нажата кнопка - Перейти ко всем фильтрам")
    public void stepGoToAllFilters () {new AdvancedSearchPage(BaseSteps.getDriver()).advancedFiltersButton.click();}

    @Step("Выбран производитель - {0}")
    public void stepChooseVendor (String vendorName) {new AdvancedSearchPage(BaseSteps.getDriver()).chooseVendor(vendorName);}

    @Step("Выбрана цена от - {0}")
    public void stepfillPriceFrom (String priceFromValue) {
        new AdvancedSearchPage(BaseSteps.getDriver()).fillPriceFrom(priceFromValue);
    }

    @Step("Нажата кнопка - Применить")
    public void stepAcceptButtonClick () {new AdvancedSearchPage(BaseSteps.getDriver()).acceptFilterBtn.click();}

    @Step("Нажата кнопка - Показать подходящие")
    public void stepAdvFltrBtnClick () {new AdvancedSearchPage(BaseSteps.getDriver()).advFiltersAcceptBtn.click();}

    @Step("Выбран вид отображения списка товаров - список")
    public void stepSetVievtypeList () {new AdvancedSearchPage(BaseSteps.getDriver()).viewtypeList.click();}

    @Step("Количество товаров на странице соответствует ожидаемому значению = {0}")
    public void stepCheckCount (int expValue) {new AdvancedSearchPage(BaseSteps.getDriver()).checkCountProductOnPage(expValue);}

    @Step("Получили название {0}-го товара из списка, (отчет с 0)")
    public void stepGetFirstElementName (int index) {
        rememberedElementTitle = new AdvancedSearchPage(BaseSteps.getDriver()).getElement(index);
    }

    @Step("Вбили в запрос запомненного товара")
    public void stepFillRequestField () {
        new AdvancedSearchPage(BaseSteps.getDriver()).fillMarketRequestField(rememberedElementTitle);
    }

    @Step("Нажали кнопку - Поиск")
    public void stepMarketSearchBtnClick () {
        new AdvancedSearchPage(BaseSteps.getDriver()).searchButton.click();
    }

    @Step("Название найденного товара соответствует запомненному")
    public void stepCheckNames () {
        assertEquals(rememberedElementTitle, new AdvancedSearchPage(BaseSteps.getDriver()).expectedNameTitle.getText());
    }

    @Step("Открываем наушники первые из списка")
    public void stepGetFirstHeadEars () {new AdvancedSearchPage(BaseSteps.getDriver()).getFirstOfHeadEars();}


}


