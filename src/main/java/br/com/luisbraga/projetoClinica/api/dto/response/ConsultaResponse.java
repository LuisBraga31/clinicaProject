package br.com.luisbraga.projetoClinica.api.dto.response;

import br.com.luisbraga.projetoClinica.domain.entity.Clinica;
import br.com.luisbraga.projetoClinica.domain.entity.Dentista;
import br.com.luisbraga.projetoClinica.domain.entity.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ConsultaResponse {

    private UUID id;
    private UUID paciente;
    private UUID dentista;
    private UUID clinica;
    private LocalDate dataConsulta;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String descricao;
    private Boolean cancelada;
    private String motivoCancelamento;
}
