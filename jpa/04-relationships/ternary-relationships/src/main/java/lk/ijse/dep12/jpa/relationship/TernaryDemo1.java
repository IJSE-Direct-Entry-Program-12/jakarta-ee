package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.entity.Product;
import lk.ijse.dep12.jpa.relationship.entity.Supplier;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.util.List;

public class TernaryDemo1 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Customer tharindu = new Customer("C001", "Tharindu", "011-1234567");
                Customer menith = new Customer("C002", "Menith", "022-1234567");
                Customer waruna = new Customer("C003", "Waruna", "033-1234567");

                Supplier hp = new Supplier("S001", "HP");
                Supplier dell = new Supplier("S002", "DELL");

                Product mouse = new Product("P001", "Mouse");
                Product keyboard = new Product("P002", "Keyboard");
                Product monitor = new Product("P003", "Monitor");

                List.of(tharindu, menith, waruna, hp, dell, mouse, keyboard, monitor)
                                .forEach(em::persist);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
