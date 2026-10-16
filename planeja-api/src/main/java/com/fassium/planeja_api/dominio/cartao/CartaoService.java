package com.fassium.planeja_api.dominio.cartao;

import com.fassium.planeja_api.common.exceptions.RegistroNaoEncontradoException;
import com.fassium.planeja_api.common.exceptions.ValidationException;
import com.fassium.planeja_api.dominio.cartao.dto.CartaoDetalhes;
import com.fassium.planeja_api.dominio.cartao.dto.CartaoForm;
import com.fassium.planeja_api.dominio.cartao.mapper.CartaoMapper;
import com.fassium.planeja_api.dominio.cartao.model.CartaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CartaoService {

    @Autowired
    private CartaoValidator cartaoValidator;
    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private CartaoMapper cartaoMapper;

    public CartaoDetalhes criar(CartaoForm form) {
        var result = cartaoValidator.validar(form);

        if (result.isInvalido()) {
            throw new ValidationException(result.getCamposInvalidos());
        }

        CartaoEntity entity = cartaoMapper.toEntity(form);
        entity = cartaoRepository.save(entity);
        return cartaoMapper.toDetalhes(entity);
    }

    public CartaoDetalhes obterDetalhesPorId(UUID id) {
        return cartaoRepository.findById(id)
                .map(cartaoMapper::toDetalhes)
                .orElseThrow( () -> new RegistroNaoEncontradoException() );
    }

}
