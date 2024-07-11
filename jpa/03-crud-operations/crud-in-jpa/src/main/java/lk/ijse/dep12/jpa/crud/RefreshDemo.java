package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class RefreshDemo {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            System.out.println("EntityManagerFactory: " + emf);
            System.out.println("EntityManager: " + em);
            em.getTransaction().begin();
            try {

                Student s002 = em.find(Student.class, "S002");
                System.out.println(s002);
                s002.setName("Tharindu+++");
                // em.detach(s002);         // hibernate.allow_refresh_detached_entity = true
                em.refresh(s002);
                System.out.println(s002);

                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
