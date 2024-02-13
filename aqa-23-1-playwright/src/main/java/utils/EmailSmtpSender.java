package utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailSmtpSender {
    String smtpUser = "1wf4gnkr@mailosaur.net";
    String pass  =  "aIYgesYrmTqanQCdJvBicbKRvZgGyQK8";
    public void sendEmail(String messageSubj, String email) {
        // Uses javax.mail
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.mailosaur.net");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.ssl.trust", "smtp.mailosaur.net");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(smtpUser,pass);
            }
        });

        MimeMessage message = new MimeMessage(session);
        try {
            message.setSubject(messageSubj);
            message.setFrom(new InternetAddress("Our Company <from@example.com>"));
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("Test User <"+email+">"));

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent("<p>Hello my dear friends.</p>" +
                    "<a href=\"https://soundmag.ua/\">Залишити відгук</b></a>" +
                    "", "text/html; charset=utf-8");

            MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
            mimeBodyPart1.setContent("<p>Hello my dear friends.</p>" +
                    "<a href=\"https://soundmag.ua/\">Залишити відгук</b></a>" +
                    "", "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(mimeBodyPart1);

            message.setContent(multipart);
            session.getTransport("smtp").send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
