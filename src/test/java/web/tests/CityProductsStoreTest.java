package web.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import web.TestBase;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class CityProductsStoreTest extends TestBase {
    @Tag("web_test")
    @ValueSource(strings = {"Алматы","Астана"})
    @ParameterizedTest(name = "Проверка отображения выбранного города {0} на странице продуктовых магазинов маркетплейса JMart")

    public void selectedCityOnStorePageTest(String city) {
        open("/");
        mainPage.
                selectCity(city).
                mainMenusSelectThird();
        storesPage.
                checkSelectedCity(city);

    }


    static Stream<Arguments> storesOfCityTest() {
        return Stream.of(
                Arguments.of("Алматы", List.of("A-Store", "Carefood", "Small",
                        "Садыхан", "Europharma", "Flamingo",
                        "Овощной", "Mясной Boszhan","Дәмді ет", "Riza Herb",
                        "Tvoy.kz", "Зоомагазин ZOOKORM",
                        "Зоомагазин Zoo KING", "Зоомагазин Котопёс", "Epicure",
                        "Moonyalmaty", "ALCOMARKET", "Аптека SMART",
                        "Ароматный мир", "Бады Alhadaya", "Бады DoroMarine",
                        "Elitalco", "Кондитерская Caramel", "Mfood.kz",
                        "My Mart", "Шымбулак Water", "Продукция Цесна",
                        "Магазин XO","Accio Store")),
                Arguments.of("Астана", List.of("Астыкжан", "INTERFOOD ASTANA", "JIDEK.KZ",
                        "Зоомагазин KazZooMir", "Europharma",
                        "Мясная лавка №1","Tvoy.kz (Астана)","Accio Store"))
        );
    }
    @Tag("web_test")
    @MethodSource
    @ParameterizedTest(name = "Проверка наличия продуктовых магазинов из списка {1} на сайте JMart в городе {0}")

    public void storesOfCityTest(String city, List<String> storeNames) {
        open("/");
        mainPage.
                selectCity(city).
                mainMenusSelectThird();
        storesPage.
                checkSelectedCity(city).
                checkStoresNames(storeNames);

    }
    @Tag("web_test")
    @CsvFileSource(resources = "/cities.csv",delimiter = ';')
    @ParameterizedTest(name = "Проверка отображения выбранного города на главной странице маркетплейса JMart")

    public void selectedCityOnMainPageTest(String city) {
        open("/");
        mainPage.
                selectCity(city).
                checkCityNameOnMainPage(city);

    }
}
