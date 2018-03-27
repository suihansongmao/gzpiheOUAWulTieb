package com.zct.uitest.pc.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;

/**
 * 工具类
 */
public class BaseUtils {
    /**
     * 判断页面是否加载完毕
     * @return
     */
    public static boolean isPageLoaded(WebDriver driver, int timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        Boolean flag = false;
        try {
            flag = wait.until((new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState === 'complete'");
                }
            }));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    /**
     * 将所有获取元素的方法封装起来，对外提供一个统一的方法
     */
    public static WebElement getElement(WebDriver driver, final By by, int timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        WebElement webElement = null;
        try {
            webElement = wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            });
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return webElement;
    }

    /**
     * 判断元素是否可见
     */
    public static void isElementVisible(WebDriver driver, final By by, int timeOutInSecond) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSecond);
        Boolean flag;
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(Long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * 清空输入框，输入字符串
     */
    public void clearAndTypeString() {

    }
}
