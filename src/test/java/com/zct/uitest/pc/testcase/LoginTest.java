package com.zct.uitest.pc.testcase;

import com.zct.uitest.pc.page.LoginPage;
import com.zct.uitest.pc.page.MainPage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.*;
import com.zct.uitest.pc.utils.Config;
import com.zct.uitest.pc.framework.DriverFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private String baseUrl;

    @BeforeTest
    public void setUp() {
        Config config = new Config("E:\\idea\\intert\\src\\test\\resources\\config.properties");
        baseUrl = config.getValue("base_url");
    }

    // 参数化，测试不同的情况
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"admin", "123456", "中财人力资源管理系统"},
//                {"admin", "", "找回密码"}
//                {"", "123456", "找回密码"},
//                {"", "", "找回密码"}
        };
    }

    /**
     *
     */
    @Test(dataProvider = "loginData")
    public void testLogin(String account, String pwd, String expected) {
        driver = new DriverFactory().getDriver("chrome");
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        loginPage.typeAccount(account);
        loginPage.typePwd(pwd);
        if (expected.equals("中财人力资源管理系统")) {
            MainPage mainPage = loginPage.submit();
            String str = mainPage.getLogoText();
            assertEquals(str, expected, "执行失败，应该跳到首页");
        }
        if (expected.equals("找回密码")) {
            loginPage = loginPage.loginError();
            String str = loginPage.getForgetPwdText();
            assertEquals(str, expected, "执行失败，应该留在登录页面");
        }
        driver.quit();
    }
}
