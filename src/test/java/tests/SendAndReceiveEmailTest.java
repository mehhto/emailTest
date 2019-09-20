package tests;

import org.testng.annotations.Test;
import page.objects.GmailMainPage;
import page.objects.LoginPageGmail;

import static org.testng.Assert.assertEquals;

public class SendAndReceiveEmailTest extends TestBase {


    @Test
    public void sendEmailTest() {

        LoginPageGmail loginPageGmail = new LoginPageGmail(driver);
        String messageConfirmation = loginPageGmail
                .typeAndSubmitEmailAdress("testinguserman1")
                .typeAndSubmitPassword("YD40bAVH1A8RYuH3bmwr")
                .clickNewMessageButton()
                .typeRecipientName("testinguserman1@gmail.com")
                .typeMessageSubject("dsadas")
                .typeMessage("piwwooooooo")
                .sendMessage()
                .getMessageSentConfirmation();

        assertEquals(messageConfirmation, "Wiadomość została wysłana.");

        GmailMainPage gmailMainPage = new GmailMainPage(driver);
        gmailMainPage.clickRefereshButton();

        assertEquals(gmailMainPage.getMessageText(), "dsadas");
    }


}
