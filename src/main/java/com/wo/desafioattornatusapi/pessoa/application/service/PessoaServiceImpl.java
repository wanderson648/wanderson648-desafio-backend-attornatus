package com.wo.desafioattornatusapi.pessoa.application.service;

import com.wo.desafioattornatusapi.pessoa.application.api.*;
import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;
import com.wo.desafioattornatusapi.pessoa.application.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<PessoaListResponse> getPessoas() {
        log.info("[inicia] PessoaServiceImpl - getPessoas");
        List<Pessoa> pessoas = pessoaRepository.buscarTodasAsPessoas();
        log.info("[finaliza] PessoaServiceImpl - getPessoas");
        return PessoaListResponse.coverte(pessoas);
    }

    @Override
    public PessoaDetalhadoResponse getPessoaId(UUID idPessoa) {
        log.info("[inicia] PessoaServiceImpl - getPessoas");
        Pessoa pessoa = pessoaRepository.buscarPessoaPorId(idPessoa);
        log.info("[finaliza] PessoaServiceImpl - getPessoas");
        return new PessoaDetalhadoResponse(pessoa);
    }

    @Override
    public void patchEditaPessoa(UUID idPessoa, PessoaEditaRequest pessoaEditaRequest) {
        log.info("[inicia] PessoaServiceImpl - patchEditaPessoa");
        Pessoa pessoa = pessoaRepository.buscarPessoaPorId(idPessoa);
        pessoa.editaPessoa(pessoaEditaRequest);
        pessoaRepository.salva(pessoa);
        log.info("[finaliza] PessoaServiceImpl - patchEditaPessoa");
    }
}
