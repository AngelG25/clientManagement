package com.portfolio.dao;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Table(name = "Client")
public class ClientDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idClient", unique = true)
    private UUID idClient;

    @Column(name = "name", updatable = false)
    private String name;

    @Column(name = "surname", updatable = false)
    private String surname;

    @Column(name = "number", unique = true)
    private int number;

    @Column(name = "email", unique = true, updatable = false)
    private String email;

    @Column(name = "creation_date", updatable = false)
    @CreationTimestamp
    private Instant creationDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Instant updateDate;

}
