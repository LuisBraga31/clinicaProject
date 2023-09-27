package br.com.luisbraga.projetoClinica.api.dto.response.List;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class ConsultaListResponse {

    private UUID id;
    private LocalDate dataConsulta;

}
