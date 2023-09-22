package br.com.luisbraga.projetoClinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;
    @Column(length = 100)
    private String logradouro;
    @Column(length = 100)
    private String bairro;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    @Column(length = 100)
    private String cidade;
    @Column(length = 100)
    private String estado;
    @Column(length = 10)
    private String cep;

    @PrePersist
    public void naCriacao() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void naAtualizacao() {
        this.updateAt = LocalDateTime.now();
    }

}
