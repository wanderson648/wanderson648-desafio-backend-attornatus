package com.wo.desafioattornatusapi.endereco.application.util;

import com.wo.desafioattornatusapi.endereco.application.api.EnderecoRequest;

public class EnderecoRequestCreator {
    public static EnderecoRequest createEnderecoRequest() {
        return EnderecoRequest.builder()
                .logadouro("logadouro")
                .cep("504704203")
                .numero("123456")
                .cidade("cidade")
                .principal(false)
                .build();
    }
}
