package mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties"
})
public interface DriverConfig extends Config {
    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("url")
    String getUrl();

    @Key("videoUrl")
    String getVideoUrl();

    @Key("deviceName")
    String getDeviceName();

    @Key("osVersion")
    String getOsVersion();

    @Key("app")
    String getApp();

    @Key("driverName")
    String getDriverName();

    @Key("hubUrl")
    String getHubUrl();

    @Key("platformName")
    String getPlatformName();

    @Key("browser")
    String getBrowser();

    @Key("version")
    String getVersion();

    @Key("windowSize")
    String getWindowSize();
}
