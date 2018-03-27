package com.zct.uitest.pc.framework;

import com.zct.uitest.pc.utils.Config;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PengWebDriverListener implements WebDriverEventListener {
    private static Logger logger = Logger.getLogger(PengWebDriverListener.class);

    public void beforeAlertAccept(WebDriver var1) {}

    public void afterAlertAccept(WebDriver var1) {}

    public void afterAlertDismiss(WebDriver var1) {}

    public void beforeAlertDismiss(WebDriver var1) {}

    public void beforeNavigateTo(String var1, WebDriver var2) {}

    public void afterNavigateTo(String var1, WebDriver var2) {}

    public void beforeNavigateBack(WebDriver var1) {}

    public void afterNavigateBack(WebDriver var1) {}

    public void beforeNavigateForward(WebDriver var1) {}

    public void afterNavigateForward(WebDriver var1) {}

    public void beforeNavigateRefresh(WebDriver var1) {}

    public void afterNavigateRefresh(WebDriver var1) {}

    public void beforeFindBy(By var1, WebElement var2, WebDriver var3) {}

    public void afterFindBy(By var1, WebElement var2, WebDriver var3) {}

    public void beforeClickOn(WebElement var1, WebDriver var2) {}

    public void afterClickOn(WebElement var1, WebDriver var2) {}

    public void beforeChangeValueOf(WebElement var1, WebDriver var2, CharSequence[] var3) {}

    public void afterChangeValueOf(WebElement var1, WebDriver var2, CharSequence[] var3) {}

    public void beforeScript(String var1, WebDriver var2) {}

    public void afterScript(String var1, WebDriver var2) {}

    public void onException(Throwable throwable, WebDriver driver) {
        Config config = new Config("E:\\idea\\intert\\src\\test\\resources\\config.properties");
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String dateString = format.format(new Date());
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            File screenShot = new File(config.getValue("screenshot_dir") + dateString+".png");
                FileUtils.copyFile(srcFile, screenShot);
        }catch(Exception e) {
            e.printStackTrace();
        }

        logger.error("发生异常,原因是: "+throwable.getMessage());
        logger.info("截图保存在: "+config.getValue("screenshot_dir")+dateString+".png");
    }
}
