package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

import java.util.List;

public class CreateDemo {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {

                Student s001 = new Student("S001", "Kasun Sampath", "011-1234567");
                Student s002 = new Student("S002", "Nuwan Ramindu", "055-1234567");
                Student s003 = new Student("S003", "Chamal Peries", "033-1234567");

                List.of(s001, s002, s003).forEach(em::persist);

                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
