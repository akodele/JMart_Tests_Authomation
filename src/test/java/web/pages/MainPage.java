package web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.pages.components.CitySelectModal;
import web.pages.components.NewSearchNotificationModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    CitySelectModal citySelectModal=new CitySelectModal();
    NewSearchNotificationModal newSearchNotificationModal=new NewSearchNotificationModal();

    SelenideElement
            selectedCity=$x("//div[contains(@class,'ipRYCv')]"),
            catalogButton=$x("//div[contains(@class,'cwoqMd')]"),
            searchField=$x("//input[contains(@class,'jSDdUX')]"),
            searchButton=$x("//div[contains(@class,'eOSudP')]");

    ElementsCollection
            mainMenus = $$x("//div[contains(@class,'fnoIFz')]");

    @Step("Открываем категорию \"Продукты\"")
    public MainPage mainMenusSelectThird() {
        mainMenus.get(2).parent().click();
        return this;
    }

    @Step("Выбираем город {0} и закрываем модальное окно с новинкой")
    public MainPage selectCity(String cityName){
        citySelectModal.citySelectAndClick(cityName);

        return this;
    }

    @Step("Проверяем название города на главной странице")
    public MainPage checkCityNameOnMainPage(String city){
        selectedCity.shouldHave(text(city));
        return this;
    }

    @Step("Нажимаем на кнопку \"Каталог\" в верхнем меню")
    public MainPage selectCatalog(){
        catalogButton.click();
        return this;
    }

    @Step("Вводим текст для поиска и нажимаем кнопку поиска")
    public MainPage search(String searchText){
        searchField.setValue(searchText);
        searchButton.click();
        return this;
    }
}
