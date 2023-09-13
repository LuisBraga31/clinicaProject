package br.com.luisbraga.projetoClinica.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ClinicaRequest {

    @NotNull
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
