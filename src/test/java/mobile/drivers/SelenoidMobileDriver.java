package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import mobile.config.DriverConfig;
import mobile.helpers.WildberriesApp;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SelenoidMobileDriver implements WebDriverProvider {

    public static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        DesiredCapabilities options = new DesiredCapabilities();
        options.setCapability("browserName", driverConfig.getDeviceName());
        options.setCapability("browserVersion", driverConfig.getVersion());
        options.setCapability("app", WildberriesApp.getApp().getAbsolutePath());
        options.setCapability("appPackage", WildberriesApp.getAppPackage());
        options.setCapability("appActivity", WildberriesApp.getAppActivity());
        options.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        return new RemoteWebDriver(getSelenoidHubUrl(), options);
    }

    public static URL getSelenoidHubUrl() {
        try {
            return new URL(driverConfig.getHubUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
