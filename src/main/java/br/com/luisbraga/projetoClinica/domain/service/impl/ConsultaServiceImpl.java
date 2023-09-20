package br.com.luisbraga.projetoClinica.domain.service.impl;

import br.com.luisbraga.projetoClinica.domain.entity.Consulta;
import br.com.luisbraga.projetoClinica.domain.exception.NotFoundException;
import br.com.luisbraga.projetoClinica.domain.repository.ConsultaRepository;
import br.com.luisbraga.projetoClinica.domain.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Consulta criarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public List<Consulta> buscarConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public Consulta buscarConsultaPorId(UUID id) {
        try {
            return consultaRepository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new NotFoundException(id);
        }
    }

    @Override
    public Consulta atualizarConsulta(UUID id, Consulta consulta) {
        try {
            consultaRepository.findById(id);
        } catch (Exception e) {
            throw new NotFoundException(id);
        }
        return consultaRepository.save(consulta);
    }

    @Override
    public void deletarConsulta(UUID id) {
        try {
            consultaRepository.findById(id).orElseThrow();
            consultaRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException(id);
        }
    }
}
