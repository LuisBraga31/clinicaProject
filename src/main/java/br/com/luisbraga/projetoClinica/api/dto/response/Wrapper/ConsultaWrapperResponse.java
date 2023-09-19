package br.com.luisbraga.projetoClinica.api.dto.response.Wrapper;

import br.com.luisbraga.projetoClinica.api.dto.response.List.ConsultaListResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConsultaWrapperResponse {
    List<ConsultaListResponse> consultas;
}
