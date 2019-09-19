package tests;

import org.testng.annotations.Test;
import page.objects.GmailMainPage;
import page.objects.LoginPageGmail;
import page.objects.LoginPageInteria;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class SendEmailTest extends TestBase {


    @Test
    public void sendEmailTest() {

        LoginPageGmail loginPageGmail = new LoginPageGmail(driver);
        GmailMainPage gmailMainPage = loginPageGmail
                .typeAndSubmitEmailAdress("testinguserman1")
                .typeAndSubmitPassword("YD40bAVH1A8RYuH3bmwr")
                .clickNewMessageButton()
                .typeRecipientName("testinguserman2@interia.pl")
                .typeMessageSubject("dsadas")
                .typeMessage("sdasdasdasdas")
                .sendMessage();

        String messageConfirmation = gmailMainPage.getMessageSentConfirmation();
        assertEquals(messageConfirmation, "Wiadomość została wysłana.");
    }


}
