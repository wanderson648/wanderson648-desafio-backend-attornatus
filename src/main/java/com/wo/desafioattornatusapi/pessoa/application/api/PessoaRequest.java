package com.wo.desafioattornatusapi.pessoa.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Value
@Builder
public class PessoaRequest {
    @NotBlank
    String nome;
    @NotNull
    LocalDate dataDeNascimento;
}
