package com.alkemy.wallet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
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
  private int accountId;

  @Column(nullable = false)
  private Double interest;

  @Column
  private Timestamp creationDate;

  @Column
  private Timestamp closingDate;

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

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
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
