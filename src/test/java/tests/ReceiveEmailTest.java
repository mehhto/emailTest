package tests;

import org.testng.annotations.Test;
import page.objects.LoginPageInteria;

import java.util.ArrayList;

public class ReceiveEmailTest extends TestBase {

    @Test
    public void receiveEmailTest() {
        openNewTab();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        goToInteriaLoginPage(tabs);
        LoginPageInteria loginPageInteria = new LoginPageInteria(driver);
        loginPageInteria
                .clickCloseRodoButton()
                .typeEmailAdress()
                .typePassword()
                .logInInteria();

    }
}
