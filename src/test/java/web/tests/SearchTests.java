package web.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import web.TestBase;

import static com.codeborne.selenide.Selenide.open;

public class SearchTests extends TestBase{

    @Tag("web_test")
    @Feature("Вывод результатов поиска и возможность добавления в корзину товара-результата")
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
    @Feature("Вывод результатов поиска и возможность добавления в корзину товара-результата")
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

    @Tag("web_test")
    @Feature("Вывод результатов поиска и возможность добавления в корзину товара-результата")
    @ValueSource(strings = {"Apple","Samsung"})
    @ParameterizedTest(name = "Проверка наличия офферов у первого товара-результата поиска")
    public void checkOffersOfFirstProduct(String searchText) {
        open("/");
        mainPage.
                selectCity("Алматы").
                search(searchText);
        productsListingPage.
                selectAddToCart().
                clickOnFirstProductOnListing().
                firstProductOffersCheck();
    }
}
