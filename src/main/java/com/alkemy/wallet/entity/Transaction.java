package com.alkemy.wallet.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="Transactions")

public class Transaction {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private Double amount;
@Column(nullable = false)
private Etransactions type;
@Column(nullable = false)
private String description;
private int accountId;
@Column(name = "transaction_date")
private Timestamp transactionDate;

    @PrePersist
    protected void onCreate() {
        this.transactionDate = new Timestamp(System.currentTimeMillis() );
    }
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

    public Etransactions getType() {
        return type;
    }

    public void setType(Etransactions type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }
}
