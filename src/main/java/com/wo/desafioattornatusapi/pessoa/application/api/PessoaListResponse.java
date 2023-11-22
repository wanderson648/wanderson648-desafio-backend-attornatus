package com.wo.desafioattornatusapi.pessoa.application.api;

import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class PessoaListResponse {
    UUID idPessoa;
    String nome;
    LocalDate dataDeNascimento;

    public static List<PessoaListResponse> coverte(List<Pessoa> pessoas) {
        return pessoas.stream().map(PessoaListResponse::new).collect(Collectors.toList());
    }

    public PessoaListResponse(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nome = pessoa.getNome();
        this.dataDeNascimento = pessoa.getDataDeNascimento();
    }
}
