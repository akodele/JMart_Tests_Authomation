package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import mobile.config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;

public class EmulatorDriver implements WebDriverProvider {
    static MobileConfig config = ConfigFactory.create(MobileConfig.class);

    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.mobileUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(config.mobilePlatformName())
                .setDeviceName(config.mobileDevice())
                .setPlatformVersion(config.mobileVersion())
                .setApp(getAppPath())
                .setAppPackage(config.mobileAppPackage())
                .setAppActivity(config.mobileAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath() {
        String appPath = config.mobileAppPath();
        File app = new File(appPath);
        return app.getAbsolutePath();
    }
}
