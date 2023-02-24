package com.desafiobackend.cpfrestrito.dto;

public class CpfDTO {
    private String cpf;

    public CpfDTO() {
    }

    public CpfDTO(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
