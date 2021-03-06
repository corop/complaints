package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.fccland.complaints.card.controller.ComplaintsController;
import ru.fccland.complaints.card.dao.impl.CategoryDAOImpl;
import ru.fccland.complaints.card.domain.Category;
import ru.fccland.complaints.card.domain.Complaint;
import ru.fccland.complaints.card.domain.ComplaintAuthor;
import ru.fccland.complaints.card.domain.Department;
import ru.fccland.complaints.card.service.ComplaintAuthorService;
import ru.fccland.complaints.card.service.impl.CategoryServiceImpl;
import ru.fccland.complaints.card.service.impl.ComplaintAuthorServiceImpl;
import ru.fccland.complaints.card.service.impl.DepartmentServiceImpl;
import ru.fccland.complaints.card.util.HibernateUtil;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 10:08
 * To change this template use File | Settings | File Templates.
 */
public class TestHibernateSession {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
/*        Category category = new Category(null, "Физическое лицо" );
        session.save(category);
        category = new Category(null, "Юридическое лицо" );
        session.save(category);
        category = new Category(null, "Представитель физического лица" );
        session.save(category);
        category = new Category(null, "Представитель юридического лица" );
        session.save(category); */
        List<Category> categories = session.createQuery("FROM Category").list();
        for (Category category : categories) {
            System.out.println("category = " + category);
        }

        System.out.println("***********************************************");

        List<Department> departments = session.createQuery("from Department").list();
        for (Department department : departments) {
            System.out.println("department = " + department);
        }

        System.out.println("***********************************************");

        Query query =   session.createQuery("FROM Complaint WHERE sended = :sendedFlag");
        query.setParameter("sendedFlag", new Long(0L));
        List<Complaint> complaints = query.list();

        if(complaints != null && !complaints.isEmpty())
            for (Complaint complaint : complaints) {
                System.out.println("Start send complaint = " + complaint);
            }
        else
            System.out.println("No new complaint for send via email");

        session.getTransaction().commit();
    }
}
