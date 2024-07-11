package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class ReadDemo {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {
                Student s001 = em.find(Student.class, "S001");
                System.out.println(s001);

                Student s002 = em.find(Student.class, "S002");
                System.out.println(s002);

                Student s100 = em.find(Student.class, "S100");
                System.out.println(s100);
                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
