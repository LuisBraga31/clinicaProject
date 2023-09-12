package br.com.luisbraga.projetoClinica.api.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ContatoRequest {

    @NotNull
    private String email;
    @NotNull
    private String telefone;
}
