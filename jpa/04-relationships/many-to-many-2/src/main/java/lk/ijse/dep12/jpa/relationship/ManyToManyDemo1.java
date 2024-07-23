package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Item;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.math.BigDecimal;
import java.util.List;

public class ManyToManyDemo1 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Item i001 = new Item("I001", "Keyboard", new BigDecimal("1250.00"));
                Item i002 = new Item("I002", "Mouse", new BigDecimal("1250.00"));
                Item i003 = new Item("I003", "Mouse Pad", new BigDecimal("500.00"));
                Item i004 = new Item("I004", "Headset", new BigDecimal("5000.00"));

                List.of(i001, i002, i003, i004).forEach(em::persist);

                tx.commit();
            } catch (Throwable e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}
