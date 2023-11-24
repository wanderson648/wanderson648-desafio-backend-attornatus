package com.wo.desafioattornatusapi.endereco.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.util.UUID;

@Value
public class EnderecoRequest {
    @NotBlank
    String logadouro;
    @NotBlank
    String cep;
    @NotBlank
    String numero;
    @NotBlank
    String cidade;
}
