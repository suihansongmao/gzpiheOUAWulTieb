package com.zct.uitest.pc.framework;

import com.zct.uitest.pc.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver getDriver(String category) {
        Config config = new Config("E:\\idea\\intert\\src\\test\\resources\\config.properties");
        if (category.equals("chrome")) {
            String chromeDriver = config.getValue("chrome_driver");
            System.setProperty("webdriver.chrome.driver", chromeDriver);
            driver = new ChromeDriver();
        } else if (category.equals("firefox")) {
            String firefoxDriver = config.getValue("firefox_driver");
            System.setProperty("webdriver.geckodriver.driver", firefoxDriver);
            driver = new FirefoxDriver();
        } else if (category.equals("ie")) {
            String ieDriver = config.getValue("ie_driver");
            System.setProperty("webdriver.ie.driver", ieDriver);
            driver = new InternetExplorerDriver();
        }
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new PengWebDriverListener());
        eventFiringWebDriver.manage().window().maximize();
        return eventFiringWebDriver;
    }
}
