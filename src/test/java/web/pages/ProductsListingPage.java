package web.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ProductsListingPage {
    ElementsCollection
            productsList = $$x("//div[contains(@class,'jMpxUt lnQNbf')]/div[contains(@class,'lfkMQL')]/a"),
            productsAddToCartButtons = $$x("//button[contains(@class,'cxEWlG')]"),
            categoriesList = $$x("//ul/li/div[contains(@class,'JAnzX')]"),
            filtersList  = $$x("//div[contains(@class,'hFtCop jnKiqT')]"),
            products = $$x("//div[contains(@class,'jMpxUt lnQNbf')]"),
            productOffers=$$x("//div[contains(@class,'fFpuqa')]");

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
        products.get(0).scrollTo();
        sleep(5000);                      //Duration не подошел, после click не открывается модальное окно без sleep
        productsAddToCartButtons.get(0).click(ClickOptions.usingJavaScript());
        return this;
    }

    @Step("Нажимаем на карточку товара")
    public ProductsListingPage clickOnFirstProductOnListing() {
        productsList.get(0).click(ClickOptions.usingJavaScript());           //Так как с простым click выходило Element is not clickable at point ...
        return this;
    }

    @Step("Проверка наличия офферов в первом товаре листинга")
    public ProductsListingPage firstProductOffersCheck() {
        productOffers.
                shouldHave(sizeNotEqual(0), sizeGreaterThanOrEqual(1));
        return this;
    }
}
