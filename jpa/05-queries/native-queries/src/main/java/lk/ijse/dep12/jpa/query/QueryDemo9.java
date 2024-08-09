package lk.ijse.dep12.jpa.query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lk.ijse.dep12.jpa.query.entity.Order;
import lk.ijse.dep12.jpa.query.util.JpaUtil;

import java.util.List;

public class QueryDemo9 {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()){
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();

                Query query = em
                        .createNativeQuery("SELECT * FROM `order` WHERE username = ?2 OR username = ?1",
                        Order.class);
                query.setParameter(1, "kasun");
                query.setParameter(2, "nuwan");
                List<Order> orderList = query.getResultList();
                orderList.forEach(System.out::println);

                tx.commit();
            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
