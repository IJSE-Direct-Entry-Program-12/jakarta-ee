package lk.ijse.dep12.jpa.query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lk.ijse.dep12.jpa.query.entity.Customer;
import lk.ijse.dep12.jpa.query.util.JpaUtil;

import java.util.List;

public class QueryDemo4 {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()){
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();

                Query query = em.createNativeQuery("SELECT * FROM customer", Customer.class);
                query.setFirstResult(2);
                query.setMaxResults(2);
                System.out.println("------------------------------");
                List<Customer> customerList = query.getResultList();
                customerList.forEach(System.out::println);
                customerList.forEach(c ->
                        System.out.println(c.getId() + " is inside the context? " + em.contains(c)));
                customerList.get(0).setName("Nuwan");

                tx.commit();
            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
