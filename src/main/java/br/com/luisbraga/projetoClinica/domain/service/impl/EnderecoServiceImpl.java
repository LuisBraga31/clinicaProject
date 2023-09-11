package br.com.luisbraga.projetoClinica.domain.service.impl;


import br.com.luisbraga.projetoClinica.domain.entity.Endereco;
import br.com.luisbraga.projetoClinica.domain.repository.EnderecoRepository;
import br.com.luisbraga.projetoClinica.domain.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public List<Endereco> buscarEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco buscarEnderecoPorId(UUID id) {
        return enderecoRepository.findById(id).orElseThrow();
    }

    @Override
    public Endereco atualizarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public void deletarEndereco(UUID id) {
        enderecoRepository.deleteById(id);
    }
}
