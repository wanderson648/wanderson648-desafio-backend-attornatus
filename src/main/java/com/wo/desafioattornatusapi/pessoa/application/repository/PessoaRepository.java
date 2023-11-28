package com.wo.desafioattornatusapi.pessoa.application.repository;

import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);
    List<Pessoa> buscarTodasAsPessoas();
    Pessoa buscarPessoaPorId(UUID idPessoa);
}
