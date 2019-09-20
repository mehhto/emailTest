package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InteriaDrafts extends PageBase {

    @FindBy(xpath = "//a[@data-track-click = 'folderDraft']")
    private WebElement draftsIcon;

    @FindBy(xpath = "//a[@data-track-click = 'mainNewMes']")
    private WebElement newMessageIcon;

    @FindBy(xpath = "//label[@class='msglist-toolbar-checkbox']")
    private WebElement selectAllCheckbox;

    public InteriaDrafts(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 10);
        PageFactory.initElements(this.driver, this);
    }

    private void waitUntilVisibility(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitUntilClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void waitUntilInvisibility(WebElement element) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }

    private void makeDraft() {
        newMessageIcon.click();
        WebElement subjectField = driver.findElement(By.xpath("//input[@placeholder = 'Temat:']"));
        waitUntilClickable(subjectField);
        subjectField.sendKeys("xxxxxx");
        WebElement closeButton = driver.findElement(By.xpath("//div[@class = 'dialog-header-button icon-close']"));
        closeButton.click();
    }

    private void cleanDrafts() {
        waitUntilVisibility(selectAllCheckbox);
        selectAllCheckbox.click();
        WebElement deleteIcon = driver.findElement(By.xpath("//div[@class='msglist-action-bar-button']"));
        waitUntilClickable(deleteIcon);
        deleteIcon.click();
    }

    private boolean isDraftsEmpty() {
        String draftsTitle = driver.findElement(By.xpath("//a[@data-track-click = 'folderDraft']")).getAttribute("title");
        return draftsTitle.equals("Robocze (0)");
    }

    public boolean checkIfDraftsWork() {
        if (isDraftsEmpty()) {
            logger.info("Drafts are empty");
            makeDraft();
            WebElement notification = driver.findElement(By.xpath("//div[@class='notification-message']/span"));
            waitUntilVisibility(notification);
            logger.info("Draft has been made");
            return (!isDraftsEmpty());
        } else {
            logger.info("Drafts are not empty");
            cleanDrafts();
            WebElement notification = driver.findElement(By.xpath("//div[@class='notification-message']/span"));
            waitUntilVisibility(notification);
            logger.info("Drafts were deleted");
            if (isDraftsEmpty()) {
                logger.info("Drafts are empty");
                waitUntilInvisibility(notification);
                makeDraft();
                notification = driver.findElement(By.xpath("//div[@class='notification-message']/span"));
                waitUntilVisibility(notification);
                logger.info("Draft has been made");
                return !isDraftsEmpty();
            }
        }
        return false;
    }

}
