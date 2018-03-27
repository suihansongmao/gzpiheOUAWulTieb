package com.zct.uitest.pc.page;

import com.zct.uitest.pc.framework.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private ObjectMap objectMap;

    private WebElement pwdText;
    private WebElement accountText;
    private WebElement loginBtn;
    private WebElement forgetPwd;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        objectMap = new ObjectMap("E:\\idea\\intert\\src\\test\\resources\\by\\loginPage.properties");
        initViews();
    }

    private void initViews() {
        accountText = super.getElement(objectMap.getLocator("accountText"));
        pwdText = super.getElement(objectMap.getLocator("pwdText"));
        loginBtn = super.getElement(objectMap.getLocator("loginBtn"));
        forgetPwd = super.getElement(objectMap.getLocator("forgetPwd"));
    }

    public String getForgetPwdText() {
        return forgetPwd.getText();
    }

    public void typeAccount(String account) {
        accountText.sendKeys(account);
    }

    public void typePwd(String pwd) {
        pwdText.sendKeys(pwd);
    }

    public MainPage submit() {
        super.click(loginBtn);
        return new MainPage(driver);
    }

    public LoginPage loginError() {
        super.click(loginBtn);
        return new LoginPage(driver);
    }

    public MainPage loginAs(String account, String pwd) {
        typeAccount(account);
        typePwd(pwd);
        return submit();
    }
}
