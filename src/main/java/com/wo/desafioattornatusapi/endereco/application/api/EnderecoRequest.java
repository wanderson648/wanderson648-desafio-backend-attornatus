package com.wo.desafioattornatusapi.endereco.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class EnderecoRequest {
    @NotBlank
    String logadouro;
    @NotBlank
    String cep;
    @NotBlank
    String numero;
    @NotBlank
    String cidade;
    @NotNull
    Boolean principal;
}
