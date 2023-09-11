package br.com.luisbraga.projetoClinica.domain.service.impl;

import br.com.luisbraga.projetoClinica.domain.entity.Contato;
import br.com.luisbraga.projetoClinica.domain.repository.ContatoRepository;
import br.com.luisbraga.projetoClinica.domain.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository contatoRepository;

    @Autowired
    public ContatoServiceImpl(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Override
    public Contato criarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public List<Contato> buscarContatos() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato buscarContatoPorId(UUID id) {
        return contatoRepository.findById(id).orElseThrow();
    }

    @Override
    public Contato atualizarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public void deletarContato(UUID id) {
        contatoRepository.deleteById(id);
    }
}
