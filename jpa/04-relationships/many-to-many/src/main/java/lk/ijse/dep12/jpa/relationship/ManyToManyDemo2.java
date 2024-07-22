package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Actor;
import lk.ijse.dep12.jpa.relationship.entity.Movie;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ManyToManyDemo2 {

    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Movie movie = new Movie("M003", "Asai Bayai", "18+"
                        , Date.valueOf("2024-03-01"));
                em.persist(movie);
                Actor actor = new Actor("A004", "Praveen",
                        Actor.Gender.MALE, Date.valueOf("2000-03-01"));
                em.persist(actor);

                tx.commit();
            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
