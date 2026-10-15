package com.fassium.planeja_api.dominio.cartao;

import com.fassium.planeja_api.common.validation.CampoInvalido;
import com.fassium.planeja_api.common.validation.ValidationResult;
import com.fassium.planeja_api.dominio.cartao.dto.CartaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoValidator {

    @Autowired
    private CartaoRepository cartaoRepository;

    public ValidationResult validar(CartaoForm form) {
        var result = ValidationResult.novo();

        if (cartaoRepository.findByNome(form.nome()).isPresent()) {
            result.add(new CampoInvalido("nome: "+form.nome(), "Já cadastrado."));
        }

        return result;
    }
}
