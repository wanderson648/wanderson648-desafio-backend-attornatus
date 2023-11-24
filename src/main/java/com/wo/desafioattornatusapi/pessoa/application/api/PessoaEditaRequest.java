package com.wo.desafioattornatusapi.pessoa.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;

@Value
public class PessoaEditaRequest {
    @NotBlank
    String nome;
    @NotNull
    LocalDate dataDeNascimento;

}
