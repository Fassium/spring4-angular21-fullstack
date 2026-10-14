package com.fassium.planeja_api.infra;

import com.fassium.planeja_api.dominio.cartao.CartaoRepository;
import com.fassium.planeja_api.dominio.cartao.model.BandeiraCartao;
import com.fassium.planeja_api.dominio.cartao.model.CartaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sandbox implements CommandLineRunner {

    @Autowired
    private CartaoRepository cartaoRepository;

    public void salvarCartao() {
        CartaoEntity cartao = new CartaoEntity();
        cartao.setNome("ITAU Personalité");
        cartao.setBandeira(BandeiraCartao.AMERICAN_EXPRESS);

        cartaoRepository.save(cartao);

    }

    @Override
    public void run(String... args) throws Exception {
        salvarCartao();
    }
}
