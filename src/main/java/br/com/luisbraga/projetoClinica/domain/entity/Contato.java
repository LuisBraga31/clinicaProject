package br.com.luisbraga.projetoClinica.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;
    @Column(length = 100)
    @Email
    private String email;
    @Column(length = 15)
    @Pattern(regexp = "\\((\\d{2})\\) (\\d{4,5})-(\\d{4})")
    private String telefone;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @PrePersist
    public void naCriacao() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void naAtualizacao() {
        this.updateAt = LocalDateTime.now();
    }

}
