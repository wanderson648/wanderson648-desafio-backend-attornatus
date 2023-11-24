package com.wo.desafioattornatusapi.endereco.application.service;

import com.wo.desafioattornatusapi.endereco.application.api.EnderecoPessoaListResponse;
import com.wo.desafioattornatusapi.endereco.application.api.EnderecoPrincipalDetalhado;
import com.wo.desafioattornatusapi.endereco.application.api.EnderecoRequest;
import com.wo.desafioattornatusapi.endereco.application.api.EnderecoResponse;
import com.wo.desafioattornatusapi.endereco.application.repository.EnderecoRepository;
import com.wo.desafioattornatusapi.endereco.domain.Endereco;
import com.wo.desafioattornatusapi.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final PessoaService pessoaService;
    private final EnderecoRepository enderecoRepository;


    @Override
    public EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
        log.info("[inicia] EnderecoController - criaEndereco");
        pessoaService.getPessoaId(idPessoa);
        Endereco endereco = enderecoRepository.salvaEndereco(new Endereco(idPessoa, enderecoRequest));
        log.info("[finaliza] EnderecoController - criaEndereco");
        return new EnderecoResponse(endereco.getIdEndereco());
    }

    @Override
    public List<EnderecoPessoaListResponse> buscaEnderecoPessoaPorId(UUID idPessoa) {
        log.info("[inicia] EnderecoController - buscaEnderecoPessoaPorId");
        pessoaService.getPessoaId(idPessoa);
        List<Endereco> enderecos = enderecoRepository.buscaEnderecosPessoaComId(idPessoa);
        log.info("[finaliza] EnderecoController - buscaEnderecoPessoaPorId");
        return EnderecoPessoaListResponse.converte(enderecos);
    }

    @Override
    public EnderecoPrincipalDetalhado buscaEnderecoPrincipal(
            Boolean pricipal,UUID idPessoa) {

        log.info("[inicia] EnderecoController - buscaEnderecoPrincipal");
        pessoaService.getPessoaId(idPessoa);
        Endereco endereco = enderecoRepository.buscaEnderecoPrincipal(pricipal);
        log.info("[finaliza] EnderecoController - buscaEnderecoPrincipal");
        return new EnderecoPrincipalDetalhado(endereco);
    }
}
