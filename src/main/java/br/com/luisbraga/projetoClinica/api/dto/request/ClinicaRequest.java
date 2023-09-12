package br.com.luisbraga.projetoClinica.api.dto.request;

import br.com.luisbraga.projetoClinica.domain.entity.Contato;
import br.com.luisbraga.projetoClinica.domain.entity.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ClinicaRequest {

    @NotBlank
    private String nome;
    @CNPJ
    private String cnpj;
    @NotNull
    private String razaoSocial;
    @NotNull
    private String descricao;
    @NotNull
    private EnderecoRequest endereco;
    @NotNull
    private ContatoRequest contato;
}
