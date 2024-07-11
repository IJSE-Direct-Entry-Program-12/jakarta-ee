package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class MergeDemo4 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {

                Student s050 = new Student("S050", "Sappa", "022-1234567");
                Student s050Duplicate = em.merge(s050); // SELECT -> INSERT INTO SCHEDULE
                System.out.println("Is S050 inside the context? " + em.contains(s050));     // false
                System.out.println("Is s050Duplicate inside the context? " + em.contains(s050Duplicate));  //true

                em.getTransaction().commit();  // INSERT INTO
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
