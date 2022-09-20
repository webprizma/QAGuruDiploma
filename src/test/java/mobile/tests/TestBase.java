package mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.config.DriverConfig;
import mobile.drivers.BrowserStackMobileDriver;
import mobile.drivers.EmulationMobileDriver;
import mobile.drivers.RealMobileDriver;
import mobile.drivers.SelenoidMobileDriver;
import mobile.helpers.Attach;
import mobile.screens.LocaleSelectScreen;
import mobile.screens.MainScreen;
import mobile.screens.SearchScreen;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static mobile.helpers.Attach.sessionId;

public class TestBase {
    LocaleSelectScreen localeSelectScreen = new LocaleSelectScreen();
    MainScreen mainScreen = new MainScreen();
    SearchScreen searchScreen = new SearchScreen();

    public static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

    @BeforeAll
    public static void beforeAll() {
        if (driverConfig.getDriverName().equals("browserstack")) {
            browser = BrowserStackMobileDriver.class.getName();
        } else if (driverConfig.getDriverName().equals("emulation")) {
            browser = EmulationMobileDriver.class.getName();
        } else if (driverConfig.getDriverName().equals("real")) {
            browser = RealMobileDriver.class.getName();
        } else if (driverConfig.getDriverName().equals("selenoid")) {
            browser = SelenoidMobileDriver.class.getName();
        } else {
            throw new RuntimeException("No such driver");
        }

        Configuration.browserSize = null;
    }

    @BeforeEach
    void beforeEach() {
        addListener("AllureSelenide", new AllureSelenide());

        open();
    }

    @AfterEach
    void afterEach() {
        if (driverConfig.getDriverName().equals("browserstack")) {
            String sessionId = sessionId();

            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();

            step("Close driver", Selenide::closeWebDriver);

            Attach.video(sessionId);
        } else {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();

            step("Close driver", Selenide::closeWebDriver);
        }
    }
}
