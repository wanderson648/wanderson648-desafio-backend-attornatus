package com.wo.desafioattornatusapi.endereco.domain;

import com.wo.desafioattornatusapi.endereco.application.api.EnderecoRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idEndereco;
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idPessoa;
    @NotBlank
    private String logadouro;
    @NotBlank
    private String cep;
    @NotBlank
    private String numero;
    @NotBlank
    private String cidade;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;


    public Endereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
        this.idPessoa = idPessoa;
        this.logadouro = enderecoRequest.getLogadouro();
        this.cep = enderecoRequest.getCep();
        this.numero = enderecoRequest.getNumero();
        this.cidade = enderecoRequest.getCidade();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }
}
