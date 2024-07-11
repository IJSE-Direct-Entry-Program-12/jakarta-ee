package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class MergeDemo5 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {

                System.out.println("Searching...");
                Student s001 = em.find(Student.class, "S001");
                System.out.println("Found");
                System.out.println("Detaching....");
                em.detach(s001);
                System.out.println("Detached");
                System.out.println("Merging....");
                Student mergedEntity = em.merge(s001);
                System.out.println("Merged");

                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
