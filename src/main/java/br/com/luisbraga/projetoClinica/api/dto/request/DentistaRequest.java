package br.com.luisbraga.projetoClinica.api.dto.request;

import br.com.luisbraga.projetoClinica.domain.entity.EspecialdiadeEnum;
import br.com.luisbraga.projetoClinica.domain.entity.SexoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class DentistaRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String cro;
    private LocalDate dataNascimento;
    private EspecialdiadeEnum especialidade;
    private SexoEnum sexo;
    @NotNull
    private ContatoRequest contato;

   // private Set<Clinica> clinicasDentistas;
}
