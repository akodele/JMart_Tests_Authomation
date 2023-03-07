package mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/emulator.properties"
})
public interface MobileConfig extends Config{
    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("browserstackURL")
    String browserstackUrl();

    @Key("appURL")
    String appUrl();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();

    @Key("mobile.version")
    String mobileVersion();

    @Key("mobile.device")
    String mobileDevice();

    @Key("mobile.app.path")
    String mobileAppPath();

    @Key("mobile.platformName")
    String mobilePlatformName();

    @Key("mobile.appPackage")
    String mobileAppPackage();

    @Key("mobile.appActivity")
    String mobileAppActivity();

    @Key("mobile.url")
    String mobileUrl();
}
