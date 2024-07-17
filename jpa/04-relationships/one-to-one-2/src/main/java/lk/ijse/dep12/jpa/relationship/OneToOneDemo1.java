package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.User;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.util.List;

public class OneToOneDemo1 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                User tharindu = new User("123456789V", "Tharindu", "Galle",
                        Date.valueOf("2000-05-02"), User.Gender.MALE);
                User imantha = new User("456789123V", "Imantha", "Matara",
                        Date.valueOf("2000-05-02"), User.Gender.MALE);
                User buddhika = new User("789456123V", "Buddhika", "Kandy",
                        Date.valueOf("2000-05-02"), User.Gender.MALE);
                User piumi = new User("987456123V", "Piumi", "Matara",
                        Date.valueOf("2000-05-02"), User.Gender.FEMALE);
                User saduni = new User("456123789V", "Saduni", "Colombo",
                        Date.valueOf("2000-05-02"), User.Gender.FEMALE);

                List.of(tharindu, imantha, buddhika, piumi, saduni).forEach(em::persist);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
