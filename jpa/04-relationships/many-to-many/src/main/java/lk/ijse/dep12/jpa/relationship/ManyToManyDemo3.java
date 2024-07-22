package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Actor;
import lk.ijse.dep12.jpa.relationship.entity.Movie;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;

public class ManyToManyDemo3 {

    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Movie asaibayai = em.find(Movie.class, "M003");

                Actor tharindu = em.find(Actor.class, "A001");
                Actor parveen = em.find(Actor.class, "A004");
                Actor piumi = em.find(Actor.class, "A003");

                asaibayai.getActors().add(tharindu);
                asaibayai.getActors().add(parveen);
                asaibayai.getActors().add(piumi);

                tx.commit();
            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
