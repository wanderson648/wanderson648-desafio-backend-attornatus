package com.wo.desafioattornatusapi.endereco.application.util;

import com.wo.desafioattornatusapi.endereco.domain.Endereco;

import java.time.LocalDateTime;
import java.util.UUID;

public class EnderecoCreator {
    private static final UUID enderecoId = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");
    public static Endereco createValidEndereco() {
        return Endereco.builder()
                .idEndereco(enderecoId)
                .idPessoaEndereco(UUID.randomUUID())
                .cep("72504003")
                .numero("123456")
                .cidade("cidade")
                .logadouro("logadouro")
                .principalEndereco(false)
                .dataHoraDoCadastro(LocalDateTime.now())
                .build();
    }
}