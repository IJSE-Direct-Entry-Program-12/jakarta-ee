package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.User;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToOneDemo10 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            System.out.println("Entity Manager Factory: " + emf);
            System.out.println("Entity Manager: " + em);
            em.getTransaction().begin();
            try {

                User imantha = em.find(User.class, "123456789V");
                User ruwangi = em.find(User.class, "889456123V");

                ruwangi.setPartner(imantha);
                imantha.setPartner(ruwangi);
                imantha.setDate(Date.valueOf(LocalDate.now()));
                ruwangi.setDate(imantha.getDate());

                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
