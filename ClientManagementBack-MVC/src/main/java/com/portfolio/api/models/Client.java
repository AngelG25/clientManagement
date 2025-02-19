package com.portfolio.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.UUID;

@Builder(toBuilder = true)
@Entity
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)        // Necessary for the dataBase
@Jacksonized
public class Client {

    @JsonProperty(value = "idClient")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Valid
    UUID idClient;

    @JsonProperty(value = "username")
    @NotNull
    @Valid
    String username;

    @JsonProperty(value = "surname")
    @Valid
    String surname;

    @JsonProperty(value = "number", required = true)
    @Valid
    int number;

    @JsonProperty(value = "email", required = true)
    @NotNull
    @Valid
    String email;

    @JsonProperty(value = "creationDate")
    @Valid
    @EqualsAndHashCode.Exclude
    @CreationTimestamp
    Instant creationDate;

    @JsonProperty(value = "updateDate")
    @Valid
    @EqualsAndHashCode.Exclude
    @UpdateTimestamp
    Instant updateDate;
}
