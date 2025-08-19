package automationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeSuite
    public void setUpSuite() {
        if (driver == null) {  // chỉ tạo nếu chưa có
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("🌟 Khởi tạo Chrome window cho cả suite");
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("❌ Đóng Chrome window sau khi cả suite chạy xong");
        }
    }
}