package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.LawSuite;
import lk.ijse.dep12.jpa.relationship.entity.Lawyer;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo2 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Lawyer tharindu = em.find(Lawyer.class, "L001");
                LawSuite ls002 = em.find(LawSuite.class, "LS-002");
                ls002.setLawyer(tharindu);          // INSERT

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
