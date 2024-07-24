package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.util.List;

public class ManyToManyDemo1 {

    public static void main(String[] args) {
       try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager()){
           EntityTransaction tx = em.getTransaction();
           try {
               tx.begin();

               Course dep = new Course("DEP", "Direct Entry Program", "6 Months");
               Course cmjd = new Course("CMJD", "Comprehensive Master Java Developer", "6 Months");
               Course gdse = new Course("GDSE", "Graduate Diploma in Software Engineering", "2 Years");

               Student s001 = new Student("S001", "Kasun Sampath", "Galle",
                       "077-1234567", Date.valueOf("1988-02-03"), Student.Gender.MALE);
               Student s002 = new Student("S002", "Tharindu", "Galle",
                       "071-1234567", Date.valueOf("1993-02-03"), Student.Gender.MALE);
               Student s003 = new Student("S003", "Imantha", "Galle",
                       "078-1234567", Date.valueOf("1996-02-03"), Student.Gender.MALE);

               List.of(dep, cmjd, gdse, s001, s002, s003).forEach(em::persist);

               tx.commit();
           }catch (Throwable e){
               tx.rollback();
               e.printStackTrace();
           }
       }
    }
}
