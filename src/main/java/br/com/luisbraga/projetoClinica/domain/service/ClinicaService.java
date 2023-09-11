package br.com.luisbraga.projetoClinica.domain.service;

import br.com.luisbraga.projetoClinica.domain.entity.Clinica;

import java.util.List;
import java.util.UUID;

public interface ClinicaService {

    Clinica criarClinica(Clinica clinica);
    List<Clinica> buscarClinicas();
    Clinica buscarClinicaPorId(UUID id);
    Clinica atualizarClinica(Clinica clinica);
    void deletarClinica(UUID id);

}
