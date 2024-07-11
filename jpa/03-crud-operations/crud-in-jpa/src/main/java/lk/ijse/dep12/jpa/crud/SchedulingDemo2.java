package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class SchedulingDemo2 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {

                Student s100 = new Student("S100", "Sasindu", "055-1234567");
                System.out.println("Is s100 inside the context? " + em.contains(s100));
                em.persist(s100);
                System.out.println("Is s100 inside the context? " + em.contains(s100));
                em.remove(s100);
                System.out.println("Is s100 inside the context? " + em.contains(s100));
                em.persist(s100);
                System.out.println("Is s100 inside the context? " + em.contains(s100));

                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
