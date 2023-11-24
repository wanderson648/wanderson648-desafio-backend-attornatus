package com.wo.desafioattornatusapi.endereco.application.service;

import com.wo.desafioattornatusapi.endereco.application.api.EnderecoRequest;
import com.wo.desafioattornatusapi.endereco.application.api.EnderecoResponse;

import java.util.UUID;

public interface EnderecoService {
    EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest endereco);
}
