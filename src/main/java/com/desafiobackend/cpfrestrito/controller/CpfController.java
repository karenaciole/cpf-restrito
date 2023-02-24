package com.desafiobackend.cpfrestrito.controller;

import com.desafiobackend.cpfrestrito.dto.CpfDTO;
import com.desafiobackend.cpfrestrito.exception.ExistsCpfException;
import com.desafiobackend.cpfrestrito.exception.InvalidCpfException;
import com.desafiobackend.cpfrestrito.exception.NotFoundCpfException;
import com.desafiobackend.cpfrestrito.service.CpfService;
import com.desafiobackend.cpfrestrito.utils.errors.CpfError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpf")
public class CpfController {
    @Autowired
    private CpfService cpfService;

    public CpfController(CpfService cpfService) {
        this.cpfService = cpfService;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> checaSeCpfExisteNaListaRestrita(@PathVariable("cpf") String cpf) {
        try {
            return ResponseEntity.ok(this.cpfService.getCpf(cpf));
        } catch (InvalidCpfException e) {
            return CpfError.errorInvalidCpf(e);
        } catch (NotFoundCpfException e) {
            return CpfError.errorCpfNotFound(e);
        }
    }
    @PostMapping
    public ResponseEntity<?> adicionaCpfNaListaRestrita(@RequestBody CpfDTO cpfDTO) {
        try {
            this.cpfService.addCpf(cpfDTO);
        }  catch (ExistsCpfException e) {
            return CpfError.errorCpfAlreadyExists(e);
        } catch (InvalidCpfException e) {
            return CpfError.errorInvalidCpf(e);
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> removeCpfDaListaRestrita(@PathVariable("cpf") String cpf) {
        try {
            this.cpfService.deleteCpf(cpf);
        } catch (InvalidCpfException e) {
            return CpfError.errorInvalidCpf(e);
        } catch (NotFoundCpfException e) {
            return CpfError.errorCpfNotFound(e);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<?> listaTodosOsCpfsDaListaRestrita() {
        return ResponseEntity.ok(this.cpfService.findAllCpf());
    }
}
