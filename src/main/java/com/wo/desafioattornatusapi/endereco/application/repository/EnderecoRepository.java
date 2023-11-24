package com.wo.desafioattornatusapi.endereco.application.repository;

import com.wo.desafioattornatusapi.endereco.domain.Endereco;

import java.util.List;
import java.util.UUID;

public interface EnderecoRepository {
    Endereco salvaEndereco(Endereco endereco);

    List<Endereco> buscaEnderecosPessoaComId(UUID idPessoa);
    Endereco buscaEnderecoPrincipal(Boolean principal);
}
