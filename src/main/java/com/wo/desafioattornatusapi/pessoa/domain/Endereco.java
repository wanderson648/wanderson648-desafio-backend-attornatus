package com.wo.desafioattornatusapi.pessoa.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @NotBlank
    private String logadouro;
    @NotBlank
    private String cep;
    @NotBlank
    private String numero;
    @NotBlank
    private String cidade;
}
