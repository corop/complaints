package ru.fccland.complaints.card.task;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.fccland.complaints.card.domain.Complaint;
import ru.fccland.complaints.card.util.HibernateUtil;

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
    @Scheduled(fixedDelay=30*60*1000)    // 30 minutes
    public void run() {
        log.info("MailSenderTask.run()");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query =   session.createQuery("FROM Complaint WHERE sended = :sendedFlag");
        query.setParameter("sendedFlag", new Long(0L));
        List<Complaint> complaints = query.list();
        if(complaints != null && !complaints.isEmpty())
            for (Complaint complaint : complaints) {
                log.debug("Start send complaint = " + complaint);
            }
        else
            log.debug("No new complaint for send via email");
        session.getTransaction().commit();

    }
}