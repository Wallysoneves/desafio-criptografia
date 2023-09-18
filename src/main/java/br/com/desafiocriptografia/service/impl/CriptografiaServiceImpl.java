package br.com.desafiocriptografia.service.impl;

import br.com.desafiocriptografia.model.Criptografia;
import br.com.desafiocriptografia.model.dto.CriptografiaDTO;
import br.com.desafiocriptografia.repository.CriptografiaRepo;
import br.com.desafiocriptografia.service.CriptografiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CriptografiaServiceImpl implements CriptografiaService {

    @Autowired private CriptografiaRepo criptografiaRepo;
    @Override
    public List<Criptografia> buscarDados() {
        List<Criptografia> criptografias = criptografiaRepo.findAll();

        List<Criptografia> criptografiasNew = new ArrayList<>();

        if (!criptografias.isEmpty()) {
            for (Criptografia c : criptografias) {
                criptografiasNew.add(criptografarDados(c));
            }
        }

        return criptografiasNew;
    }

    @Override
    public Criptografia buscarDados(Long id) {
        return criptografarDados(criptografiaRepo.findById(id).orElse(null));
    }

    @Override
    public Criptografia inserirDados(CriptografiaDTO criptografiaDTO) {

        Criptografia criptografia = Criptografia.builder()
                                                .userDocument(criptografiaDTO.userDocument())
                                                .creditCardToken(criptografiaDTO.creditCardToken())
                                                .value(criptografiaDTO.value())
                                                .build();

        return criptografarDados(criptografiaRepo.save(criptografia));
    }

    @Override
    public Criptografia alterarDados(Criptografia criptografia) {

        boolean existe = criptografiaRepo.existsById(criptografia.getId());

        if (existe) {
            return criptografarDados(criptografiaRepo.save(criptografia));
        } else throw new IllegalArgumentException("Dados não encontrados, não é possivel alterar!");
    }

    @Override
    public void deletarDados(Long id) {
        criptografiaRepo.deleteById(id);
    }

    @Override
    public Criptografia criptografarDados(Criptografia criptografia) {
        if (Objects.isNull(criptografia)) return null;

        String userDocument = criptografia.getUserDocument();
        String creditCardToken = criptografia.getCreditCardToken();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] encodedHashUser = digest.digest(userDocument.getBytes(StandardCharsets.UTF_8));
            byte[] encodedHashCredit = digest.digest(creditCardToken.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexStringUser = new StringBuilder(2 * encodedHashUser.length);
            StringBuilder hexStringCredit = new StringBuilder(2 * encodedHashCredit.length);

            for (byte b : encodedHashUser) {
                String hex = String.format("%02x", b);
                hexStringUser.append(hex);
            }

            for (byte b : encodedHashCredit) {
                String hex = String.format("%02x", b);
                hexStringCredit.append(hex);
            }

            criptografia.setCreditCardToken(hexStringCredit.toString());
            criptografia.setUserDocument(hexStringUser.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return criptografia;
    }
}
