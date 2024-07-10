package lk.ijse.dep12.nh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HelloNativeHibernate {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println("Session Factory: " + sessionFactory);
            System.out.println("Session: " + session);
        }
    }
}
