package br.com.luisbraga.projetoClinica.domain.service.impl;

import br.com.luisbraga.projetoClinica.domain.entity.Paciente;
import br.com.luisbraga.projetoClinica.domain.repository.PacienteRepository;
import br.com.luisbraga.projetoClinica.domain.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente criarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> buscarPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente buscarPacientePorId(UUID id) {
        return pacienteRepository.findById(id).orElseThrow();
    }

    @Override
    public Paciente atualizarPaciente(UUID id, Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletarPaciente(UUID id) {
        pacienteRepository.deleteById(id);
    }
}
