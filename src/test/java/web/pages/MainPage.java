package web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.pages.components.CitySelectModal;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    CitySelectModal citySelectModal=new CitySelectModal();

    SelenideElement
            selectedCity=$x("//div[@class='sc-kDTinF fNpZc']");

    ElementsCollection
            mainMenus = $$x(".//div[@class='sc-gKclnd sc-iqseJM eAsfZL gHYMmw sc-cabOPr JiVmU']//a");

    @Step("Открываем категорию \"Продукты\"")
    public MainPage mainMenusSelectThird() {
        mainMenus.get(2).click();
        return this;
    }

    @Step("Выбираем город {0}")
    public MainPage selectCity(String cityName){
        citySelectModal.citySelectAndClick(cityName);
        return this;
    }

    @Step("Проверяем название города на главной странице")
    public MainPage checkCityNameOnMainPage(String city){
        selectedCity.shouldHave(text(city));
        return this;
    }
}
