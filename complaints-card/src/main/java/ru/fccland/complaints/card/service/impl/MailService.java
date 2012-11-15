package ru.fccland.complaints.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 16.11.12
 * Time: 2:17
 * To change this template use File | Settings | File Templates.
 */
@Service("mailService")
public class MailService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage alertMailMessage;

    public void sendMail(String from, String[] to, String subject, String body, String[] attachFileNames) {

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("mail.host.com");
        try {
            MimeMessage message = sender.createMimeMessage();
            // use the true flag to indicate you need a multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);

            helper.setText(subject);
            helper.setFrom(from);

            for (int i = 0; i < attachFileNames.length; i++) {
                String attachFileName = attachFileNames[i];
                FileSystemResource file = new FileSystemResource(new File(attachFileName));
                try {
                    helper.addAttachment(file.getFilename(), file);
                } catch (javax.mail.MessagingException e) {
                    throw new MailParseException(e);
                }
            }
            sender.send(message);
        } catch (MessagingException e) {
            throw new MailParseException(e);
        }
    }

    public void sendAlertMail(String alert) {

        SimpleMailMessage mailMessage = new SimpleMailMessage(alertMailMessage);
        mailMessage.setText(alert);
        mailSender.send(mailMessage);

    }

}