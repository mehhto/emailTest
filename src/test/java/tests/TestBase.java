package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;


    @BeforeClass
    public void setUp() {
        String URLAddress = chooseProperURL(getClass().getSimpleName());
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(URLAddress);
    }

    @AfterClass
    public void cleanUp() {
        driver.close();
        driver.quit();
    }

    private String chooseProperURL(String testName) {
        switch (testName) {
            case "DraftsTest":
                return "http://www.poczta.interia.pl";
            case "SendAndReceiveEmailTest":
                return "http://www.gmail.com";
            default:
                return "http://www.google.pl";
        }
    }
}
