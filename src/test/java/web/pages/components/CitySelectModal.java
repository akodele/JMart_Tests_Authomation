package web.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CitySelectModal {

    NewNotificationModal newNotificationModal =new NewNotificationModal();

    SelenideElement
            cityOfStores=$x("//div[contains(@class,'fAvePO')]");
    ElementsCollection
            cities=$$x("//div[contains(@class,'jYqNeT')]");


    public void citySelectAndClick(String cityName) {
        if(cities.first().is(appear)){
            cities.findBy(text(cityName)).click();

            newNotificationModal.closeNewSearchModal();
        }else {
            newNotificationModal.closeNewSearchModal();
            cityOfStores.click();
            cities.findBy(text(cityName)).click();
        }
    }
}
