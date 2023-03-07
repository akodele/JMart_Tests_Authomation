package web.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;

public class ProductsListingPage {
    ElementsCollection
            productsList = $$x("//div[contains(@class,'jMpxUt lnQNbf')]"),
            categoriesList = $$x("//ul/li/div[contains(@class,'JAnzX')]"),
            filtersList  = $$x("//div[contains(@class,'hFtCop jnKiqT')]");

    @Step("Проверка наличия категории в листинге")
    public ProductsListingPage categoriesListCheck() {
        categoriesList.
                shouldHave(sizeNotEqual(0), sizeGreaterThanOrEqual(1));
        return this;
    }

    @Step("Проверка наличия фильтров в листинге")
    public ProductsListingPage filtersListCheck() {
        filtersList.
                shouldHave(sizeNotEqual(0), sizeGreaterThanOrEqual(2));
        return this;
    }

    @Step("Проверка наличия товаров в листинге")
    public ProductsListingPage productsListCheck() {
        productsList.
                shouldHave(sizeNotEqual(0), sizeGreaterThanOrEqual(1));
        return this;
    }

    @Step("Нажимаем на кнопку \"В корзину\"")
    public ProductsListingPage selectAddToCart() {
        productsList.first().$x("//div[contains(@class,'cxEWlG')]");
        return this;
    }
}
