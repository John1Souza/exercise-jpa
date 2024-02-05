package basic.test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewUser{
  public static void main(String[] args){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise-jpa");
    EntityManager em = emf.createEntityManager();
    
    User newUser = new User("Djalma","djalma@lanche.com.br");
    //User("Rodrigo","rodrigo@lanche.com.br")
    //User("Andre","andre@lanche.com.br")
    //User("Carlos","carlos@lanche.com.br")
    //User("Lulu","aulu@lanche.com.br")
    //User("Arthur","arthur@lanche.com.br")   

    
    em.getTransaction().begin();
    em.persist(newUser);
    em.getTransaction().commit();

    
    em.close();
    emf.close();
  }
}
