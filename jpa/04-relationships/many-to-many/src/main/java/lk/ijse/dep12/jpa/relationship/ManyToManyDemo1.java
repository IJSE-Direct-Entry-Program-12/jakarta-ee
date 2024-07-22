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

public class ManyToManyDemo1 {

    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Actor a001 = new Actor("A001", "Tharindu",
                        Actor.Gender.MALE, Date.valueOf(LocalDate.now()));
                Actor a002 = new Actor("A002", "Imantha", Actor.Gender.MALE,
                        Date.valueOf(LocalDate.now()));
                Actor a003 = new Actor("A003", "Piumi",
                        Actor.Gender.FEMALE, Date.valueOf(LocalDate.now()));
                Movie m001 = new Movie("M001", "Iron Man 3", "Action",
                        Date.valueOf("2016-01-01"), List.of(a001, a002, a003));
                Movie m002 = new Movie("M002", "Oyai Mamai", "Romance",
                        Date.valueOf("2024-01-01"), List.of(a001, a003));

                em.persist(m001);
                em.persist(m002);

                tx.commit();
            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
