package com.fassium.planeja_api.dominio.cartao;

import com.fassium.planeja_api.dominio.cartao.model.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, UUID> {

    Optional<CartaoEntity> findByNome(String nome);

    @Query("""
            select c
            from CartaoEntity c
            where c.nome = :nome
              and (:id is null or c.id <> :id)
            """)
    List<CartaoEntity> findByNomeAndNotId(
            @Param("nome") String nome,
            @Param("id") UUID id);

}
