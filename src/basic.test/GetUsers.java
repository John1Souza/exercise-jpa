package basic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class GetUser{
  public static void main(String[] args){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise-jpa");
    EntityManager em = emf.createEntityManager();
    String jpql = "select u from User u";
    TypedQuery<User> query = em.createQuery(jpql, User.class);
    query.setMaxResults(5);

    List<User> users = query.getResultList();
    for(User user: users){
      System.out.println("ID: " + user.getId() + " E-mail: " + user.getEmail());
    }


    
    User user = em.find(User.class, 1);
    System.out.println(user.getName());
    
    
    em.close();
    emf.close();
  }
}
