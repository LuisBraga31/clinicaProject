package br.com.luisbraga.projetoClinica.domain.service;

import br.com.luisbraga.projetoClinica.domain.entity.Endereco;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {
    Endereco criarEndereco(Endereco endereco);
    List<Endereco> buscarEnderecos();
    Endereco buscarEnderecoPorId(UUID id);
    Endereco atualizarEndereco(UUID id);
    void deletarX(UUID id);
}
