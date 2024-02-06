package basic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class GetUser{
  public static void main(String[] args){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise-jpa");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    User user = em.fin(User.class, 7L);
    // Tirar o objeto do estado gerenciado/gerenciável
    em.detach(user);
    
    user.setName("Leonardo Alterado");

    //em.merge(user);
    
    em.getTransaction().commit();
    em.close();
    emf.close();
  }
}
