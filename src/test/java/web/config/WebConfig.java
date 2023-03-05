package web.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:web/${env}.properties"
})
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("baseUrl")
    @DefaultValue("https://jmart.kz")
    String getBaseUrl();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean getIsRemote();

    @Key("remoteUrl")
    String getRemoteUrl();

}
