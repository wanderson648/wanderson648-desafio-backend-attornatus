package com.wo.desafioattornatusapi.pessoa.infra;

import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaSpringJpaRepository extends JpaRepository<Pessoa, UUID> {
}
