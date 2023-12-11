package com.alkemy.wallet.entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // int cambiado a Long para permitir la generacion automatica del id

  @Column(name = "NAME", nullable = false)
  @Enumerated(EnumType.STRING)
  private ERole name;

  @Column(nullable = true) 
  private String description;

  @Column 
  private Timestamp creationDate;

  @Column
  private Timestamp updateDate;

  @PrePersist
  protected void onCreate() {
    this.creationDate = new Timestamp(System.currentTimeMillis() );
}

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ERole getName() {
    return name;
  }

  public void setName(ERole name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Timestamp getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Timestamp updateDate) {
    this.updateDate = updateDate;
  }

}

