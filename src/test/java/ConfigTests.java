import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static com.codeborne.selenide.Configuration.*;


public class ConfigTests {
    WebDriver driver;
    @BeforeSuite(groups = {("FrontEnd, BackEnd")})
    public void ConfigTests() {
        timeout = 20000;
        screenshots=true;
        savePageSource=false;

    }

    @BeforeMethod(groups = {("FrontEnd, BackEnd")})
    public void webDriverConfig(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterMethod(groups = {("FrontEnd, BackEnd")})
    public void afterSuite() {
        Selenide.closeWebDriver();
    }

}