package com.wo.desafioattornatusapi.pessoa.application.service;

import com.wo.desafioattornatusapi.pessoa.application.api.*;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
    List<PessoaListResponse> getPessoas();
    PessoaDetalhadoResponse getPessoaId(UUID idPessoa);
    void patchEditaPessoa(UUID idPessoa, PessoaEditaRequest pessoaEditaRequest);
}
