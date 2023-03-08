package mobile.tests;

import mobile.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
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
}
