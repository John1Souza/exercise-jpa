package model.onetoone;

import javax.persistence.Entity;

@Entity
  public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
  }
