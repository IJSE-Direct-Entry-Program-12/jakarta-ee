package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Item;
import lk.ijse.dep12.jpa.relationship.entity.Order;
import lk.ijse.dep12.jpa.relationship.entity.OrderDetail;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;

public class ManyToManyDemo1 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Item i001 = em.find(Item.class, "I001");
                Item i002 = em.find(Item.class, "I002");
                Order od004 = new Order("OD004", Date.valueOf(LocalDate.now()),
                        "Tharindu");
                OrderDetail od1 = new OrderDetail(od004, i001, 2, i001.getPrice());
                OrderDetail od2 = new OrderDetail(od004, i002, 1, i002.getPrice());
                em.persist(od004);
                em.persist(od1);
                em.persist(od2);

                tx.commit();
            } catch (Throwable e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}
