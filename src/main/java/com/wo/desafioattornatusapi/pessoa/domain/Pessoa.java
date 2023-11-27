package com.wo.desafioattornatusapi.pessoa.domain;


import com.wo.desafioattornatusapi.pessoa.application.api.PessoaEditaRequest;
import com.wo.desafioattornatusapi.pessoa.application.api.PessoaRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idPessoa;
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataDeNascimento;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public Pessoa(PessoaRequest pr) {
        this.nome = pr.getNome();
        this.dataDeNascimento = pr.getDataDeNascimento();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }

    public void editaPessoa(PessoaEditaRequest pessoaEditaRequest) {
        this.nome = pessoaEditaRequest.getNome();
        this.dataDeNascimento = pessoaEditaRequest.getDataDeNascimento();
        this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
    }
}
