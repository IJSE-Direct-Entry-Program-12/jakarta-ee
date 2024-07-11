package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class MergeDemo3 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {

                Student s001 = new Student("S001", "Menith", "088-1234567");
                Student s001Clone = em.merge(s001);// SELECT
                System.out.println("--------------");
                System.out.println("Is s001 inside the context? " + em.contains(s001)); // false
                System.out.println("Is s001 inside the context? " + em.contains(s001Clone)); // true

                em.getTransaction().commit();   // Update
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
