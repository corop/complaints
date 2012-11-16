package ru.fccland.complaints.card.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 16.11.12
 * Time: 2:52
 * To change this template use File | Settings | File Templates.
 */

@Service("mailSenderTask")
public class MailSenderTask {
    protected static Logger log = Logger.getLogger("mail-sender-task");

    @Async
    @Scheduled(fixedDelay=5*1000)
    public void run() {
        log.info("MailSenderTask.run()");

    }
}