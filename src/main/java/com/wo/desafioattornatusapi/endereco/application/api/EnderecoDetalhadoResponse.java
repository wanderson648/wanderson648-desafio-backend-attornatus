package com.wo.desafioattornatusapi.endereco.application.api;

import lombok.Value;

import java.util.UUID;

@Value
public class EnderecoDetalhadoResponse {
    UUID idEndereco;
    String logadouro;
    String cep;
    String numero;
    String cidade;
    Boolean principal;
}
