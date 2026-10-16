package com.fassium.planeja_api.dominio.cartao;

import com.fassium.planeja_api.common.exceptions.RegistroNaoEncontradoException;
import com.fassium.planeja_api.common.exceptions.ValidationException;
import com.fassium.planeja_api.dominio.cartao.dto.CartaoDetalhes;
import com.fassium.planeja_api.dominio.cartao.dto.CartaoForm;
import com.fassium.planeja_api.dominio.cartao.mapper.CartaoMapper;
import com.fassium.planeja_api.dominio.cartao.model.CartaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

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
    @Autowired
    private Validator validator;

    public CartaoDetalhes criar(CartaoForm form) {
        var result = cartaoValidator.validar(form, null);

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
                .orElseThrow(RegistroNaoEncontradoException::new);
    }

    @Transactional
    public void atualizar(UUID id, CartaoForm dadosAtualizacao) {
        var entity = cartaoRepository.findById(id).orElseThrow(RegistroNaoEncontradoException::new);

        var result = cartaoValidator.validar(dadosAtualizacao, id);

        if (result.isInvalido()) {
            throw new ValidationException(result.getCamposInvalidos());
        }

        cartaoMapper.update(entity, dadosAtualizacao);
    }
}
