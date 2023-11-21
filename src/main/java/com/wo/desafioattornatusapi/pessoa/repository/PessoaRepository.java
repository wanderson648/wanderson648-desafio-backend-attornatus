package com.wo.desafioattornatusapi.pessoa.repository;

import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);
}
