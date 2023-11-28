package com.wo.desafioattornatusapi.pessoa.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PessoaResponse {
    UUID idPessoa;
}
