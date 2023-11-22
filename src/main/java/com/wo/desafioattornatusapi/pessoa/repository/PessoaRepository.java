package com.wo.desafioattornatusapi.pessoa.repository;

import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;

import java.util.List;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);
    List<Pessoa> buscarTodasAsPessoas();
}
