package com.zct.uitest.pc.page;

import com.zct.uitest.pc.framework.ObjectMap;
import com.zct.uitest.pc.utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    private WebDriver driver;
    private ObjectMap objectMap;

    private WebElement logoTextElement;
    private WebElement recruitMenuElement;
    private WebElement positionMenuElement;

    MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        objectMap = new ObjectMap("E:\\idea\\intert\\src\\test\\resources\\by\\mainPage.properties");
        initViews();
    }

    private void initViews() {
        if (BaseUtils.isPageLoaded(driver, 5)) {
            logoTextElement = super.getElement(objectMap.getLocator("logoTextElement"));
            recruitMenuElement = super.getElement(objectMap.getLocator("recruitMenuElement"));
            positionMenuElement = super.getElement(objectMap.getLocator("positionMenuElement"));
        }
    }

    public String getLogoText() {
        return logoTextElement.getText();
    }
    public void clickRecruit() {
        super.click(recruitMenuElement);
    }
    public PositionPage clickPosition() {
        super.click(positionMenuElement);
        return new PositionPage(driver);
    }
}
