package br.com.luisbraga.projetoClinica.domain.service;

import br.com.luisbraga.projetoClinica.domain.entity.Contato;

import java.util.List;
import java.util.UUID;

public interface ContatoService {
    Contato criarContato(Contato contato);
    List<Contato> buscarContatos();
    Contato buscarContatoPorId(UUID id);
    Contato atualizarContato(UUID id);
    void deletarContato(UUID id);
}
