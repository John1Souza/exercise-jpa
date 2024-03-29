package model.onetoone;

import javax.persistence.Entity;
import javax.persistence.GenerationValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToOne(mappedBy = "seat")
  private Client cliente;

  public Seat(){

  }

  public Seat(String name){
    super();
    this.name = name;
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

  public String getClient(){
    return name;
  }

  public void setClient(Client client){
    this.client = client;
  }

}
