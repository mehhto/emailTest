package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GmailMainPage extends PageBase {

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement newMessageButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement recipientField;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
    private WebElement messageArea;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//div[@class='J-J5-Ji']/div[2]/span/span[text()='Wiadomość została wysłana.']")
    private WebElement popUpMessageSent;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji nu T-I-ax7 L3']")
    private WebElement refreshButton;

    @FindBy(xpath = "//tbody/tr[contains(@class,'zA')]")
    private List<WebElement> listOfMails;

    public GmailMainPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 10);
        PageFactory.initElements(this.driver, this);
    }

    public GmailMainPage clickNewMessageButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newMessageButton));
        newMessageButton.click();
        logger.info("Clicked New Message Button");
        return this;
    }

    public GmailMainPage typeRecipientName(String recipientName) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recipientField));
        recipientField.sendKeys(recipientName);
        logger.info("Typed recipient name");
        return this;
    }

    public GmailMainPage typeMessageSubject(String subject) {
        subjectField.sendKeys(subject);
        logger.info("Typed subject of e-mail");
        return this;
    }

    public GmailMainPage typeMessage(String message) {
        messageArea.sendKeys(message);
        logger.info("Typed message");
        return this;
    }

    public GmailMainPage sendMessage() {
        sendMessageButton.click();
        logger.info("Clicked send message button");
        return this;
    }

    public String getMessageSentConfirmation() {
        String messageSentConfirmation = popUpMessageSent.getText();
        logger.info("Got message sent confirmation");
        return messageSentConfirmation;
    }

    public void clickRefereshButton() {
        refreshButton.click();
        logger.info("Clicked refresh button");
    }

    public String getMessageText() {
        WebElement message = listOfMails.get(0);
        WebElement messageTextView = message.findElement(By.xpath("//div[@class='xT']//span[@class='bqe']"));
        logger.info("Getting message text");
        return messageTextView.getText();
    }

}
