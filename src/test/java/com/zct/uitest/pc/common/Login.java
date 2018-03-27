package com.zct.uitest.pc.common;

import com.zct.uitest.pc.page.LoginPage;
import com.zct.uitest.pc.page.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.zct.uitest.pc.utils.Config;
import com.zct.uitest.pc.framework.DriverFactory;

//import static org.junit.Assert.assertEquals;

/**
 * @description: 登录功能类，其他需要先登录才能测试的功能，都需要先调用此类，可以不同的用户名密码
 */
public class Login {
    private String account;
    private String pwd;

    public Login(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }

    public MainPage loginWithMe() {
        WebDriver driver = new DriverFactory().getDriver("chrome");
        Config config = new Config("E:\\idea\\intert\\src\\test\\resources\\config.properties");
        String baseUrl = config.getValue("base_url");
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginAs(account, pwd);
        // 通过判断是否有“中财人力资源管理系统”，来判断登录是否成功
        String str = mainPage.getLogoText();
        if (str.equals("中财人力资源管理系统")) {
            return mainPage;
        } else {
            return null;
        }
    }
}
