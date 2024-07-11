package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class FlushVsCommitVsRollback {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {

                Student s035 = new Student("S035", "Tharindu", "088-1234567");
                Student s036 = new Student("S036", "Waruna", "099-1234567");
                em.persist(s035);       // SCHEDULE -> INSERT INTO
                em.persist(s036);       // SCHEDULE -> INSERT INTO
                System.out.println("------------");
                em.flush();     // INSERT INTO, INSERT INTO
                System.out.println("Flushed...!");
                System.out.println("Is S035 inside the context? " + em.contains(s035));
                System.out.println("Is S036 inside the context? " + em.contains(s036));
                // em.clear();
                em.getTransaction().rollback();
                System.out.println("Roll backed...!");
                System.out.println("Is S035 inside the context? " + em.contains(s035));
                System.out.println("Is S036 inside the context? " + em.contains(s036));
                em.getTransaction().begin();
                Student s037 = new Student("S037", "Yasiya", "045-1234567");
                em.persist(s037);    // SCHEDULE -> INSERT INTO
                System.out.println("------------");
                em.getTransaction().commit();   // INSERT INTO
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
