package web.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$$x;

public class CatalogPage {
    String[] types={"Товары","Услуги","Маркеты"};

    ElementsCollection
            productTypes = $$x("//h2[contains(@class,'kqOJzu')]"),
            productTypesBlocks=$$x("//div[contains(@class,'kBihnx')]");

    @Step("Проверяем наличие названия 3 предоставляемых видов продуктов")
    public CatalogPage checkTypesOfProducts(){
        for (int i=0;i<3;i++){
            productTypes.get(i).shouldHave(Condition.text(types[i]));
        }
        return this;
    }

    @Step("Проверяем наличие определенного количества главных категории на странице каталога")
    public CatalogPage checkCountOfMainCategories(){
        productTypesBlocks.shouldHave(sizeNotEqual(0), sizeGreaterThanOrEqual(1), size(38));
        return this;
    }

}
