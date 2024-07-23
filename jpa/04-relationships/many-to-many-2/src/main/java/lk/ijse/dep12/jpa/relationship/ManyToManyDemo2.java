package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Item;
import lk.ijse.dep12.jpa.relationship.entity.Order;
import lk.ijse.dep12.jpa.relationship.entity.OrderDetail;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class ManyToManyDemo2 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Order od001 = new Order("OD001", Date.valueOf(LocalDate.now()), "Tharindu");
                Item i001 = em.find(Item.class, "I001");
                Item i002 = em.find(Item.class, "I002");
                OrderDetail orderDetail1 = new OrderDetail(od001, i001, 2, i001.getPrice());
                OrderDetail orderDetail2 = new OrderDetail(od001, i002, 1, i002.getPrice());
                em.persist(od001);
                em.persist(orderDetail1);
                em.persist(orderDetail2);

                tx.commit();
            } catch (Throwable e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}
