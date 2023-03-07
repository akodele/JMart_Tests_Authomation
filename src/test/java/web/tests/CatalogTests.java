package web.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.TestBase;

import static com.codeborne.selenide.Selenide.open;

public class CatalogTests extends TestBase{

    @Tag("web_test")
    @Feature("Отображение главных категории на странице каталога")
    @Test
    @DisplayName("Проверка наличия названия типов предоставляемых продуктов и главных категории")
    public void checkMainCategories() {
        open("/");
        mainPage.
                selectCity("Алматы").
                selectCatalog();
        catalogPage.
                checkTypesOfProducts().
                checkCountOfMainCategories();

    }
}
