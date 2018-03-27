package com.zct.uitest.pc.page;

import com.zct.uitest.pc.utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(WebElement clickableElement) {
        BaseUtils.sleep(1000L);
        clickableElement.click();
        BaseUtils.sleep(2000L);
    }
    protected WebElement getElement(By by) {
        return BaseUtils.getElement(driver, by, 5);
    }
}
