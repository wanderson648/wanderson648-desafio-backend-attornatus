package com.wo.desafioattornatusapi.pessoa.service;

import com.wo.desafioattornatusapi.pessoa.application.api.PessoaRequest;
import com.wo.desafioattornatusapi.pessoa.application.api.PessoaResponse;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
}
