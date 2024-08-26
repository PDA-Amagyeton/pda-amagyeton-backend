package com.example.armagyetdon.account;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class AccountPInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name="account_id")
    private Account account;

    private String pInfo;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
