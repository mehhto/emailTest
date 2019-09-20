package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageGmail extends PageBase{

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement nextButton;

    public LoginPageGmail(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
  }

    public PasswordPageGmail typeAndSubmitEmailAdress(String emailAddress){
        emailField.sendKeys(emailAddress);
        logger.info("Typed email address");
        nextButton.click();
        logger.info("Clicked Next button");
        return new PasswordPageGmail(driver);
    }

}
