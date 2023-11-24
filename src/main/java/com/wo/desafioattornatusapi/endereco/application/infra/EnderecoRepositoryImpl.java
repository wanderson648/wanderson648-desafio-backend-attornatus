package com.wo.desafioattornatusapi.endereco.application.infra;

import com.wo.desafioattornatusapi.endereco.application.repository.EnderecoRepository;
import com.wo.desafioattornatusapi.endereco.domain.Endereco;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;


@Repository
@Log4j2

public class EnderecoRepositoryImpl implements EnderecoRepository {
    private final EnderecoSpringJpaRepository enderecoSpringJpaRepository;
    public EnderecoRepositoryImpl(EnderecoSpringJpaRepository enderecoSpringJpaRepository) {
        this.enderecoSpringJpaRepository = enderecoSpringJpaRepository;
    }

    @Override
    public Endereco salvaEndereco(Endereco endereco) {
        log.info("[inicia] EnderecoRepositoryImpl - salvaEnd");
        log.info("[finaliza] EnderecoRepositoryImpl - salvaEnd");
        return enderecoSpringJpaRepository.save(endereco);
    }
}
