package basic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class GetUser{
  public static void main(String[] args){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise-jpa");
    EntityManager em = emf.createEntityManager();
    
    User user = em.find(User.class, 8L);
    if(user != null){
      em.getTransaction().begin();
      em.remove(user);
      em.getTransaction().commit();
    }
    
    em.close();
    emf.close();
  }
}
