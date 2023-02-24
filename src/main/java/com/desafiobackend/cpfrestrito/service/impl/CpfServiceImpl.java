package com.desafiobackend.cpfrestrito.service.impl;

import com.desafiobackend.cpfrestrito.dto.CpfDTO;
import com.desafiobackend.cpfrestrito.exception.*;
import com.desafiobackend.cpfrestrito.model.Cpf;
import com.desafiobackend.cpfrestrito.repository.CpfRepository;
import com.desafiobackend.cpfrestrito.service.CpfService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.desafiobackend.cpfrestrito.utils.validation.CpfValidation.*;

@Service
public class CpfServiceImpl implements CpfService {
    @Autowired
    private CpfRepository cpfRepository;

    public CpfServiceImpl(CpfRepository cpfRepository) {
        this.cpfRepository = cpfRepository;
    }

    @Override
    public List<Cpf> findAllCpf() {
        return cpfRepository.findAll();
    }

    @Override
    public Cpf getCpf(String cpf) throws NotFoundCpfException, InvalidCpfException {
        if (!isCpfValid(cpf))
            throw new InvalidCpfException("CPF is invalid");

        return this.cpfRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundCpfException("CPF not found"));
    }

    @Override
    public Cpf addCpf(CpfDTO dto) throws InvalidCpfException, ExistsCpfException {
        String cpfFormatted = getOnlyDigitsFromCPF(dto.getCpf());

        if (!isCpfValid(cpfFormatted)) {
            throw new InvalidCpfException("CPF is invalid");
        } else if (checksCpf(cpfFormatted)) {
            throw new ExistsCpfException("CPF already exists");
        }

        return this.cpfRepository.save(new Cpf(cpfFormatted));
    }

    @Override
    @Transactional
    public void deleteCpf(String cpf) throws InvalidCpfException, NotFoundCpfException {
        if (!isCpfValid(cpf)) {
            throw new InvalidCpfException("CPF is invalid");
        } else if (!checksCpf(cpf)) {
            throw new NotFoundCpfException("CPF not found");
        }

        this.cpfRepository.deleteByCpf(cpf);
    }

    private boolean checksCpf(String cpf) {
        return cpfRepository.existsCpfByCpf(cpf);
    }

}
