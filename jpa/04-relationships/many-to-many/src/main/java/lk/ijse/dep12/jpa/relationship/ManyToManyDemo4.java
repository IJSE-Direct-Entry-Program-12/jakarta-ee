package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Actor;
import lk.ijse.dep12.jpa.relationship.entity.Movie;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

public class ManyToManyDemo4 {

    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Actor tharindu = em.find(Actor.class, "A001");
                tharindu.getMovies().forEach(System.out::println);
                //tharindu.getMovies().remove(2);   // This does not work (inverse end)

//                Movie asaibayai = em.find(Movie.class, "M003");
//                asaibayai.getActors().remove(tharindu);   // This works (owner end)

                tx.commit();
            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
