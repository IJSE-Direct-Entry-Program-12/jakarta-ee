package lk.ijse.dep12.jpa.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.crud.entity.Student;
import lk.ijse.dep12.jpa.crud.util.JpaUtil;
import org.hibernate.sql.ast.tree.expression.SqlTuple;

import java.util.List;

public class ClearDemo {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {

                Student s002 = em.find(Student.class, "S002");
                Student s003 = em.find(Student.class, "S003");
                Student s100 = em.find(Student.class, "S100");

                List.of(s002, s003, s100).
                        forEach(s -> System.out.printf("Is %s inside the context? %s %n",
                        s.getId(), em.contains(s)));

                em.clear();
                System.out.println("After clearing");

                List.of(s002, s003, s100).
                        forEach(s -> System.out.printf("Is %s inside the context? %s %n",
                                s.getId(), em.contains(s)));

                em.getTransaction().commit();
            } catch (Throwable t) {
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
