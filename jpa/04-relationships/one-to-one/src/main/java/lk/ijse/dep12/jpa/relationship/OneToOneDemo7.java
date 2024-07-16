package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Account;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class OneToOneDemo7 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            System.out.println("Entity Manager Factory: " + emf);
            System.out.println("Entity Manager: " + em);
            em.getTransaction().begin();
            try {
                Customer customer = new Customer("223456789V", "Nuwan", "Ramindu",
                        "Panadura", "011-1234567", Date.valueOf("1980-10-08"),
                        new Account("13-123456789-12", "Savings", new BigDecimal("2000.00"),
                                null, Date.valueOf(LocalDate.now()), "Asiri"));

                em.persist(customer);

                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
