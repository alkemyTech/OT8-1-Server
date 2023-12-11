package com.alkemy.wallet.entity;

import java.sql.Timestamp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private Long roleId;

    @Column
    private Timestamp creationDate;

    @Column
    private Timestamp updateDate;

    @Column
    private boolean softDelete;

    @PrePersist
    protected void onCreate() {
        this.creationDate = new Timestamp(System.currentTimeMillis());
    }

}
