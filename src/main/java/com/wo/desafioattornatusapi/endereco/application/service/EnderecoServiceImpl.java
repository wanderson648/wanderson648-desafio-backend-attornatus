package com.wo.desafioattornatusapi.endereco.application.service;

import com.wo.desafioattornatusapi.endereco.application.api.EnderecoRequest;
import com.wo.desafioattornatusapi.endereco.application.api.EnderecoResponse;
import com.wo.desafioattornatusapi.endereco.application.repository.EnderecoRepository;
import com.wo.desafioattornatusapi.endereco.domain.Endereco;
import com.wo.desafioattornatusapi.pessoa.application.service.PessoaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
public class EnderecoServiceImpl implements EnderecoService {

    private final PessoaService pessoaService;
    private final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(PessoaService pessoaService, EnderecoRepository enderecoRepository) {
        this.pessoaService = pessoaService;
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
        log.info("[inicia] EnderecoController - postEndereco");
        pessoaService.getPessoaId(idPessoa);
        Endereco endereco = enderecoRepository.salvaEndereco(new Endereco(idPessoa, enderecoRequest));
        log.info("[finaliza] EnderecoController - postEndereco");
        return new EnderecoResponse(endereco.getIdEndereco());
    }
}
