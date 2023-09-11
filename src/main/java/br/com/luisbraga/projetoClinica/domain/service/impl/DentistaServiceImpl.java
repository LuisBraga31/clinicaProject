package br.com.luisbraga.projetoClinica.domain.service.impl;

import br.com.luisbraga.projetoClinica.domain.entity.Dentista;
import br.com.luisbraga.projetoClinica.domain.repository.DentistaRepository;
import br.com.luisbraga.projetoClinica.domain.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DentistaServiceImpl implements DentistaService {

    private final DentistaRepository dentistaRepository;

    @Autowired
    public DentistaServiceImpl(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    @Override
    public Dentista criarDentista(Dentista dentista) {
        return dentistaRepository.save(dentista);
    }

    @Override
    public List<Dentista> buscarDentistas() {
        return dentistaRepository.findAll();
    }

    @Override
    public Dentista buscarDentistaPorId(UUID id) {
        return dentistaRepository.findById(id).orElseThrow();
    }

    @Override
    public Dentista atualizarDentista(Dentista dentista) {
        return dentistaRepository.save(dentista);
    }

    @Override
    public void deletarDentista(UUID id) {
        dentistaRepository.deleteById(id);
    }
}
