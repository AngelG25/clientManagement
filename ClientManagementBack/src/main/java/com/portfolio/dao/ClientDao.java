package com.portfolio.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@NoArgsConstructor              // Necessary for the build in the get API
@Getter
@Setter
@Table(name = "Client")
public class ClientDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idClient", unique = true)
    private UUID idClient;

    @Column(name = "username", updatable = false)
    private String username;

    @Column(name = "surname", updatable = false)
    private String surname;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

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
