package com.fassium.planeja_api.dominio.cartao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "cartao")
@Getter
@Setter
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 30)
    private String nome;

    @Column(name = "bandeira")
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime dataCadastro;

    @PrePersist
    void prePersist() {
        this.dataCadastro = LocalDateTime.now();
    }

}
