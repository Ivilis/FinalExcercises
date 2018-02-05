package autotests.Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class YandexScenarioSteps {

    YandexBasePageSteps yandexBasePageSteps = new YandexBasePageSteps();
    YandexMarketPageSteps yandexMarketPageSteps = new YandexMarketPageSteps();
    AdvancedSearchPageSteps advancedSearchPageSteps = new AdvancedSearchPageSteps();

    @When("^Открываем вкладку \"(.*)\"$")
    public void stepSelectBaseMenuItem (String menuItem) {yandexBasePageSteps.stepSelectMenuItem(menuItem);}

    @When("^Наводимся на пункт меню маркета \"(.*)\"$")
    public void stepMoveToElement (String menuItem) {yandexMarketPageSteps.stepMoveToElement(menuItem);}

    @When("^Выбираем пункт подменю маркета \"(.*)\"$")
    public void stepSelectSubMenuItem (String menuItem) {yandexMarketPageSteps.stepChooseSubMenu(menuItem);}

    @When("^Ожидаем появления выпадающего меню")
    public void stepWaitSubMenuTab () {yandexMarketPageSteps.stepWaitSubMenuTab();}

    @When("^Ожидаем появления окна подтверждения домашнего региона")
    public void stepWaitRegionAcceptor () {yandexMarketPageSteps.stepWaitRegionAcceptor();}

    @When("^Нажимаем кнопку подтверждения домашнего региона")
    public void stepAcceptRegionButtonClick () {yandexMarketPageSteps.stepAcceptRegionButtonClick();}

    @When("^Нажимаем пункт меню \"(.*)\"$")
    public void stepMenuItemClick (String menuItem) {yandexMarketPageSteps.stepMenuClick(menuItem);}

    @When("^Выбираем производителя \"(.*)\"$")
    public void stepChooseVendor (String vendorName) {advancedSearchPageSteps.stepChooseVendor(vendorName);}

    @When("^Задаем минимальную цену - \"(.*)\"$")
    public void stepFillPriceFrom (String priceFromValue) {advancedSearchPageSteps.stepfillPriceFrom(priceFromValue);}

    @When("^Нажимаем кнопку - Применить")
    public void stepAcceptFilterButtonClick () {advancedSearchPageSteps.stepAcceptButtonClick();}

    @When("^Нажимаем кнопку - Показать подходящие")
    public void stepAdvAcceptFltrBtnClick () {advancedSearchPageSteps.stepAdvFltrBtnClick();}

    @When("^Выбираем вид отображения товаров - список")
    public void stepSetViewtype () {advancedSearchPageSteps.stepSetVievtypeList();}

    @When("^Нажимаем кнопку - Перейти ко всем фильтрам")
    public void stepGoToAllFilters () {advancedSearchPageSteps.stepGoToAllFilters();}

    @When("^Сравниваем количество товаров на странице с заданным значением - \"(.*)\"$")
    public void stepCheckCountOnPage (int expCount) {advancedSearchPageSteps.stepCheckCount(expCount);}

    @When("^Получаем название товара из списка под номером \"(.*)\"$")
    public void stepGetFirstElement (int index) {advancedSearchPageSteps.stepGetFirstElementName(index);}

    @When("^Вбиваем полученное название в поисковую строку")
    public void stepFillRequest () {advancedSearchPageSteps.stepFillRequestField();}

    @When("^Нажимаем на кнопку - найти в маркете")
    public void stepSearchButtonClick () {advancedSearchPageSteps.stepMarketSearchBtnClick();}

    @When("^Сравниваем название найденного товара и запомненного из списка")
    public void stepEvaluateNames () {advancedSearchPageSteps.stepCheckNames();}

    @When("^Открываем первые наушники из списка")
    public void stepGetFirstEarsInList () {advancedSearchPageSteps.stepGetFirstHeadEars();}



}
