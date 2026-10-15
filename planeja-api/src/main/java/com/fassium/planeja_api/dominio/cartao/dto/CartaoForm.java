package com.fassium.planeja_api.dominio.cartao.dto;

import com.fassium.planeja_api.dominio.cartao.model.BandeiraCartao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CartaoForm(
        @NotBlank(message = "Campo obrigatório.")
        String nome,
        @NotNull(message = "Campo obrigatório.")
        BandeiraCartao bandeira) {
}
