package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InteriaMainPage {

    @FindBy(xpath = "//div[@class='msglist-item-link']")
    private List<WebElement> messageList;



}
