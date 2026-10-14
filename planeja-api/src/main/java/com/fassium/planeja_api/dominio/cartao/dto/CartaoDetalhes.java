package com.fassium.planeja_api.dominio.cartao.dto;

import com.fassium.planeja_api.dominio.cartao.model.BandeiraCartao;

import java.time.LocalDateTime;

public record CartaoDetalhes(String id, String nome, BandeiraCartao bandeira, LocalDateTime dataCadastro) {
}
