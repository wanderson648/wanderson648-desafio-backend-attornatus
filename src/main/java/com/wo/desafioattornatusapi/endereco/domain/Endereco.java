package com.wo.desafioattornatusapi.endereco.domain;

import com.wo.desafioattornatusapi.endereco.application.api.EnderecoRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid",  name = "idEndereco", updatable = false, unique = true, nullable = false)
    private UUID idEndereco;
    @Column(columnDefinition = "uuid", name = "idPessoaEndereco", nullable = false)
    private UUID idPessoaEndereco;
    @NotBlank
    private String logadouro;
    @NotBlank
    private String cep;
    @NotBlank
    private String numero;
    @NotBlank
    private String cidade;
    @NotNull
    private Boolean principalEndereco;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;


    public Endereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
        this.idPessoaEndereco = idPessoa;
        this.logadouro = enderecoRequest.getLogadouro();
        this.cep = enderecoRequest.getCep();
        this.numero = enderecoRequest.getNumero();
        this.cidade = enderecoRequest.getCidade();
        this.principalEndereco = enderecoRequest.getPrincipal();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }
}
