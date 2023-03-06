package mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.drivers.BrowserstackDriver;
import mobile.drivers.EmulatorDriver;
import mobile.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
//        switch (System.getProperty("mobile")) {
//            case "browserstack":
//                Configuration.browser = BrowserstackDriver.class.getName();
//                break;
//            case "emulator":
//                Configuration.browser = EmulatorDriver.class.getName();
//                break;
//        }
        Configuration.browser = EmulatorDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        //String sessionId = sessionId().toString();
        Attach.pageSource();
        closeWebDriver();
        //if (!System.getProperty("mobile").equals("emulator")) Attach.addVideo(sessionId);
    }
}
