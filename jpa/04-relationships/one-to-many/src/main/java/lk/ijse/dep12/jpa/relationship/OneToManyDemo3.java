package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.*;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.entity.Order;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;
import org.hibernate.internal.SessionImpl;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class OneToManyDemo3 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Customer kajja = em.find(Customer.class, "011-1234567");
                kajja.getOrders().forEach(System.out::println);
                System.out.println("--------------------------------");
                SessionImpl session = em.unwrap(SessionImpl.class);
                System.out.println(session.isDirty());
                // kajja.getOrders().remove(1);
                // System.out.println(session.isDirty());
                 kajja.getOrders().add(new Order("OD005", Date.valueOf(LocalDate.now()),
                        new BigDecimal("18000"), kajja));
                 System.out.println(session.isDirty());
                System.out.println("--------------------------------");
                kajja.getOrders().forEach(System.out::println);
                kajja.setAddress("Matara");
                System.out.println("--------------------------------");
                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
