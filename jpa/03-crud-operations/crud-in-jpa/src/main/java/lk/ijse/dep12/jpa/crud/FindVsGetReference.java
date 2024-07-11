package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;

public class FindVsGetReference {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {
//                Student s1 = em.find(Student.class, "S100");
//                System.out.println(s1.getId());
//                Student s2 = em.getReference(Student.class, "S100");
//                System.out.println(s2.getId());

                Student s001 = em.getReference(Student.class, "S001");
                Student s002 = em.find(Student.class, "S002");
                Student s100 = em.find(Student.class, "S100");

                System.out.println("-------------");

                System.out.println(s001);
                System.out.println(s002);
                System.out.println(s100);

                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
