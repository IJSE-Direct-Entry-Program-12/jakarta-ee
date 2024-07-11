package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

import java.util.List;

public class ClearVsDetach {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {

                Student student = new Student("S025", "Asiri", "088-4567891");
                em.persist(student);
                System.out.println("Is S025 inside the context? " + em.contains(student));  // true
                //em.detach(student);
                em.clear();
                System.out.println("Is S025 inside the context? " + em.contains(student));  // false

                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
