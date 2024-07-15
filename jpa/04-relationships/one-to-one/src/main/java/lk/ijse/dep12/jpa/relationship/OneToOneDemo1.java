package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Employee;
import lk.ijse.dep12.jpa.relationship.entity.Spouse;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.util.List;

public class OneToOneDemo1 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            System.out.println("Entity Manager Factory: " + emf);
            System.out.println("Entity Manager: " + em);
            em.getTransaction().begin();
            try {
                Employee tharindu = new Employee("E001", "Tharindu", "Galle", "011-1234567");
                Spouse sumanalatha = new Spouse("S001", "Sumanalatha", "011-1234568", tharindu);

                Employee imantha = new Employee("E002", "Imantha", "Rathanapura", null);
                Spouse senehealatha = new Spouse("S002", "Senehalatha", "022-1234567", imantha);

                Employee chamika = new Employee("E003", "Chamika", "Kandy", "033-1234567");

                List.of(tharindu, sumanalatha, imantha, senehealatha, chamika).forEach(em::persist);
                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
