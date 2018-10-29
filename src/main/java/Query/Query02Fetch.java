package Query;

import FetcherCascade.Classes;
import FetcherCascade.Students;
import org.hibernate.Session;

import java.util.Set;


public class Query02Fetch {

    public static void main(String[]args){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        //khởi tạo đối tượng classes (clss)
        Classes clss = new Classes();
        clss = (FetcherCascade.Classes) session.get(FetcherCascade.Classes.class, 2);

        //đóng sessison trước khi thao tác in danh sách sinh viên
        session.close();

        //Những thao tác dưới đây nhằm mục đích lấy thông tin students (con) bằng cách gọi từ classes(cha)
        Set<Students> listStd = clss.getStudents();
        System.out.println("Size: "+ listStd.size());

        for (Students students : listStd){
            System.out.println(students.getStudentName());
            System.out.println(students.getIdStudent());
            System.out.println(students.getEmail());
            System.out.println("/n");
        }

        //đóng session sau khi thao tác in danh sách(1)
        //session.close();
    }
}
