package com.fassium.planeja_api.dominio.cartao;

import com.fassium.planeja_api.dominio.cartao.dto.CartaoDetalhes;
import com.fassium.planeja_api.dominio.cartao.dto.CartaoForm;
import com.fassium.planeja_api.dominio.cartao.mapper.CartaoMapper;
import com.fassium.planeja_api.dominio.cartao.model.CartaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

    @Autowired
    private CartaoValidator cartaoValidator;
    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private CartaoMapper cartaoMapper;

    public CartaoDetalhes criar(CartaoForm form){
        cartaoValidator.validar(form);
        CartaoEntity entity = cartaoMapper.toEntity(form);
        entity = cartaoRepository.save(entity);
        return cartaoMapper.toDetalhes(entity);
    }

}
