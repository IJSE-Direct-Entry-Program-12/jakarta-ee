package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.entity.Product;
import lk.ijse.dep12.jpa.relationship.entity.Purchase;
import lk.ijse.dep12.jpa.relationship.entity.Supplier;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.math.BigDecimal;
import java.util.List;

public class TernaryDemo2 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Customer tharindu = em.find(Customer.class, "C001");
                Customer menith = em.find(Customer.class, "C002");
                Customer waruna = em.find(Customer.class, "C003");

                Supplier hp = em.find(Supplier.class, "S001");
                Supplier dell = em.find(Supplier.class, "S002");

                Product mouse = em.find(Product.class, "P001");
                Product keyboard = em.find(Product.class, "P002");
                Product monitor = em.find(Product.class, "P003");

                Purchase purchase1 = new Purchase(tharindu, mouse, hp, 5, new BigDecimal("1250"));
                Purchase purchase2 = new Purchase(tharindu, keyboard, hp, 5, new BigDecimal("1500"));
                Purchase purchase3 = new Purchase(menith, keyboard, dell, 10, new BigDecimal("1250"));
                Purchase purchase4 = new Purchase(waruna, keyboard, dell, 10, new BigDecimal("1250"));
                Purchase purchase5 = new Purchase(waruna, monitor, hp, 5, new BigDecimal("75000"));

                List.of(purchase1, purchase2, purchase3, purchase4, purchase5)
                                .forEach(em::persist);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
