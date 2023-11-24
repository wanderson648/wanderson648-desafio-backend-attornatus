package com.wo.desafioattornatusapi.endereco.application.infra;

import com.wo.desafioattornatusapi.endereco.application.repository.EnderecoRepository;
import com.wo.desafioattornatusapi.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
@Log4j2
@RequiredArgsConstructor
public class EnderecoRepositoryImpl implements EnderecoRepository {
    private final EnderecoSpringJpaRepository enderecoSpringJpaRepository;

    @Override
    public Endereco salvaEndereco(Endereco endereco) {
        log.info("[inicia] EnderecoRepositoryImpl - salvaEnd");
        log.info("[finaliza] EnderecoRepositoryImpl - salvaEnd");
        return enderecoSpringJpaRepository.save(endereco);
    }

    @Override
    public List<Endereco> buscaEnderecosPessoaComId(UUID idPessoa) {
        log.info("[inicia] EnderecoRepositoryImpl - buscaEnderecosPessoaComId");
        var enderecos = enderecoSpringJpaRepository.findByIdPessoaEndereco(idPessoa);
        log.info("[finaliza] EnderecoRepositoryImpl - buscaEnderecosPessoaComId");
        return enderecos;
    }
}
