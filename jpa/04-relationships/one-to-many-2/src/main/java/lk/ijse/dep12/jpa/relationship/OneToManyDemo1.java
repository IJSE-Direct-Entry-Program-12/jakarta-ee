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

public class OneToManyDemo1 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Lawyer tharindu = new Lawyer("L001", "Tharindu");
                Lawyer buddhika = new Lawyer("L002", "Buddhika");

                LawSuite ls001 = new LawSuite("LS-001", "Criminal",
                        "Sappage Sapa Kama", Date.valueOf(LocalDate.now()), tharindu);
                LawSuite ls002 = new LawSuite("LS-002", "Criminal",
                        "Minuwangoada Shooting", Date.valueOf(LocalDate.now()));
                LawSuite ls003 = new LawSuite("LS-003", "Criminal",
                        "Gampaha Shooting", Date.valueOf(LocalDate.now()));

                List.of(tharindu, buddhika, ls001, ls002, ls003).forEach(em::persist);

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
