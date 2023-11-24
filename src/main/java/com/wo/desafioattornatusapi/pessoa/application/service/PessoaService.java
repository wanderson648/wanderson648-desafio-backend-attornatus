package com.wo.desafioattornatusapi.pessoa.application.service;

import com.wo.desafioattornatusapi.pessoa.application.api.PessoaDetalhadoResponse;
import com.wo.desafioattornatusapi.pessoa.application.api.PessoaListResponse;
import com.wo.desafioattornatusapi.pessoa.application.api.PessoaRequest;
import com.wo.desafioattornatusapi.pessoa.application.api.PessoaResponse;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
    List<PessoaListResponse> getPessoas();
    PessoaDetalhadoResponse getPessoaId(UUID idPessoa);
}
