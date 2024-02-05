package basic.model;

@Entity
public class User{
  private Long id;
  private String name;
  private String email;

  public User(){
    
  }

   public User(String name, String email){
    super();
     this.name =  name;
     this.email = email;
  }  

  @Id
  @GeneratedValue
  public Long getId(){
    return id;
  }
  public void setId(Long id){
    this.id = id;
  }

  public String getName(){
    return name;
  }

  public void setName(){
    this.name = name;
  }
  
}
