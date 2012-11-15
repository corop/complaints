package ru.fccland.complaints.card.service;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 16.11.12
 * Time: 2:39
 * To change this template use File | Settings | File Templates.
 */
public interface MailService {
    public void sendMail(String from, String[] to, String subject, String body, String[] attachFileNames);
    public void sendAlertMail(String alert);
}
