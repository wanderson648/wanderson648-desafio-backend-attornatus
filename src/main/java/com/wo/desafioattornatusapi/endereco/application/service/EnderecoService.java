package com.wo.desafioattornatusapi.endereco.application.service;

import com.wo.desafioattornatusapi.endereco.application.api.*;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {
    EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest endereco);
    List<EnderecoPessoaListResponse> buscaEnderecoDePessoaPorId(UUID idPessoa);
    EnderecoPrincipalDetalhado buscaEnderecoPrincipal(Boolean principal, UUID idPessoa);
}
