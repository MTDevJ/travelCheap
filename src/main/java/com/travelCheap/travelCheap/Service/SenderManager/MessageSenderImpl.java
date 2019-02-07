package com.travelCheap.travelCheap.Service.SenderManager;

import com.travelCheap.travelCheap.Configuration.EmailConf;
import com.travelCheap.travelCheap.Domain.Message;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MessageSenderImpl implements SenderManager {

    private JavaMailSenderImpl mailSender;
    private EmailConf emailConf;

    public void setEmailConf(EmailConf emailConf) {
        this.emailConf = emailConf;
    }

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMessage(Message clientMessage) {

        mailSender.setHost(emailConf.getHost());
        mailSender.setPort(Integer.parseInt(emailConf.getPort()));
        mailSender.setUsername(emailConf.getUsername());
        mailSender.setPassword(emailConf.getPassword());

        try {
<<<<<<< HEAD
            mailSender.send(mailMessage);
            logger.info("Message sent");
        } catch (MailException e) {
            logger.error("Message sending error: " + e);
=======
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(clientMessage.getClientEmail());
            helper.setTo(emailConf.getRecepient());
            helper.setSubject("travelCheap");
            helper.setText(
                            clientMessage.getClientName() + "\n" +
                            clientMessage.getClientTelephoneNumber() + "\n" +
                            clientMessage.getComment() + "\n"
            );

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
>>>>>>> parent of 20589c5... added message creating logic
        }
    }
}
