package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.gmail.com");
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
        driver.quit();
    }

    public void openNewTab(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }
    public void goToInteriaLoginPage(ArrayList<String> tabs){
        driver.switchTo().window(tabs.get(1));
        driver.get("http://poczta.interia.pl");
    }
}
