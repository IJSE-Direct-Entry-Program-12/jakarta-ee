package lk.ijse.dep12.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class HelloJpa {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManageFactory();
             EntityManager em = emf.createEntityManager()) {
            System.out.println("Entity Manager Factory: " + emf);
            System.out.println("Entity Manager: " + em);
        }
    }
}
