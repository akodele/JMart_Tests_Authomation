package web.drivers;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import web.config.WebConfig;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriver {
    static WebConfig webConfig =
            ConfigFactory.create(WebConfig.class, System.getProperties());

    public static void configuration() {
        Configuration.timeout=8000;
        Configuration.browser = webConfig.getBrowser();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.baseUrl = webConfig.getBaseUrl();
        if (webConfig.getIsRemote()) {
            Configuration.remote = webConfig.getRemoteUrl();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
}
