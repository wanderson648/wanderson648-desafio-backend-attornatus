package com.wo.desafioattornatusapi.endereco.application.infra;

import com.wo.desafioattornatusapi.endereco.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnderecoSpringJpaRepository extends JpaRepository<Endereco, UUID> {
    List<Endereco> findByIdPessoaEndereco(UUID idPessoaEndereco);
    Endereco findByPrincipalEndereco(Boolean principalEndereco);
}
