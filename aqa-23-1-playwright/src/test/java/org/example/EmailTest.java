package org.example;

import base.BaseTestRunner;
import emun.AnsiColors;
import org.junit.jupiter.api.Test;
import utils.EmailClient;
import utils.EmailSmtpSender;

import static emun.AnsiColors.ANSI_BLUE_BACKGROUND;
import static emun.AnsiColors.ANSI_RESET;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.SharedFunctions.getNewEmailAddress;

public class EmailTest extends BaseTestRunner {
    String emailSendTo;
    String linkFromEmail;
    String emailId;
    EmailSmtpSender emailSmtpSender = new EmailSmtpSender();
    EmailClient emailClient = new EmailClient();

    @Test
    //https://mailosaur.com/app/servers/1wf4gnkr/messages/inbox
    public void sendEmailAndGetInfo() {
        emailSendTo = getNewEmailAddress();
        emailSmtpSender.sendEmail("Stas test", emailSendTo);
        System.out.println(ANSI_BLUE_BACKGROUND.getCode()+emailSendTo+ANSI_RESET.getCode());
        linkFromEmail = emailClient.getEmailLinkBySendTo(emailSendTo);
        System.out.println(linkFromEmail);
        page.navigate(linkFromEmail);
        assertEquals(linkFromEmail, "https://soundmag.ua/");
        emailId = emailClient.getEmailIdBySentTo(emailSendTo);
        System.out.println(AnsiColors.ANSI_GREEN.getCode() + emailId + ANSI_RESET.getCode());
        emailClient.deleteMessagesById(emailId);
    }
}
