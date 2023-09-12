package br.com.luisbraga.projetoClinica.api.dto.response.Wrapper;

import br.com.luisbraga.projetoClinica.api.dto.response.List.ClinicaListResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClinicaResponseWrapper {
    private List<ClinicaListResponse> clinicas;
}
