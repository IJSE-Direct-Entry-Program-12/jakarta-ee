package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.entity.Order;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

public class OneToManyDemo2 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Order od001 = em.find(Order.class, "OD001"); // SELECT
                System.out.println(od001.getCustomer());
                Customer muditha = em.find(Customer.class, "033-1234567"); // SELECT
                muditha.getOrders().forEach(System.out::println); // SELECT
                System.out.println("--------------------");
                Customer kajja = em.find(Customer.class, "011-1234567");
                System.out.println("--------------------");
                kajja.getOrders().forEach(System.out::println);  // SELECT

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
