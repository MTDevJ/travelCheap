package com.travelCheap.travelCheap.Service.SenderManager;
import com.travelCheap.travelCheap.Configuration.EmailConf;
import com.travelCheap.travelCheap.Domain.Message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MessageSenderImpl implements SenderManager {
    private static final Logger logger = LogManager.getLogger(MessageSenderImpl.class.getName());
    private JavaMailSenderImpl mailSender;
    private EmailConf emailConf;
    @Autowired
    public void setEmailConf(EmailConf emailConf) {
        this.emailConf = emailConf;
    }
    @Autowired
    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMessage(Message clientMessage) {

        mailSender.setHost(emailConf.getHost());
        mailSender.setPort(Integer.parseInt(emailConf.getPort()));
        mailSender.setUsername(emailConf.getUsername());
        mailSender.setPassword(emailConf.getPassword());

        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(emailConf.getUsername());
            helper.setTo(emailConf.getRecepient());
            helper.setSubject("travelCheap");
            helper.setText(
                    "Name: " + clientMessage.getClientName() + "\n" +
                            "Email: " + clientMessage.getClientEmail() + "\n" +
                            "Телефон: " + clientMessage.getClientTelephoneNumber() + "\n" +
                            "Ответ 1: " + clientMessage.getQuestion1() + "\n" +
                            "Ответ 2: " + clientMessage.getQuestion2() + "\n" +
                            "Ответ 3: " + clientMessage.getQuestion3() + "\n" +
                            "Name: " + clientMessage.getComment() + "\n"
            );
            logger.info("Message create");
            try {
                mailSender.send(message);
                logger.info("Message sent");
            } catch (MailException e) {
                logger.error("Message error: " + e);
                e.printStackTrace();
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
