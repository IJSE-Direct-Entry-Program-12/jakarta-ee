package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class MergeDemo2 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {
                Student s001 = em.find(Student.class, "S001");  // SELECT
                System.out.println("Is s001 inside the context? " + em.contains(s001));     // true
                em.detach(s001);
                System.out.println("Is s001 inside the context? " + em.contains(s001));     // false
                Student s001Duplicate = em.find(Student.class, "S001"); // SELECT
                System.out.println("Is s001 inside the context? " + em.contains(s001Duplicate));     // true
                s001.setName("Ruwan Sampath");
                Student mergedEntity = em.merge(s001);
                System.out.println(mergedEntity == s001Duplicate);      // true
                System.out.println("Is mergedEntity inside the context? " + em.contains(mergedEntity)); // true
                System.out.println("Is s001 inside the context? " + em.contains(s001)); // false

                em.getTransaction().commit();   // Update
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
