package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class CacheDemo {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {

                Student s001 = em.find(Student.class, "S001");
                System.out.println("------------------");
                Student s001Clone = em.find(Student.class, "S001");
                Student s001Clone2 = em.find(Student.class, "S001");
                Student s001Clone3 = em.find(Student.class, "S001");
                System.out.println(s001 == s001Clone);
                System.out.println(s001Clone == s001Clone2);
                System.out.println(s001Clone2 == s001Clone3);

                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
