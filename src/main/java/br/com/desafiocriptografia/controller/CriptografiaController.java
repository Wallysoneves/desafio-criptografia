package br.com.desafiocriptografia.controller;

import br.com.desafiocriptografia.model.Criptografia;
import br.com.desafiocriptografia.model.dto.CriptografiaDTO;
import br.com.desafiocriptografia.service.CriptografiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dados-criptografado")
public class CriptografiaController {

    @Autowired private CriptografiaService criptografiaService;

    @GetMapping("todos")
    public ResponseEntity<List<Criptografia>> buscar() {
        return new ResponseEntity<>(criptografiaService.buscarDados(), HttpStatus.OK);
    }

    @GetMapping("um")
    public ResponseEntity<Criptografia> buscar(@RequestParam("identificador") Long id) {
        return new ResponseEntity<>(criptografiaService.buscarDados(id), HttpStatus.OK);
    }

    @PostMapping("cadastrar")
    public ResponseEntity<Criptografia> cadastrar(@RequestBody CriptografiaDTO criptografiaDTO) {
        return new ResponseEntity<>(criptografiaService.inserirDados(criptografiaDTO), HttpStatus.CREATED);
    }

    @PutMapping("alterar")
    public ResponseEntity<Criptografia> alterar(@RequestBody Criptografia criptografia) {
        return new ResponseEntity<>(criptografiaService.alterarDados(criptografia), HttpStatus.OK);
    }

    @DeleteMapping("remover")
    public ResponseEntity<?> deletar(@RequestParam("identificador") Long id) {
        criptografiaService.deletarDados(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
