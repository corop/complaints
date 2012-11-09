package dao;

import org.hibernate.Session;
import ru.fccland.complaints.card.form.Category;
import ru.fccland.complaints.card.form.Department;
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
        List<Category> categories = session.createQuery("from Category").list();
        for (Category category : categories) {
            System.out.println("category = " + category);
        }

        List<Department> departments = session.createQuery("from Department").list();
        for (Department department : departments) {
            System.out.println("department = " + department);
        }

        session.getTransaction().commit();
    }
}
