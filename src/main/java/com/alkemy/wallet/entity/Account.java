package com.alkemy.wallet.entity;

import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import com.alkemy.wallet.entity.User;
import javax.persistence.EnumType;

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

        @ManyToOne
        @JoinColumn(name = "userId", nullable = false)
        private User user;

        @Column(name = "creationDate")
        private LocalDateTime creationDate;

        @Getter
        @Column(name = "updateDate")
        private LocalDateTime updateDate;

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

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }


}

