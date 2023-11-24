package com.wo.desafioattornatusapi.endereco.application.api;

import com.wo.desafioattornatusapi.endereco.application.service.EnderecoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
public class EnderecoController implements EnderecoAPI {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @Override
    public EnderecoResponse postEndereco(UUID idPessoa, EnderecoRequest endereco) {
        log.info("[inicia] EnderecoController - postEndereco");
        EnderecoResponse enderecoResponse = enderecoService.criaEndereco(idPessoa, endereco);
        log.info("[finaliza] EnderecoController - postEndereco");
        return enderecoResponse;
    }
}
