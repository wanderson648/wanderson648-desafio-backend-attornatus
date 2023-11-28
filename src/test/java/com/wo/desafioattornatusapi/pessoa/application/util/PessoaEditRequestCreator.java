package com.wo.desafioattornatusapi.pessoa.application.util;

import com.wo.desafioattornatusapi.pessoa.application.api.PessoaEditaRequest;
import com.wo.desafioattornatusapi.pessoa.application.api.PessoaRequest;

import java.time.LocalDate;

public class PessoaEditRequestCreator {
    public static PessoaEditaRequest createPessoaRequest() {
        return PessoaEditaRequest.builder()
                .nome(PessoaCreator.createUpdatePessoa().getNome())
                .dataDeNascimento(PessoaCreator.createUpdatePessoa().getDataDeNascimento())
                .build();
    }
}
