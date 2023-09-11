package br.com.luisbraga.projetoClinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="paciente_id", foreignKey = @ForeignKey(name="fk_consulta_paciente"))
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="dentista_id", foreignKey = @ForeignKey(name="fk_consulta_dentista"))
    private Dentista dentista;

    @ManyToOne
    @JoinColumn(name="clinica_id", foreignKey = @ForeignKey(name="fk_consulta_clinica"))
    private Clinica clinica;

    private LocalDate dataConsulta;
    private Instant createdAt;
    private Instant updateAt;
    private String descricacao;
    private Boolean cancelada;
    @Column(length = 80)
    private String motivoCancelamento;

}
