package com.zct.uitest.pc.page.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {
    @FindBy (css = "#header > div.header-left.clearfix > span")
    @CacheLookup
    private WebElement titleText;

    @FindBy (css = "#header > div.header-right.clearfix > ul > li:nth-child(1) > div > span > a")
    @CacheLookup
    private WebElement accountBtn;

    @FindBy (css = "#dropdown-menu-3825 > li")
    @CacheLookup
    private WebElement pwdModifyBtn;

    @FindBy (css = "#header > div.header-right.clearfix > ul > li:nth-child(2) > div > a")
    @CacheLookup
    private WebElement roleText;

    @FindBy (css = "//*[@id='dropdown-menu-2225']/li")
    @CacheLookup
    private WebElement roleSwitchBtn;

    public FooterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void click() {}
}
