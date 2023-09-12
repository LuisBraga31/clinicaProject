package br.com.luisbraga.projetoClinica.api.dto.response;

import br.com.luisbraga.projetoClinica.api.dto.request.ContatoRequest;
import br.com.luisbraga.projetoClinica.api.dto.request.EnderecoRequest;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ClinicaResponse {

    private UUID id;
    private String nome;
    @CNPJ
    private String cnpj;
    private String razaoSocial;
    private String descricao;
    private EnderecoResponse endereco;
    private ContatoResponse contato;

}
