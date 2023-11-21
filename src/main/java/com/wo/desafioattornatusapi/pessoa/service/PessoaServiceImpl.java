package com.wo.desafioattornatusapi.pessoa.service;

import com.wo.desafioattornatusapi.pessoa.application.api.PessoaRequest;
import com.wo.desafioattornatusapi.pessoa.application.api.PessoaResponse;
import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;
import com.wo.desafioattornatusapi.pessoa.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    @Override
    public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoaServiceImpl - criaPessoa");
        Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
        log.info("[finaliza] PessoaServiceImpl - criaPessoa");
        return PessoaResponse.builder().idPessoa(pessoa.getIdPessoa()).build();
    }
}
