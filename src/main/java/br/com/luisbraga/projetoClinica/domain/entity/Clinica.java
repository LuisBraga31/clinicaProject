package br.com.luisbraga.projetoClinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "clinicas")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;
    private String nome;
    @Column(length = 20)
    private String cnpj;
    private String razaoSocial;
    private Instant createdAt;
    private Instant updateAt;
    private String descricao;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco" , referencedColumnName = "id")
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato" , referencedColumnName = "id")
    private Contato contato;

}
