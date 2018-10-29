package Query;

import FetcherCascade.Classes;
import FetcherCascade.Students;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class Query03Cascade {

    public static void main(String []args){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        Classes cl12 = new Classes(12, "QLDAPM", "NN Hung", "G2-107");

        Students std1 = new Students(13020112, "NH Hao 12", "K62KT", "nhhao@gmail.com",
                "0162354687", "Nghe An", 85, cl12);
        Students std2 = new Students(13020113, "NH Harrrrr 13", "K62KT", "nhhao@gmail.com",
                "0162354687", "Nghe An", 85, cl12);


        Set student = new HashSet();
        student.add(std1);
        student.add(std2);


        Classes cl13 = new Classes (13, "KDL", "BQ Hung", "G2-301",student);

            try {
                tx = session.beginTransaction();
//              Không thao tác lưu với đối tượng Students std1
//              session.save(std1);
                session.save(cl13);
                tx.commit();
            }
            catch (HibernateException ex){
                if(tx!=null) tx.rollback();
                ex.printStackTrace();
            }
            finally {
            session.close();
            }
    }
}
