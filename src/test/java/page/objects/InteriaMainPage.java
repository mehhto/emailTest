package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InteriaMainPage {

    @FindBy(xpath = "//div[@class='msglist-item-link']")
    private List<WebElement> messageList;

    WebDriver driver;
    WebDriverWait webDriverWait;

    public InteriaMainPage(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(this.driver, this);
    }



}
