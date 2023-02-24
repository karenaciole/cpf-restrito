package com.desafiobackend.cpfrestrito.repository;

import com.desafiobackend.cpfrestrito.model.Cpf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CpfRepository extends JpaRepository<Cpf, String>{
    boolean existsCpfByCpf(String cpf);

    void deleteByCpf(String cpf);

    Optional<Cpf> findByCpf(String cpf);
}
