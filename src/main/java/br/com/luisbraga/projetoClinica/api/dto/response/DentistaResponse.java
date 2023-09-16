package br.com.luisbraga.projetoClinica.api.dto.response;

import br.com.luisbraga.projetoClinica.domain.entity.EspecialdiadeEnum;
import br.com.luisbraga.projetoClinica.domain.entity.SexoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class DentistaResponse {

    private UUID id;
    private String nome;
    private String cro;
    private LocalDate dataNascimento;
    private EspecialdiadeEnum especialidade;
    private SexoEnum sexo;

}
