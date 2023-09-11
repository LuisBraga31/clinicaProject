package br.com.luisbraga.projetoClinica.domain.service.impl;

import br.com.luisbraga.projetoClinica.domain.entity.Clinica;
import br.com.luisbraga.projetoClinica.domain.repository.ClinicaRepository;
import br.com.luisbraga.projetoClinica.domain.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicaServiceImpl implements ClinicaService {

    private final ClinicaRepository clinicaRepository;

    @Autowired
    public ClinicaServiceImpl(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }


    @Override
    public Clinica criarClinica(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    @Override
    public List<Clinica> buscarClinicas() {
        return clinicaRepository.findAll();
    }

    @Override
    public Clinica buscarClinicaPorId(UUID id) {
        return clinicaRepository.findById(id).orElseThrow();
    }

    @Override
    public Clinica atualizarClinica(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    @Override
    public void deletarClinica(UUID id) {
        clinicaRepository.deleteById(id);
    }
}
