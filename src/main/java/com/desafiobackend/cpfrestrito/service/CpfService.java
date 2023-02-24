package com.desafiobackend.cpfrestrito.service;

import com.desafiobackend.cpfrestrito.dto.CpfDTO;
import com.desafiobackend.cpfrestrito.exception.ExistsCpfException;
import com.desafiobackend.cpfrestrito.exception.InvalidCpfException;
import com.desafiobackend.cpfrestrito.exception.NotFoundCpfException;
import com.desafiobackend.cpfrestrito.model.Cpf;

import java.util.List;

public interface CpfService {
    List<Cpf> findAllCpf();
    Cpf getCpf(String cpf) throws NotFoundCpfException, InvalidCpfException;
    Object addCpf(CpfDTO cpfDTO) throws InvalidCpfException, ExistsCpfException;
    void deleteCpf(String cpf) throws InvalidCpfException, NotFoundCpfException;

}
