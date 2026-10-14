package com.fassium.planeja_api.dominio.cartao.dto;

import com.fassium.planeja_api.dominio.cartao.model.BandeiraCartao;

public record CartaoForm(String nome, BandeiraCartao bandeira) {
}
