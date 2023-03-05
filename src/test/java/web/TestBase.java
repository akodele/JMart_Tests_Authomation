package web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import web.drivers.WebDriver;
import web.helpers.Attach;
import web.pages.MainPage;
import web.pages.StoresPage;

public class TestBase {
    public MainPage mainPage=new MainPage();
    public StoresPage storesPage=new StoresPage();
    @BeforeAll
    static void beforeAll() {
        System.getProperty("env");
        WebDriver.configuration();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
