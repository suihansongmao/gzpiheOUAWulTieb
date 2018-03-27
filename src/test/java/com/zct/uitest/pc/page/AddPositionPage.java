package com.zct.uitest.pc.page;

import com.zct.uitest.pc.utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddPositionPage {
    private WebDriver driver;

    private WebElement breadcrumbText;

    public AddPositionPage(WebDriver driver) {
        this.driver = driver;
        initViews();
    }

    private void initViews() {
        breadcrumbText = BaseUtils.getElement(driver, By.cssSelector("#breadcrumb > div > span:nth-child(3) > span"), 5);
    }

    public String getBreadcrumbText() {
        return breadcrumbText.getText();
    }
}
