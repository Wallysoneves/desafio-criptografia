package br.com.desafiocriptografia.service;

import br.com.desafiocriptografia.model.Criptografia;
import br.com.desafiocriptografia.model.dto.CriptografiaDTO;

import java.util.List;

public interface CriptografiaService {

    List<Criptografia> buscarDados();

    Criptografia buscarDados(Long id);

    Criptografia inserirDados(CriptografiaDTO criptografiaDTO);

    Criptografia alterarDados(Criptografia criptografia);

    void deletarDados(Long id);

    Criptografia criptografarDados(Criptografia criptografia);
}
