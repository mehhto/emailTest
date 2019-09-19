package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageInteria extends PageBase{

    WebDriver driver;

    public LoginPageInteria(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }


}
