package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageInteria extends PageBase {

    @FindBy(xpath = "//button[@class='rodo-popup-agree']")
    private WebElement rodoCloseButton;

    @FindBy(xpath = "//input[@id='formEmail']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='formPassword']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPageInteria(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(this.driver,10);
        PageFactory.initElements(this.driver, this);
    }

    public LoginPageInteria clickCloseRodoButton(){
        rodoCloseButton.click();
        logger.info("clicked close RODO button");
        return this;
    }

    public LoginPageInteria typeEmailAdress(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.sendKeys("testinguserman2@interia.pl");
        logger.info("Typed e-mail address");
        return this;
    }

    public LoginPageInteria typePassword(){
        passwordField.sendKeys("OcggoU2BzvZg6Io8Xuh6");
        logger.info("Typed password");
        return this;
    }

    public InteriaMainPage logInInteria(){
        loginButton.click();
        logger.info("Clicked log in button");
        return new InteriaMainPage(driver);
    }

}
