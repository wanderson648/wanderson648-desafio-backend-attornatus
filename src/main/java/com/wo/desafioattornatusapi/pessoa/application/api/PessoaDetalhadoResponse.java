package com.wo.desafioattornatusapi.pessoa.application.api;

import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class PessoaDetalhadoResponse {
    UUID idPessoa;
    String nome;
    LocalDate dataDeNascimento;
    LocalDateTime dataHoraDoCadastro;

    public PessoaDetalhadoResponse(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nome = pessoa.getNome();
        this.dataDeNascimento = pessoa.getDataDeNascimento();
        this.dataHoraDoCadastro = pessoa.getDataHoraDoCadastro();
    }
}
