package com.zct.uitest.pc.page;

import com.zct.uitest.pc.framework.ObjectMap;
import com.zct.uitest.pc.utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PositionPage extends BasePage {
    private WebDriver driver;
    private ObjectMap objectMap;

    private WebElement addPositionBtn;
    private WebElement breadcrumbText;
    private WebElement searchBtn;
    // 搜索输入框
    private WebElement keyWord;
    private WebElement department;
    private WebElement status;
    private WebElement startTime;
    private WebElement endTime;
    // 3个状态
    private WebElement status1;
    private WebElement status2;
    private WebElement status3;
    public PositionPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        objectMap = new ObjectMap("E:\\idea\\intert\\src\\test\\resources\\by\\positionPage.properties");
        initViews();
    }

    private void initViews() {
        addPositionBtn = super.getElement(objectMap.getLocator("addPositionBtn"));
        breadcrumbText = super.getElement(objectMap.getLocator("breadcrumbText"));
        searchBtn = super.getElement(objectMap.getLocator("searchBtn"));

        keyWord = super.getElement(objectMap.getLocator("keyWord"));
    }

    public String getBreadcrumbText() {
        return breadcrumbText.getText();
    }
    public AddPositionPage clickAddPositionBtn() {
        super.click(addPositionBtn);
        return new AddPositionPage(driver);
    }
    public PositionPage clickSearchBtn() {
        super.click(searchBtn);
        return new PositionPage(driver);
    }
}
