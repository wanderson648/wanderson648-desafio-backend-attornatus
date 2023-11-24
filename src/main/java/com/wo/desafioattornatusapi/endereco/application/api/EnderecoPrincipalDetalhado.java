package com.wo.desafioattornatusapi.endereco.application.api;

import com.wo.desafioattornatusapi.endereco.domain.Endereco;
import lombok.Value;

import java.util.UUID;

@Value
public class EnderecoPrincipalDetalhado {
    UUID idEndereco;
    String logadouro;
    String cep;
    String numero;
    String cidade;
    Boolean principal;

    public EnderecoPrincipalDetalhado(Endereco endereco) {
        this.idEndereco = endereco.getIdEndereco();
        this.logadouro = endereco.getLogadouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.principal = endereco.getPrincipalEndereco();
    }
}
