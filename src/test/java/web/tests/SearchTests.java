package web.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import web.TestBase;

import static com.codeborne.selenide.Selenide.open;

public class SearchTests extends TestBase{

    @Tag("web_test")
    @ValueSource(strings = {"Apple","Samsung"})
    @ParameterizedTest(name = "Проверка результатов поиска по тексту {0}")
    public void search(String searchText) {
        open("/");
        mainPage.
                selectCity("Алматы").
                search(searchText);
        productsListingPage.
                categoriesListCheck().
                filtersListCheck().
                productsListCheck();

    }

    @Tag("web_test")
    @ValueSource(strings = {"Apple","Samsung"})
    @ParameterizedTest(name = "Проверка открытия модального окна с QR для перехода в приложение для первого товара-результата поиска")
    public void checkOpeningQRModalOnFirstProduct(String searchText) {
        open("/");
        mainPage.
                selectCity("Алматы").
                search(searchText);
        productsListingPage.
                selectAddToCart();
        qrModal.
                qrTitleShouldBeVisible();
    }
}
