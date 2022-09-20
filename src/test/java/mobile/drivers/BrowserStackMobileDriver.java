package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import mobile.config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackMobileDriver implements WebDriverProvider {
    public static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", driverConfig.getLogin());
        mutableCapabilities.setCapability("browserstack.key", driverConfig.getPassword());
        mutableCapabilities.setCapability("app", driverConfig.getApp());
        mutableCapabilities.setCapability("device", driverConfig.getDeviceName());
        mutableCapabilities.setCapability("os_version", driverConfig.getOsVersion());
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(driverConfig.getHubUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
