package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPageGmail extends PageBase{

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement passwordNextButton;

    public PasswordPageGmail(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 10);
        PageFactory.initElements(this.driver, this);
    }

    public GmailMainPage typeAndSubmitPassword(String password) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
        logger.info("Typed password");
        passwordNextButton.click();
        logger.info("Clicked Next button");
        return new GmailMainPage(driver);
    }


}
