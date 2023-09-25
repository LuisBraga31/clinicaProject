package br.com.luisbraga.projetoClinica.domain.service;

import br.com.luisbraga.projetoClinica.domain.entity.Dentista;

import java.util.List;
import java.util.UUID;

public interface DentistaService {
    Dentista criarDentista(Dentista dentista);
    List<Dentista> buscarDentistas(String termo);
    Dentista buscarDentistaPorId(UUID id);
    Dentista atualizarDentista(UUID id, Dentista dentista);
    void deletarDentista(UUID id);
}
