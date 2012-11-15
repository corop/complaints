package dao;

import org.hibernate.Session;
import ru.fccland.complaints.card.controller.ComplaintsController;
import ru.fccland.complaints.card.domain.Category;
import ru.fccland.complaints.card.domain.ComplaintAuthor;
import ru.fccland.complaints.card.domain.Department;
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

        Category category = (Category)session.load(Category.class, new Long(4));
        System.out.println("category = " + category);
        ComplaintAuthor complaintAuthor = (ComplaintAuthor)session.load(ComplaintAuthor.class, new Long(1));
        System.out.println("complaintAuthor = " + complaintAuthor);

        session.getTransaction().commit();
    }
}
