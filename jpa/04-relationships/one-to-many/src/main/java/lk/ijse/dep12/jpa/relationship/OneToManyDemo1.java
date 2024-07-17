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

public class OneToManyDemo1 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Customer kajja = new Customer("011-1234567", "Kajja", "Galle");
                Customer muditha = new Customer("033-1234567", "Muditha", "Matara");
                Customer yasiya = new Customer("077-1234567", "Yasiya", "Kandy");

                Order od001 = new Order("OD001", Date.valueOf(LocalDate.now()),
                        new BigDecimal("1250.00"), kajja);
                Order od002 = new Order("OD002", Date.valueOf(LocalDate.now()),
                        new BigDecimal("5000.00"), kajja);
                Order od003 = new Order("OD003", Date.valueOf(LocalDate.now()),
                        new BigDecimal("7500.00"), kajja);
                Order od004 = new Order("OD004", Date.valueOf(LocalDate.now()),
                        new BigDecimal("25000"), muditha);

                List.of(kajja, muditha, yasiya, od001, od002, od003, od004)
                                .forEach(em::persist);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
