import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.*;

public class ConfigTests {
    WebDriver driver;
    @BeforeSuite
    public void ConfigTests() {
        timeout = 20000;
        screenshots=true;
        savePageSource=false;

    }

    @BeforeSuite
    public void webDriverConfig(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterSuite
    public void afterSuite() {
        Selenide.closeWebDriver();
    }

}