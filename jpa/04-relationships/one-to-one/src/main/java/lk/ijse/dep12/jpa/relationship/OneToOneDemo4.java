package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Employee;
import lk.ijse.dep12.jpa.relationship.entity.Spouse;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

public class OneToOneDemo4 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            System.out.println("Entity Manager Factory: " + emf);
            System.out.println("Entity Manager: " + em);
            em.getTransaction().begin();
            try {
                Employee tharindu = em.find(Employee.class, "E001");
                System.out.println(tharindu.getSpouse());

                Spouse sumanthalatha = em.find(Spouse.class, "S001");
//                for (int i = 0; i < 100; i++) {
                    // tharindu.setSpouse(sumanthalatha);
//                }
                //sumanthalatha.setEmployee(tharindu);

                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
