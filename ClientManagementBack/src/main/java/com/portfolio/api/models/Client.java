package com.portfolio.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.UUID;

@Builder(toBuilder = true)
@Value
@Jacksonized        // Allows jackson to deserialize the object sent from Postman
public class Client {

    @JsonProperty(value = "idClient")
    @Valid
    UUID idClient;

    @JsonProperty(value = "name")
    @NotNull
    @Valid
    String name;

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
    Instant creationDate;

    @JsonProperty(value = "updateDate")
    @Valid
    @EqualsAndHashCode.Exclude
    Instant updateDate;
}
