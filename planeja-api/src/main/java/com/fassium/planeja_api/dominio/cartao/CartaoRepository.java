package com.fassium.planeja_api.dominio.cartao;

import com.fassium.planeja_api.dominio.cartao.model.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, UUID> {
}
