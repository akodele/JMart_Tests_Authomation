package web.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.List;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class StoresPage {
    SelenideElement
            cityOfStores=$x("//div[@class='sc-kDTinF fNpZc']");

    ElementsCollection
            storeNameElements=$$x("//h2[@class='sc-kDTinF dxwvzv']");

    @Step("Проверяем смену на выбранный город на странице \"Продукты\"")
    public StoresPage checkSelectedCity(String city){
        cityOfStores.shouldHave(text(city));
        return this;
    }

    @Step("Проверяем отображение продуктовых магазинов")
    public void checkStoresNames(List<String> storeNames){
        storeNameElements.shouldHave(CollectionCondition.texts(storeNames));
    }
}
