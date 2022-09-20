package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import mobile.config.DriverConfig;
import mobile.helpers.WildberriesApp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EmulationMobileDriver implements WebDriverProvider {

    public static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(driverConfig.getPlatformName());
        options.setDeviceName(driverConfig.getDeviceName());
        options.setPlatformVersion(driverConfig.getOsVersion());
        options.setApp(WildberriesApp.getApp().getAbsolutePath());
        options.setAppPackage(WildberriesApp.getAppPackage());
        options.setAppActivity(WildberriesApp.getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(driverConfig.getHubUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
