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
import java.util.List;

public class ManyToManyDemo3 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Item i001 = em.find(Item.class, "I001");
                Item i002 = em.find(Item.class, "I002");
                Item i003 = em.find(Item.class, "I003");

                OrderDetail orderDetail1 = new OrderDetail(null, i001, 2, i001.getPrice());
                OrderDetail orderDetail2 = new OrderDetail(null, i002, 1, i002.getPrice());
                OrderDetail orderDetail3 = new OrderDetail(null, i003, 1, i003.getPrice());

                List<OrderDetail> orderDetailList = List.of(orderDetail1, orderDetail2, orderDetail3);
                Order od002 = new Order("OD002", Date.valueOf(LocalDate.now()),
                        "Asiri", orderDetailList);
                em.persist(od002);

                tx.commit();
            } catch (Throwable e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}
