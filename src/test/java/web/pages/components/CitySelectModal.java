package web.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CitySelectModal {
    SelenideElement
            citySelectTextModal = $x(".//div[@id='styleScroll']"),
            cityOfStores=$x("//div[@class='sc-kDTinF fNpZc']");
    ElementsCollection
            cities=$$x("//div[@class='sc-kDTinF hmiryJ']");

    public void citySelectAndClick(String cityName) {
        if(citySelectTextModal.is(appear)){
            cities.findBy(text(cityName)).parent().click();
        }else {
            cityOfStores.click();
            cities.findBy(text(cityName)).parent().click();
        }
    }
}
