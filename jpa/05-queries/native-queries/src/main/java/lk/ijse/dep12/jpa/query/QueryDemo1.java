package lk.ijse.dep12.jpa.query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.query.entity.*;
import lk.ijse.dep12.jpa.query.util.JpaUtil;

public class QueryDemo1 {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()){
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();

                Customer c001 = em.getReference(Customer.class, "C005");
                User asiri = em.find(User.class, "asiri");
                Item i001 = em.find(Item.class, "I001");
                Order od001 = em.getReference(Order.class, "OD001");
                OrderDetail orderDetail = em.find(OrderDetail.class, new OrderDetailPK(od001, i001));

                System.out.println(c001);
                System.out.println(asiri);
                System.out.println(i001);
                System.out.println(od001);
                System.out.println(orderDetail);

                tx.commit();
            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
