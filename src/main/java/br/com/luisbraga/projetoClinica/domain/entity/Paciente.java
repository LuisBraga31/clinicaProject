package br.com.luisbraga.projetoClinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco" , referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_paciente_endereco"))
    private Endereco endereco;
    private Instant createdAt;
    private Instant updateAt;
    private SexoEnum sexo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato" , referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_paciente_contato"))
    private Contato contato;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente", foreignKey = @ForeignKey(name="fk_paciente_consulta"))
    private Set<Consulta> consultas;

}
