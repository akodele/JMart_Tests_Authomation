package mobile.tests;

import mobile.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class JusanTests extends TestBase {
    @Test
    @Tag("mobile_test")
    @DisplayName("Проверка отображения кнопки перехода на страницу Jusan Магазина на главной странице приложения Jusan")
    void checkJmartOnMainPageTest() {
        //back();
        step("Закрыть всплывающее окно", () -> {
            $(id("kz.tsb.app24.debug:id/closeButton")).click();
        });
//        step("Выбрать русский язык приложения", () -> {
//            $(id("kz.tsb.app24.debug:id/ruButton")).click();
//        });
        step("Проверить отображение Jusan Магазина на главной странице", () -> {
            $$(id("kz.tsb.app24.debug:id/nameTextView")).get(5).shouldHave(text("магазин"));
        });

    }

    @Test
    @Tag("mobile_test")
    @DisplayName("Проверка поиска на главной странице приложения Jusan")
    void checkJmartSearchOnMainPageTest() {
        step("Закрыть всплывающее окно", () -> {
            $(id("kz.tsb.app24.debug:id/closeButton")).click();
        });
        step("Проверить отображение Поиск в Jusan в поле поиска", () -> {
            $(id("kz.tsb.app24.debug:id/homeSearchTextView")).shouldHave(text("Поиск в Jusan")).click();
        });
        step("Ввести в поле Поиск слово Apple", () -> {
            $(id("kz.tsb.app24.debug:id/searchEditText")).sendKeys("Apple");
        });
        step("Проверить отображение результатов поиска в Jusan Магазине, помимо результатов в банке", () -> {
            $$(id("kz.tsb.app24.debug:id/nameTextView")).last().shouldHave(text("Jusan Магазин"));
        });
    }

    @Test
    @Tag("mobile_test")
    @DisplayName("Проверка открытия главной страницы приложения Jusan Магазин")
    void checkOpeningJmartMainPageTest() {
        step("Закрыть всплывающее окно", () -> {
            $(id("kz.tsb.app24.debug:id/closeButton")).click();
        });
        step("Нажать на кнопку \"магазин\" на главной странице приложения Jusan", () -> {
            $$(className("android.widget.FrameLayout")).get(1).click();
        });
        step("Проверить отображение для дальнейших действии по выбору города", () -> {
            $$(id("kz.tsb.app24.debug:id/titleTextView")).findBy(text("Укажите город доставки для просмотра актуальных предложений")).shouldBe(visible);
        });
    }
}
