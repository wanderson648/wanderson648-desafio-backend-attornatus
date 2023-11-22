package com.wo.desafioattornatusapi.pessoa.application.api;

import com.wo.desafioattornatusapi.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {

    private final PessoaService pessoaService;
    @Override
    public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoaController - postPessoa");
        PessoaResponse pessoaResponse = pessoaService.criaPessoa(pessoaRequest);
        log.info("[finaliza] PessoaController - postPessoa");
        return pessoaResponse;
    }

    @Override
    public List<PessoaListResponse> getPessoas() {
        log.info("[inicia] PessoaController - getPessoas");
        List<PessoaListResponse> pessoas = pessoaService.getPessoas();
        log.info("[finaliza] PessoaController - getPessoas");
        return pessoas;
    }
}
