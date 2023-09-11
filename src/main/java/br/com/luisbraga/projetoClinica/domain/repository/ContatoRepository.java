package br.com.luisbraga.projetoClinica.domain.repository;

import br.com.luisbraga.projetoClinica.domain.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, UUID> {
}
