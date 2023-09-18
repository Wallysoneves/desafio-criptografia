package br.com.desafiocriptografia.repository;

import br.com.desafiocriptografia.model.Criptografia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("criptografiaRepo")
public interface CriptografiaRepo extends JpaRepository<Criptografia, Long> {
}
