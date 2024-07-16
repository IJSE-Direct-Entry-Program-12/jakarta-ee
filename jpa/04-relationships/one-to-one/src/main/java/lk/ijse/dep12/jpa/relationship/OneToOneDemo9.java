package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Account;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.entity.User;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToOneDemo9 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            System.out.println("Entity Manager Factory: " + emf);
            System.out.println("Entity Manager: " + em);
            em.getTransaction().begin();
            try {

                User imantha = new User("123456789V", "Imantha", "Galle",
                        Date.valueOf("2000-05-02"), User.Gender.MALE);
                User buddhika = new User("456789123V", "Buddhika", "Galle",
                        Date.valueOf("2000-05-02"), User.Gender.MALE);
                User waruna = new User("789456123V", "Waruna", "Matara",
                        Date.valueOf("2000-05-02"), User.Gender.MALE);
                User piumi = new User("789456124V", "Piumi", "Matara",
                        Date.valueOf("2000-08-02"), User.Gender.FEMALE);
                User ruwangi = new User("889456123V", "Ruwangi", "Galle",
                        Date.valueOf("2000-08-02"), User.Gender.FEMALE);
                List.of(imantha, buddhika, waruna, piumi, ruwangi).forEach(em::persist);

                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
