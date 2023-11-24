package com.wo.desafioattornatusapi.endereco.application.api;

import com.wo.desafioattornatusapi.endereco.domain.Endereco;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class EnderecoPessoaListResponse {
    UUID idEndereco;
    String logadouro;
    String cep;
    String numero;
    String cidade;

    public EnderecoPessoaListResponse(Endereco endereco) {
        this.idEndereco = endereco.getIdEndereco();
        this.logadouro = endereco.getLogadouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
    }

    public static List<EnderecoPessoaListResponse> converte(List<Endereco> enderecos) {
        return enderecos.stream().map(EnderecoPessoaListResponse::new)
                .collect(Collectors.toList());
    }
}
