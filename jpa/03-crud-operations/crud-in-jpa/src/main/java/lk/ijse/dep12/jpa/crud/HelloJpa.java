package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class HelloJpa {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            System.out.println("EntityManagerFactory: " + emf);
            System.out.println("EntityManager: " + em);
            em.getTransaction().begin();
            try {

                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
