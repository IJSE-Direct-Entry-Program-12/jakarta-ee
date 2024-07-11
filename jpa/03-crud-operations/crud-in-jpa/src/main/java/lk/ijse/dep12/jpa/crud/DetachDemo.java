package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class DetachDemo {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {

                Student s001 = em.find(Student.class, "S001");
                System.out.println(s001);
                System.out.println("Is s001 inside the context? " + em.contains(s001));
                s001.setName("Chamika");
                em.detach(s001);
                System.out.println("Is s001 inside the context? " + em.contains(s001));

                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
