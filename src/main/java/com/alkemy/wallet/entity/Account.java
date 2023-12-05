package com.alkemy.wallet.entity;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Entity
    @Table(name = "Account")
    public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated(EnumType.STRING)
        @Column(name = "currency", nullable = false)
        private Currency currency;

        @Column(name = "transactionLimit", nullable = false)
        private Double transactionLimit;

        @Column(name = "balance", nullable = false)
        private Double balance;


        @Column(name = "creationDate")
        private Timestamp creationDate;


        @Column(name = "updateDate")
        private Timestamp updateDate;

        @Column(name = "isDeleted")
        private Boolean isDeleted = false;

        // Acá los getters y setters para cada atributo

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setTransactionLimit(Double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }


}

