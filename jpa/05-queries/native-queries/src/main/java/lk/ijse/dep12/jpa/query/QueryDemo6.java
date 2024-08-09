package lk.ijse.dep12.jpa.query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lk.ijse.dep12.jpa.query.entity.Customer;
import lk.ijse.dep12.jpa.query.entity.Order;
import lk.ijse.dep12.jpa.query.util.JpaUtil;

import java.util.List;

public class QueryDemo6 {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()){
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();

                Query query = em.createNativeQuery("""
                        SELECT o.* FROM customer c INNER JOIN `order` o ON c.id = o.customer_id
                        """, Order.class);
                List<Order> orderList = query.getResultList();
                System.out.println("---------------------------");
                System.out.println(em.find(Customer.class, "C001"));
                System.out.println(em.find(Order.class, "OD001"));

                tx.commit();
            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
