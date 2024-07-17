package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.*;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.entity.Order;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;
import org.hibernate.collection.spi.PersistentBag;
import org.hibernate.internal.SessionImpl;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo3 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                Customer yasiya = em.find(Customer.class, "077-1234567");
//                Order od004 = em.find(Order.class, "OD004");
//                od004.setTotal(new BigDecimal("45612.12"));
                Customer kajja = em.find(Customer.class, "011-1234567");
                kajja.getOrders().forEach(System.out::println);
                System.out.println("--------------------------------");
                SessionImpl session = em.unwrap(SessionImpl.class);
                System.out.println("Persistence Context Dirty: " + session.isDirty());
                printPersistentBagStatus(kajja.getOrders());
               //  kajja.getOrders().remove(1);
                // System.out.println(session.isDirty());
                 kajja.getOrders().add(new Order("OD006", Date.valueOf(LocalDate.now()),
                        new BigDecimal("18000"), yasiya));
                 System.out.println("Persistence Context Dirty: " + session.isDirty());
                printPersistentBagStatus(kajja.getOrders());
                System.out.println("--------------------------------");
                kajja.getOrders().forEach(System.out::println);
                kajja.setAddress("Matara+");
                System.out.println("--------------------------------");
                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }

    private static void printPersistentBagStatus(List<Order> persistentBag) {
        System.out.println("PersistentBag Dirty: " + ((PersistentBag<Order>) persistentBag).isDirty());
    }
}
