package com.desafiobackend.cpfrestrito.serviceTest;


import com.desafiobackend.cpfrestrito.dto.CpfDTO;
import com.desafiobackend.cpfrestrito.exception.ExistsCpfException;
import com.desafiobackend.cpfrestrito.exception.InvalidCpfException;
import com.desafiobackend.cpfrestrito.exception.NotFoundCpfException;
import com.desafiobackend.cpfrestrito.model.Cpf;
import com.desafiobackend.cpfrestrito.repository.CpfRepository;
import com.desafiobackend.cpfrestrito.service.impl.CpfServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {CpfServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CpfServiceTest {

    @MockBean
    private CpfRepository cpfRepository;
    @Autowired
    private CpfServiceImpl cpfServiceImpl;

    @BeforeEach
    void setUp() {
        cpfRepository = Mockito.mock(CpfRepository.class);
        cpfServiceImpl = new CpfServiceImpl(cpfRepository);
    }

    /*
     * Method being tested: {@link CpfServiceImpl#findAllCpf()}
     * Test if the output is an empty list when there is no CPF in the restricted list
     */
    @Test
    void testFindAllCPFsEmpty() {
        when(cpfRepository.findAll()).thenReturn(List.of());
        assertTrue(this.cpfServiceImpl.findAllCpf().isEmpty());
        verify(cpfRepository).findAll();
    }

    /*
     * Method being tested: {@link CpfServiceImpl#findAllCpf()}
     * Test if the output is a list with CPFs when there is CPFs in the restricted list
     */

    @Test
    void testFindAllCPFs() {
        ArrayList<Cpf> cpfList = new ArrayList<>();
        when(cpfRepository.findAll()).thenReturn(cpfList);
        List<Cpf> actualFindAllCPFsResult = this.cpfServiceImpl.findAllCpf();
        assertSame(cpfList, actualFindAllCPFsResult);
        assertTrue(actualFindAllCPFsResult.isEmpty());
        verify(cpfRepository).findAll();
    }

    /*
     * Method being tested: {@link CpfServiceImpl#addCpf(CpfDTO)}
     * Test if the CPF is added to restricted list
     */
    @Test
    void testAddCpf() throws InvalidCpfException, ExistsCpfException {
        Cpf cpf = new Cpf("12345678901");
        when(cpfRepository.save((Cpf) any())).thenReturn(cpf);

        CpfDTO cpf1 = new CpfDTO("999-874-123-45");
        assertSame(cpf, this.cpfServiceImpl.addCpf(cpf1));
        verify(cpfRepository).save((Cpf) any());
    }

    /*
     * Method being tested: {@link CpfServiceImpl#addCpf(CpfDTO)}
     * Test if the exception is throw when the CPF is invalid
     */
    @Test
    void testAddCPFThrowsInvalidCpfException()  {
        assertThrows(InvalidCpfException.class, () -> {
            this.cpfServiceImpl.addCpf(new CpfDTO("222222222222"));
        });
    }

    /*
     * Method being tested: {@link CpfServiceImpl#addCpf(CpfDTO)}
     * Test if the exception is throw when the CPF already exists
     */
    @Test
    void testAddCPFThrowsExistsCpfException() {
        this.cpfRepository.save(new Cpf("12345678901"));
        when(cpfRepository.existsCpfByCpf(anyString())).thenReturn(true);
        assertThrows(ExistsCpfException.class, () -> {
            this.cpfServiceImpl.addCpf(new CpfDTO("12345678901"));
        });
    }

    /*
     * Method being tested: {@link CpfServiceImpl#addCpf(CpfDTO)}
     * Test if the exception is not throw when the CPF is valid and not exists
     */
    @Test
    void testAddCPFDoNotThrowExistsCpfException() {
        this.cpfRepository.save(new Cpf("14596512300"));
        when(cpfRepository.existsCpfByCpf(anyString())).thenReturn(false);
        assertDoesNotThrow(() -> {
            this.cpfServiceImpl.addCpf(new CpfDTO("12345678901"));
        });
    }

    /*
    * Method being tested: {@link CpfServiceImpl#getCpf(String)}
    * Throw an exception when the CPF is not found
    */
    @Test
    void testGetCpfNotFound() {
        assertThrows(NotFoundCpfException.class, () -> {
            this.cpfServiceImpl.getCpf("12345678901");
        });
    }

    /*
    * Method being tested: {@link CpfServiceImpl#getCpf(String)}
    * Test if the exception is throw when the CPF is invalid
    */
    @Test
    void testGetCpfIsInvalid() {
        assertThrows(InvalidCpfException.class, () -> {
            this.cpfServiceImpl.getCpf("12-5224-221-22");
        });
    }

    /*
    * Method being tested: {@link CpfServiceImpl#getCpf(String)}
    * Test if the CPF is returned when the CPF is valid and exists
    */
    @Test
    void testGetCpf() throws InvalidCpfException, NotFoundCpfException {
        Cpf cpf = new Cpf("12345678901");
        when(cpfRepository.findByCpf(anyString())).thenReturn(Optional.of(cpf));
        assertSame(cpf, this.cpfServiceImpl.getCpf("12345678901"));
        verify(cpfRepository).findByCpf(anyString());
    }

    /*
    * Method being tested: {@link CpfServiceImpl#deleteCpf(String)}
    * Test if an exception is throw when the CPF is invalid
    */
    @Test
    void testDeleteCpfThrowsInvalidCpfException() {
        assertThrows(InvalidCpfException.class, () -> {
            this.cpfServiceImpl.deleteCpf("1.23-4562s78901");
        });
    }

    /*
    * Method being tested: {@link CpfServiceImpl#deleteCpf(String)}
    * Test if an exception is throw when the CPF is not found
    */
    @Test
    void testDeleteCpfThrowsNotFoundCpfException() {
        assertThrows(NotFoundCpfException.class, () -> {
            this.cpfServiceImpl.deleteCpf("12345678901");
        });
    }


}