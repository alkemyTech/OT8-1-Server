package com.alkemy.wallet.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "FixedTermDeposit")
public class FixedTermDeposit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Double amount;

  @Column(nullable = false)
  private Double interest;

  @Column
  private Timestamp creationDate;

  @Column
  private Timestamp closingDate;

  @ManyToOne
  @JoinColumn(name="accountId", referencedColumnName = "id")
  private Account account;
    
  @PrePersist
  protected void onCreate() {
    this.creationDate = new Timestamp(System.currentTimeMillis());
  }

  // Getters y Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getInterest() {
    return interest;
  }

  public void setInterest(Double interest) {
    this.interest = interest;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
  }

  public Timestamp getClosingDate() {
    return closingDate;
  }

  public void setClosingDate(Timestamp closingDate) {
    this.closingDate = closingDate;
  }

}
