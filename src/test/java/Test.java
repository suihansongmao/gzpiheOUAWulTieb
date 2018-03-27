import com.zct.uitest.pc.framework.DriverFactory;
import com.zct.uitest.pc.utils.BaseUtils;
import com.zct.uitest.pc.utils.Config;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test {
    public static void main(String args[]) {
        WebDriver driver = new DriverFactory().getDriver("chrome");
        Config config = new Config("E:\\idea\\intert\\src\\test\\resources\\config.properties");
        String baseUrl = config.getValue("base_url");
        driver.get(baseUrl);
        BaseUtils.isElementVisible(driver, By.xpath("//input[@type='text']"), 5);
    }
}
