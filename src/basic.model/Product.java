package basic.model;

@Entity
@Table(name = "tb_products", schema = "java_course")
public class Product implements Entity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "prod_name", length = 200, nullable = false)
  private String name;

  @Column(name = "prod_price", nullable = false, precision = 11, scale = 2) // Precision = tamanho máximo do número, Scale = quantos números após a vírguala EX: 123456789,00
  private Double price;

  public Product(){
    
  }

  public Product(String name, Double price){
    this.name = name;
    this.price = price;
  }

  public Long getId(){
    return id;
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }
  
  public Double getPrice(){
    return price;
  }

  public void setPrice(Double price){
    this.price = price;
  }
  
}