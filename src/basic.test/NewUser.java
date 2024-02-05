package basic.test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewUser{
  public static void main(String[] args){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise-jpa");
    EntityManager em = emf.createEntityManager();
    
    User newUser = new User("Djalma","djalma@lanche.com.br");
    newUser.setId(1L);
    
    em.getTransaction().begin();
    em.persist(newUser);
    em.getTransaction().commit();

    
    em.close();
    emf.close();
  }
}
