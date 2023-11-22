package com.wo.desafioattornatusapi.pessoa.infra;

import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;
import com.wo.desafioattornatusapi.pessoa.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Pessoa> buscarTodasAsPessoas() {
        log.info("[inicia] PessoaInfraRepository - buscarTodasAsPessoas");
        List<Pessoa> pessoas = pessoaSpringJpaRepository.findAll();
        log.info("[finaliza] PessoaInfraRepository - buscarTodasAsPessoas");
        return pessoas;
    }
}
