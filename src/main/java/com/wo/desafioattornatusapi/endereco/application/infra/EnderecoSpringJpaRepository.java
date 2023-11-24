package com.wo.desafioattornatusapi.endereco.application.infra;

import com.wo.desafioattornatusapi.endereco.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoSpringJpaRepository extends JpaRepository<Endereco, UUID> {
}