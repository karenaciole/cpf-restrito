package com.desafiobackend.cpfrestrito.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;


@Entity
public class Cpf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Nonnull
    private String cpf;
    @Nonnull
    private String createdAt;


    public Cpf() {
    }

    public Cpf(String cpf) {
        this.id = id;
        this.cpf = cpf;
        this.createdAt = formattedDate();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    private String formattedDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return now.atZone(ZoneOffset.UTC).format(isoFormatter);
    }

}
