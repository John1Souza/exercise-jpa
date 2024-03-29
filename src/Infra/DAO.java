package infra;

public class DAO<E> {
  
  private static EntityManagerFactory emf;
  private EntityManager em;
  private Class<E> classe;

  static {
    try{
      emf = Persistence.createEntityManagerFactory("exercise-jpa");
    } catch(Exception e) {
      // login -> log4j
    }
  }

  public DAO(){
    this(null);
  }
  
  public DAO(Class<E> classe){
    this.classe = classe;
    em = emf.createEntityManager();
  }

  public DAO<E> openTransaction(){
    em.getTransaction().begin();
    return this;
  }

  public DAO<E> closeTransaction(){
    em.getTransaction().commit();
    return this;
  }

  public DAO<E> addTransaction(E entity){
    em.persist(entity);
    return this;
  }

  public DAO<E> addAtomicTransaction(E entity){   
    return  this.openTransaction().addTransaction(E entity).closeTransaction();
  }

  public E getByID(Object id){
    return em.find(classe, id);
  }

  public List<E> getAll(){
    return this.getAll(10, 0);
  }
  public List<E> getAll(int limit, int offset){
    if(classe == null){
      throw new UnsopportedOperationException("null Class.");
    }

    String jpql = "select e from " + class.getName() + " e"; 
    TypedQuery<E> query = em.createdQuery(jpql, classe);
    query.setMaxResults(limit);
    query.setFirstResult(offset);
    return query.getResultList();
  }

  public List<E> consult(String consultName, Object... params){
    TypedQuery<E> query = em.createNamedQuery(consultName, classe);

    for(int i = 0; i < params.length; i += 2){
      query.setParameter(params[i].toString(), params[i + 1]);
    }
    return null;
  }

  public List<E> consultOne(String consultName, Object... params){
    List<E> list = consult(consultName, params);
    return list.isEmpty() ? null : list.get(0);
  }

  public void closeDAO(){
    em.close();
  }
}
