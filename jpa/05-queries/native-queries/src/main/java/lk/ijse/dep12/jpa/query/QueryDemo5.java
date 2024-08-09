package lk.ijse.dep12.jpa.query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lk.ijse.dep12.jpa.query.entity.Customer;
import lk.ijse.dep12.jpa.query.util.JpaUtil;

import java.util.List;

public class QueryDemo5 {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()){
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();

                Query query = em.createNativeQuery("SELECT * FROM customer");
                List<Object[]> resultList = query.getResultList();
                resultList.forEach(c -> {
                    System.out.printf("id=%s, name=%s %n", c[0],c[1]);
                    System.out.println(c[0] + " is inside the context? " + em.contains(c));
                });

                tx.commit();
            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
