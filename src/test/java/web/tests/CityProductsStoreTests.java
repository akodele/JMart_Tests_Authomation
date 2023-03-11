package web.tests;

import io.qameta.allure.Feature;
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

public class CityProductsStoreTests extends TestBase {
    @Tag("web_test")
    @Feature("Возможность выбора города и привязка магазинов к определенному городу")
    @ValueSource(strings = {"Алматы","Астана"})
    @ParameterizedTest(name = "Проверка отображения выбранного города {0} на странице продуктовых магазинов маркетплейса JMart")
    public void checkSelectedCityOnStorePage(String city) {
        open("/");
        mainPage.
                selectCity(city).
                checkCityNameOnMainPage(city).
                mainMenusSelectThird();
        storesPage.
                checkSelectedCity(city);

    }


    static Stream<Arguments> checkStoresOfCity() {
        return Stream.of(
                Arguments.of("Алматы", List.of("A-Store", "Carefood", "Садыхан",
                        "Europharma", "Flamingo", "Овощной",
                        "Мясной Boszhan","Дәмді ет", "Riza Herb",
                        "Tvoy.kz", "Зоомагазин ZOOKORM",
                        "Зоомагазин Zoo KING", "Зоомагазин Котопёс", "Epicure",
                        "Moonyalmaty", "Аптека SMART",
                        "Ароматный мир", "Бады Alhadaya", "Бады DoroMarine",
                        "Elitalco", "Кондитерская Caramel", "Mfood.kz",
                        "Шымбулак Water", "Продукция Цесна",
                        "Магазин XO","Accio Store","SYILA",
                        "TALHIZ","Аптека Фатима Фарм"
                )),
                Arguments.of("Астана", List.of("Астыкжан", "INTERFOOD ASTANA", "JIDEK.KZ",
                        "Europharma", "Мясная лавка №1", "Tvoy.kz (Астана)",
                        "Accio Store","2.Детский магазин ВebekAstana"))
        );
    }
    @Tag("web_test")
    @Feature("Возможность выбора города и привязка магазинов к определенному городу")
    @MethodSource
    @ParameterizedTest(name = "Проверка наличия продуктовых магазинов из списка {1} на сайте JMart в городе {0}")

    public void checkStoresOfCity(String city, List<String> storeNames) {
        open("/");
        mainPage.
                selectCity(city).
                mainMenusSelectThird();
        storesPage.
                checkSelectedCity(city).
                checkStoresNames(storeNames);

    }

    @Tag("web_test")
    @Feature("Возможность выбора города и привязка магазинов к определенному городу")
    @CsvFileSource(resources = "/cities.csv",delimiter = ';')
    @ParameterizedTest(name = "Проверка отображения выбранного города на главной странице маркетплейса JMart")

    public void checkSelectedCityOnMainPage(String city) {
        open("/");
        mainPage.
                selectCity(city).
                checkCityNameOnMainPage(city);

    }
}
