package basic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetUser{
  public static void main(String[] args){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise-jpa");
    EntityManager em = emf.createEntityManager();
    
    User user = em.find(User.class, 1);
    System.out.println(user.getName());
    
    
    em.close();
    emf.close();
  }
}
