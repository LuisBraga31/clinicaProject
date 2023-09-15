package br.com.luisbraga.projetoClinica.api.dto.response;

import br.com.luisbraga.projetoClinica.domain.entity.Contato;
import br.com.luisbraga.projetoClinica.domain.entity.Endereco;
import br.com.luisbraga.projetoClinica.domain.entity.SexoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class PacienteResponse {

    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    private SexoEnum sexo;
    private Instant createdAt;
    private Instant updateAt;
    private EnderecoResponse endereco;
    private ContatoResponse contato;

}
