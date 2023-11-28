package com.wo.desafioattornatusapi.endereco.application.api;

import com.wo.desafioattornatusapi.endereco.application.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EnderecoController implements EnderecoAPI {

    private final EnderecoService enderecoService;

    @Override
    public EnderecoResponse postEndereco(UUID idPessoa, EnderecoRequest endereco) {
        log.info("[inicia] EnderecoController - postEndereco");
        EnderecoResponse enderecoResponse = enderecoService.criaEndereco(idPessoa, endereco);
        log.info("[finaliza] EnderecoController - postEndereco");
        return enderecoResponse;
    }

    @Override
    public List<EnderecoPessoaListResponse> getEnderecoDaPessoaComId(UUID idPessoa) {
        log.info("[inicia] EnderecoController - getEnderecoDaPessoaComId");
        List<EnderecoPessoaListResponse> enderecosPessoa = enderecoService.buscaEnderecoDePessoaPorId(idPessoa);
        log.info("[finaliza] EnderecoController - getEnderecoDaPessoaComId");
        return enderecosPessoa;
    }

    @Override
    public EnderecoPrincipalDetalhado getEnderecoPrincipalDaPessoa(
            Boolean principal, UUID idPessoa) {

        log.info("[inicia] EnderecoController - getEnderecoPrincipalDaPessoa");
        EnderecoPrincipalDetalhado enderecoPrincipal = enderecoService.buscaEnderecoPrincipal(
                principal, idPessoa);
        log.info("[finaliza] EnderecoController - getEnderecoPrincipalDaPessoa");
        return enderecoPrincipal;
    }



}
