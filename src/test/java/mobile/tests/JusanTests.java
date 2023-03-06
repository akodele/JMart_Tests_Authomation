package mobile.tests;

import mobile.TestBase;
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
    void goToTheArticleTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenium");
        });
        step("Click on the first article", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
        });
        step("Check text on article", () -> {
            $(id("pcs-edit-section-title-description")).shouldHave(text("Chemical element, symbol Se and atomic number 34"));
        });

    }
}
