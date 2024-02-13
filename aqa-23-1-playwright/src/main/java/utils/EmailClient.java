package utils;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;

import java.io.IOException;

public class EmailClient {
    Message message;
    public static final String API_KEY = "Htf9pnjgEInECalI";
    public static final String SERVER_ID = "1wf4gnkr";
    public static final String SERVER_DOMAIN = ".mailosaur.net";

    MailosaurClient mailosaur = new MailosaurClient(API_KEY);
    SearchCriteria searchCriteria = new SearchCriteria();

    public String getEmailLinkBySendTo(String sendToEmail){
        searchCriteria.withSentTo(sendToEmail);
        try {
            message = mailosaur.messages().get(SERVER_ID, searchCriteria);
        } catch (IOException | MailosaurException e) {
            throw new RuntimeException(e);
        } return  message.html().links().get(0).href();
    }

    public void deleteMessagesById(String messageId) {
        try {
            mailosaur.messages().delete(messageId);
        } catch (MailosaurException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailIdBySentTo(String sentTo) {
        searchCriteria.withSentTo(sentTo);
        try {
            return mailosaur.messages().get(SERVER_ID, searchCriteria).id();
        } catch (IOException | MailosaurException e) {
            throw new RuntimeException(e);
        }
    }




}
