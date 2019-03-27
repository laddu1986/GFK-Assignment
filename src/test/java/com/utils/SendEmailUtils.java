package com.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.WebDriver;

/**
 * Created by Laddu shashavali
 */
public class SendEmailUtils extends UtilsController {

    public SendEmailUtils(WebDriver driver) {
        super(driver);
    }

    public static void emailReport(String sendTo, String subject, String message){
        Email email = new SimpleEmail();
        try {
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("shasha.intell@gmail.com", "shasha@432"));
            email.setSSLOnConnect(true);
            email.setFrom("shasha.intell@gmail.com");
            email.setSubject(subject);
            email.setMsg(message);
            email.addTo(sendTo);
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
