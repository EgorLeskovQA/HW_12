package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RandomFormPage;

import java.util.Map;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;

public class TestBase {
    private final RandomFormPage randomFormPage = new RandomFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = System.getProperty("remoteURL");
        //Configuration.holdBrowserOpen = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @BeforeEach
    void openPage() {
        step("Открываем форму", () -> {
            randomFormPage.openPage();
        });

        step("Удаляем баннеры", () -> {
            randomFormPage.removeBanner();
        });
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        if (!Objects.equals(Configuration.browser, "firefox")) {
            Attach.pageSource();
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
        closeWebDriver();
    }
}
