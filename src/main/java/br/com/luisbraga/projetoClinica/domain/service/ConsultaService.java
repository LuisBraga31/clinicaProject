package br.com.luisbraga.projetoClinica.domain.service;

import br.com.luisbraga.projetoClinica.domain.entity.Consulta;

import java.util.List;
import java.util.UUID;

public interface ConsultaService {
    Consulta criarConsulta(Consulta consulta);
    List<Consulta> buscarConsultas();
    Consulta buscarConsultaPorId(UUID id);
    Consulta atualizarConsulta(UUID id, Consulta consulta);
    void deletarConsulta(UUID id);
}
