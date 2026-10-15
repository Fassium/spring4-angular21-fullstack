package com.fassium.planeja_api.dominio.cartao;

import com.fassium.planeja_api.dominio.cartao.dto.CartaoDetalhes;
import com.fassium.planeja_api.dominio.cartao.dto.CartaoForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<CartaoDetalhes> criar(@RequestBody @Valid CartaoForm novo){
        CartaoDetalhes detalhes = cartaoService.criar(novo);
        return  ResponseEntity.status(HttpStatus.CREATED).body(detalhes);
    }


}
