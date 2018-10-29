package Query;

import FetcherCascade.Students;
import org.hibernate.query.Query;
import org.hibernate.Session;

import java.util.List;

public class Query01{

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "select s from Students s order by s.studentName";
        Query<Students> query = session.createQuery(sql);
        List<Students> stds = (List<Students>) query.getResultList();

        session.getTransaction().commit();
        

        for (Students std : stds) {
            System.out.println("Student: " + std.getStudentName() +
                    "\n ID_Students: " +std.getIdStudent() +
                    "\n ID Class: " + std.getIdClasses() +
                    "\n");
        }

		session.close();
        HibernateUtil.shutdown();
    }
}
