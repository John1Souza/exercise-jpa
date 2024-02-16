package model.basic;

@Entity
@Table(name = "tb_products", schema = "java_course")
public class Product {

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

  
}
