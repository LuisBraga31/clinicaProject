package br.com.luisbraga.projetoClinica.api.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ContatoResponse {

    private UUID id;
    @Email
    private String email;
    private String telefone;
    private Instant createdAt;
    private Instant updateAt;
}
