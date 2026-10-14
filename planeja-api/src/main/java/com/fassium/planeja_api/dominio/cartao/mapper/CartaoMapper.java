package com.fassium.planeja_api.dominio.cartao.mapper;

import com.fassium.planeja_api.dominio.cartao.dto.CartaoDetalhes;
import com.fassium.planeja_api.dominio.cartao.dto.CartaoForm;
import com.fassium.planeja_api.dominio.cartao.model.CartaoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartaoMapper {
    CartaoEntity toEntity(CartaoForm form);
    CartaoDetalhes toDetalhes(CartaoEntity entity);
}
