import entity.Card;
import entity.Employee;
import entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setfName("Anna");
        e.setlName("López");
        Task t = new Task("Crear landing page", e);
        Card c = new Card("AAAAXXXX00000",e);
        e.setCard(c);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.persist(c);
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
