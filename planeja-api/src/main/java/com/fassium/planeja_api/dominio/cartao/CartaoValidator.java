package com.fassium.planeja_api.dominio.cartao;

import com.fassium.planeja_api.common.validation.CampoInvalido;
import com.fassium.planeja_api.common.validation.ValidationResult;
import com.fassium.planeja_api.dominio.cartao.dto.CartaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CartaoValidator {

    @Autowired
    private CartaoRepository cartaoRepository;

    public ValidationResult validar(CartaoForm form, UUID id) {
        var result = ValidationResult.novo();

        var isListaNaoVazia = !cartaoRepository.findByNomeAndNotId(form.nome(), id).isEmpty();
        if (isListaNaoVazia) {
            result.add(new CampoInvalido("nome", "Já cadastrado."));
        }

        return result;
    }
}
