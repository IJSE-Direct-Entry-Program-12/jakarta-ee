package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.entity.Order;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo4 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Order od001 = new Order("OD001", Date.valueOf(LocalDate.now()),
                        new BigDecimal("1250.00"), null);
                Order od002 = new Order("OD002", Date.valueOf(LocalDate.now()),
                        new BigDecimal("4567.00"), null);
                Order od003 = new Order("OD003", Date.valueOf(LocalDate.now()),
                        new BigDecimal("7891.00"), null);
                Customer tharindu = new Customer("011-1234567", "Tharindu", "Galle",
                        List.of(od001, od002, od003));
                em.persist(tharindu);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
