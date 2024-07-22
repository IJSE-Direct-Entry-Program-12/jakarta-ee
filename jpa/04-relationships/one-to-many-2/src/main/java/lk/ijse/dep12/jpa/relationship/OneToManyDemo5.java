package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.LawSuite;
import lk.ijse.dep12.jpa.relationship.entity.Lawyer;
import lk.ijse.dep12.jpa.relationship.entity.LawyerLawSuite;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class OneToManyDemo5 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Lawyer tharindu = em.find(Lawyer.class, "L001");
                LawSuite ls001 = em.find(LawSuite.class, "LS-001");
                LawyerLawSuite lawyerLawSuite1 = new LawyerLawSuite(ls001, tharindu,
                        new BigDecimal("65000"), Date.valueOf(LocalDate.now()));

                LawSuite ls002 = em.find(LawSuite.class, "LS-002");
                LawyerLawSuite lawyerLawSuite2 = new LawyerLawSuite(ls002, tharindu,
                        new BigDecimal("75000"), Date.valueOf(LocalDate.now()));

                em.persist(lawyerLawSuite1);
                em.persist(lawyerLawSuite2);

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
