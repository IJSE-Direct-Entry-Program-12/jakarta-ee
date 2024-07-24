package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Enrollment;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ManyToManyDemo2 {

    public static void main(String[] args) {
       try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()){
           EntityTransaction tx = em.getTransaction();
           try {
               tx.begin();

               Course dep = em.find(Course.class, "DEP");
               Course cmjd = em.find(Course.class, "CMJD");
               Course gdse = em.find(Course.class, "GDSE");

               Student s001 = em.find(Student.class, "S001");       // Kasun
               Student s002 = em.find(Student.class, "S002");       // Tharindu
               Student s003 = em.find(Student.class, "S003");       // Imantha

               Enrollment enrollment1 = new Enrollment(s001, dep, Date.valueOf(LocalDate.now()), "Maneesha");
               Enrollment enrollment2 = new Enrollment(s001, cmjd, Date.valueOf(LocalDate.now()), "Maneesha");
               Enrollment enrollment3 = new Enrollment(s002, cmjd, Date.valueOf(LocalDate.now()), "Hansi");
               Enrollment enrollment4 = new Enrollment(s002, gdse, Date.valueOf(LocalDate.now()), "Hansi");
               Enrollment enrollment5 = new Enrollment(s003, gdse, Date.valueOf(LocalDate.now()), "Maneesha");
               Enrollment enrollment6 = new Enrollment(s003, dep, Date.valueOf(LocalDate.now()), "Maneesha");

               List.of(enrollment1, enrollment2, enrollment3, enrollment4, enrollment5, enrollment6)
                               .forEach(em::persist);

               tx.commit();
           }catch (Throwable e){
               tx.rollback();
               e.printStackTrace();
           }
       }
    }
}
