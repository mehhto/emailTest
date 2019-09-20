package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InteriaMainPage extends PageBase {

    @FindBy(xpath = "//div[@class='msglist-item-link']")
    private List<WebElement> messageList;

    @FindBy(xpath = "//a[@data-track-click = 'folderDraft']")
    private WebElement draftsIcon;

    public InteriaMainPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(this.driver, this);
    }

    public InteriaDrafts clickDraftsIcon(){
        draftsIcon.click();
        return new InteriaDrafts(driver);
    }

}
