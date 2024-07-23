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
import java.util.ArrayList;
import java.util.List;

public class ManyToManyDemo4 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Item i001 = em.find(Item.class, "I001");
                Item i002 = em.find(Item.class, "I002");
                Item i003 = em.find(Item.class, "I003");

                List<OrderDetail> orderDetailList = new ArrayList<>();
                Order od003 = new Order("OD003", Date.valueOf(LocalDate.now()),
                        "Imantha", orderDetailList);

                OrderDetail orderDetail1 = new OrderDetail(od003, i001, 2, i001.getPrice());
                OrderDetail orderDetail2 = new OrderDetail(od003, i002, 1, i002.getPrice());
                OrderDetail orderDetail3 = new OrderDetail(od003, i003, 1, i003.getPrice());

                orderDetailList.add(orderDetail1);
//                orderDetailList.add(orderDetail2);
//                orderDetailList.add(orderDetail3);
                em.persist(od003);

                tx.commit();
            } catch (Throwable e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}
