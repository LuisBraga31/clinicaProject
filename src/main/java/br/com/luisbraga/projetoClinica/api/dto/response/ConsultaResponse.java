package br.com.luisbraga.projetoClinica.api.dto.response;

import br.com.luisbraga.projetoClinica.domain.entity.Clinica;
import br.com.luisbraga.projetoClinica.domain.entity.Dentista;
import br.com.luisbraga.projetoClinica.domain.entity.Paciente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class ConsultaResponse {

    private UUID id;
    private LocalDate dataConsulta;
    private Instant createdAt;
    private Instant updateAt;
    private String descricacao;
    private Boolean cancelada;
    private String motivoCancelamento;
}
