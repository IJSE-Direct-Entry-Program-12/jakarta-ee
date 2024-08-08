package lk.ijse.dep12.jpa.query;

import jakarta.persistence.*;
import lk.ijse.dep12.jpa.query.entity.Customer;
import lk.ijse.dep12.jpa.query.util.JpaUtil;

import java.util.Arrays;
import java.util.List;

public class QueryDemo2 {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()){
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();

                // 1st Choice
                Query query2 = em.createNativeQuery("SELECT * FROM customer", Customer.class);
                List<Customer> customerList2 = query2.getResultList();
                customerList2.forEach(System.out::println);

                // 2nd Choice
                Query query3 = em.createNativeQuery("SELECT * FROM customer", Tuple.class);
                List<Tuple> customerList3 = query3.getResultList();
                for (Tuple tuple : customerList3) {
                    System.out.printf("id=%s, name=%s %n", tuple.get(0), tuple.get("name"));
                }

                // Last Choice
                Query query1 = em.createNativeQuery("SELECT * FROM customer");
                List<Object[]> customerList1 = query1.getResultList();
                for (Object[] row : customerList1) {
                    System.out.println(Arrays.toString(row));
                }

                tx.commit();
            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
