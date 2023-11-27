package com.wo.desafioattornatusapi.pessoa.application.util;

import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;

import java.time.LocalDate;
import java.util.UUID;

public class PessoaCreator {
    private static final UUID pessoaId = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");
    public static Pessoa createPessoaToBeSaved() {
        return Pessoa.builder()
                .nome("wanderson")
                .dataDeNascimento(LocalDate.of(1996, 9, 14))
                .build();
    }

    public static Pessoa createValidPessoa() {
        return Pessoa.builder()
                .idPessoa(pessoaId)
                .nome("wanderosn")
                .dataDeNascimento(LocalDate.of(1996, 9, 14)).build();
    }

    public static Pessoa createUpdatePessoa() {
        return Pessoa.builder()
                .idPessoa(pessoaId)
                .nome("mateus")
                .dataDeNascimento(LocalDate.of(1997, 2, 27)).build();
    }

}
