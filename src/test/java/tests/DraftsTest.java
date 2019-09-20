package tests;

import org.testng.annotations.Test;
import page.objects.InteriaDrafts;
import page.objects.LoginPageInteria;

public class DraftsTest extends TestBase {

    @Test
    public void draftsTest() {

        LoginPageInteria loginPageInteria = new LoginPageInteria(driver);
        loginPageInteria
                .clickCloseRodoButton()
                .typeEmailAdress()
                .typePassword()
                .logInInteria()
                .clickDraftsIcon();

        InteriaDrafts interiaDrafts = new InteriaDrafts(driver);
        System.out.println(interiaDrafts.checkIfDraftsWork());
//        assertTrue(interiaDrafts.checkIfDraftsWork());

    }

}
