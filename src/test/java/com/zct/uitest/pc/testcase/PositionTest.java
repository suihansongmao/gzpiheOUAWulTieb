package com.zct.uitest.pc.testcase;

import com.zct.uitest.pc.page.AddPositionPage;
import com.zct.uitest.pc.page.MainPage;
import com.zct.uitest.pc.page.PositionPage;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * 需求列表页面测试用例
 */

public class PositionTest extends BaseTest {
    protected WebDriver driver;
    private MainPage mainPage;
    private PositionPage positionPage;

    PositionTest() {
        super("admin", "123456");
        this.driver = super.driver;
        this.mainPage = super.mainPage;
    }
    /**
     * 用例1：点击新增需求按钮，能否正确跳转到新增需求页面
     * @throws Exception
     */
    @Test
    public void testPositionPage() {
        if (mainPage != null) {
            // 点击招聘管理
            mainPage.clickRecruit();
            // 点击职位
            positionPage = mainPage.clickPosition();
            // 点击新增需求
            AddPositionPage addPositionPage = positionPage.clickAddPositionBtn();
            // 判断是否成功跳转到了新增需求页面
            String str = addPositionPage.getBreadcrumbText();
            assertEquals(str, "职位新增", "跳转错误");
        }
    }
    @Test
    public void testSearchConditions() {

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
