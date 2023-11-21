package com.wo.desafioattornatusapi.pessoa.infra;

import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;
import com.wo.desafioattornatusapi.pessoa.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {

    private final PessoaSpringJpaRepository pessoaSpringJpaRepository;
    @Override
    public Pessoa salva(Pessoa pessoa) {
        log.info("[inicia] PessoaInfraRepository - criaPessoa");
        pessoaSpringJpaRepository.save(pessoa);
        log.info("[finaliza] PessoaInfraRepository - criaPessoa");
        return pessoa;
    }
}
