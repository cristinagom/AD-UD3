import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try {
            Employee e = new Employee("Pablo", "Rodriguez", "655232323");
            Task t = new Task("Create landing page");
            Card c = new Card("2345-2345-2345-2345", TypeCard.BLACK,e);
            Department d1 = new Department("IT");
            Department d2 = new Department("Finance");
            e.addDepartment(d1);
            e.addDepartment(d2);
            e.setCard(c);
            e.addTask(t);
            String cad = null;
            t.setDescription(cad);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(c);
            em.persist(t);

            em.persist(e);

            //em.persist(d1);
            //em.persist(d2);
            System.out.println(e);
            em.getTransaction().commit();
            em.close();
            emf.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
