package br.com.luisbraga.projetoClinica.domain.service.impl;

import br.com.luisbraga.projetoClinica.domain.entity.Clinica;
import br.com.luisbraga.projetoClinica.domain.exception.BadRequestCnpjException;
import br.com.luisbraga.projetoClinica.domain.exception.NotFoundException;
import br.com.luisbraga.projetoClinica.domain.repository.ClinicaRepository;
import br.com.luisbraga.projetoClinica.domain.service.ClinicaService;
import lombok.extern.slf4j.Slf4j;
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
        boolean cnpjExiste = this.clinicaRepository.existsByCnpj(clinica.getCnpj());
        if (cnpjExiste){
            throw new BadRequestCnpjException(clinica.getCnpj());
        }
        return clinicaRepository.save(clinica);
    }

    @Override
    public List<Clinica> buscarClinicas(String termo) {
        return clinicaRepository.findAll();
    }

    @Override
    public Clinica buscarClinicaPorId(UUID id) {
        try {
            return clinicaRepository.findById(id)
                                    .orElseThrow();
        } catch (Exception e) {
            throw new NotFoundException(id);
        }

    }

    @Override
    public Clinica atualizarClinica(UUID id, Clinica clinica) {
        try {
            clinicaRepository.findById(id);
        } catch (Exception e) {
            throw new NotFoundException(id);
        }
        return clinicaRepository.save(clinica);
    }

    @Override
    public void deletarClinica(UUID id) {
        try {
            clinicaRepository.findById(id).orElseThrow();
            clinicaRepository.deleteById(id);
        } catch (Exception e){
            throw new NotFoundException(id);
        }

    }

}
