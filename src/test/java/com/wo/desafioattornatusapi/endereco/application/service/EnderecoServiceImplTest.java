package com.wo.desafioattornatusapi.endereco.application.service;

import com.wo.desafioattornatusapi.endereco.application.api.EnderecoPessoaListResponse;
import com.wo.desafioattornatusapi.endereco.application.api.EnderecoPrincipalDetalhado;
import com.wo.desafioattornatusapi.endereco.application.repository.EnderecoRepository;
import com.wo.desafioattornatusapi.endereco.application.util.EnderecoCreator;
import com.wo.desafioattornatusapi.endereco.application.util.EnderecoRequestCreator;
import com.wo.desafioattornatusapi.endereco.domain.Endereco;
import com.wo.desafioattornatusapi.pessoa.application.api.PessoaDetalhadoResponse;
import com.wo.desafioattornatusapi.pessoa.application.service.PessoaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class EnderecoServiceImplTest {

    @InjectMocks
    private EnderecoServiceImpl enderecoService;

    @Mock
    private PessoaService pessoaService;

    @Mock
    private EnderecoRepository enderecoRepository;

    @BeforeEach
    void setup() {
        BDDMockito.when(enderecoRepository.salvaEndereco(ArgumentMatchers.any(Endereco.class)))
                .thenReturn(EnderecoCreator.createValidEndereco());

        BDDMockito.when(enderecoRepository.buscaEnderecosDePessoaComId(ArgumentMatchers.any()))
                .thenReturn(List.of(EnderecoCreator.createValidEndereco()));

        BDDMockito.when(enderecoRepository.buscaEnderecoPrincipal(ArgumentMatchers.anyBoolean()))
                .thenReturn(EnderecoCreator.createValidEndereco());
    }

    @Test
    @DisplayName("Deve ser capaz de criar um Endereco")
    void deveSerCapazDeCriarEndereco() {
        UUID enderecoId = enderecoService.criaEndereco(
                UUID.randomUUID(), EnderecoRequestCreator.createEnderecoRequest()).getIdEnd();

        assertThat(enderecoId).isNotNull();
    }

    @Test
    @DisplayName("Deve ser capaz de buscar endereco de uma pessoa por id")
    void deveSerCapazDeBuscarEnderecoDePessoaPorId() {
        UUID idEndereco = EnderecoCreator.createValidEndereco().getIdEndereco();
        String logadouro = EnderecoCreator.createValidEndereco().getLogadouro();
        String cep = EnderecoCreator.createValidEndereco().getCep();
        String numero = EnderecoCreator.createValidEndereco().getNumero();
        String cidade = EnderecoCreator.createValidEndereco().getCidade();
        Boolean principal = EnderecoCreator.createValidEndereco().getPrincipalEndereco();

        List<EnderecoPessoaListResponse> enderecos = enderecoService.buscaEnderecoDePessoaPorId(
                UUID.randomUUID());

        Assertions.assertThat(enderecos)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(enderecos.get(0).getIdEndereco()).isEqualTo(idEndereco);
        Assertions.assertThat(enderecos.get(0).getLogadouro()).isEqualTo(logadouro);
        Assertions.assertThat(enderecos.get(0).getCep()).isEqualTo(cep);
        Assertions.assertThat(enderecos.get(0).getNumero()).isEqualTo(numero);
        Assertions.assertThat(enderecos.get(0).getCidade()).isEqualTo(cidade);
        Assertions.assertThat(enderecos.get(0).getPrincipal()).isEqualTo(principal);
    }

    @Test
    @DisplayName("Deve ser capaz de retornar o endereco pricipal de uma pessoa")
    void deveSerCapazDeRetornarEnderecoPrincipalDePessoa() {
        Boolean enderecoPrincipal = EnderecoCreator.createValidEndereco().getPrincipalEndereco();

        EnderecoPrincipalDetalhado endereco = enderecoService.buscaEnderecoPrincipal(
                enderecoPrincipal, UUID.randomUUID());

        Assertions.assertThat(endereco).isNotNull();
        Assertions.assertThat(endereco.getPrincipal()).isNotNull().isEqualTo(enderecoPrincipal);
    }

}