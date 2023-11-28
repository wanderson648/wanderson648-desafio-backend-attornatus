package com.wo.desafioattornatusapi.pessoa.application.util;

import com.wo.desafioattornatusapi.pessoa.application.api.PessoaRequest;

import java.time.LocalDate;

public class PessoaRequestCreator {
    public static PessoaRequest createPessoaRequest() {
        return PessoaRequest.builder()
                .nome("wanderson")
                .dataDeNascimento(LocalDate.of(1996, 9, 14))
                .build();
    }
}
