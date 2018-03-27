package com.zct.uitest.pc.testcase;

import com.zct.uitest.pc.framework.DriverFactory;
import com.zct.uitest.pc.page.LoginPage;
import com.zct.uitest.pc.page.MainPage;
import com.zct.uitest.pc.utils.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    public BaseTest(String account, String pwd) {
        this.driver = new DriverFactory().getDriver("chrome");
        Config config = new Config("E:\\idea\\intert\\src\\test\\resources\\config.properties");
        String baseUrl = config.getValue("base_url");
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        mainPage = loginPage.loginAs(account, pwd);
    }
    @AfterTest
    protected void tearDown() {
        driver.quit();
    }
}
