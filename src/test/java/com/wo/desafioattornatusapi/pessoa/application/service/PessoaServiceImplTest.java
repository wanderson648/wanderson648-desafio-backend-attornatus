package com.wo.desafioattornatusapi.pessoa.application.service;

import com.wo.desafioattornatusapi.pessoa.application.api.PessoaDetalhadoResponse;
import com.wo.desafioattornatusapi.pessoa.application.api.PessoaListResponse;
import com.wo.desafioattornatusapi.pessoa.application.repository.PessoaRepository;
import com.wo.desafioattornatusapi.pessoa.application.util.PessoaCreator;
import com.wo.desafioattornatusapi.pessoa.application.util.PessoaEditRequestCreator;
import com.wo.desafioattornatusapi.pessoa.application.util.PessoaRequestCreator;
import com.wo.desafioattornatusapi.pessoa.domain.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class PessoaServiceImplTest {

    @InjectMocks
    private PessoaServiceImpl pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @BeforeEach
    void setup() {
        when(pessoaRepository.salva(any(Pessoa.class)))
                .thenReturn(PessoaCreator.createValidPessoa());

        when(pessoaRepository.buscarTodasAsPessoas())
                .thenReturn(List.of(PessoaCreator.createValidPessoa()));

        when(pessoaRepository.buscarPessoaPorId(any()))
                .thenReturn(PessoaCreator.createValidPessoa());
    }

    @Test
    @DisplayName("Deve ser capaz de criar uma Pessoa")
    void deveSerCapazDeCriarUmaPessoa() {
        UUID pessoaId = pessoaService.criaPessoa(PessoaRequestCreator.createPessoaRequest())
                .getIdPessoa();

        assertThat(pessoaId).isNotNull();
    }


    @Test
    @DisplayName("Deve ser capaz de retornar todas Pessoas")
    void deveSerCapazDeRetornarTodasAsPessoas() {
        UUID idRetorno = PessoaCreator.createValidPessoa().getIdPessoa();
        String nomeRetorno = PessoaCreator.createValidPessoa().getNome();
        LocalDate dataNascimentoRetorno = PessoaCreator.createValidPessoa().getDataDeNascimento();

        List<PessoaListResponse> pessoas = pessoaService.getPessoas();

        assertThat(pessoas)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        assertThat(pessoas.get(0).getIdPessoa()).isEqualTo(idRetorno);
        assertThat(pessoas.get(0).getNome()).isEqualTo(nomeRetorno);
        assertThat(pessoas.get(0).getDataDeNascimento()).isEqualTo(dataNascimentoRetorno);
    }

    @Test
    @DisplayName("Deve ser capaz de retornar Pessoa por Id")
    void deveDeveSerCapazDeRetornarPessoaPorId() {
        UUID idRetorno = PessoaCreator.createValidPessoa().getIdPessoa();

        PessoaDetalhadoResponse pessoa = pessoaService.getPessoaId(UUID.randomUUID());

        assertThat(pessoa).isNotNull();
        assertThat(pessoa.getIdPessoa()).isNotNull().isEqualTo(idRetorno);
    }

    @Test
    @DisplayName("Deve ser capaz de editar Pessoa por Id")
    void deveSerCapazDeEditarPessoaPorId() {

        assertThatCode(() -> pessoaService.patchEditaPessoa(UUID.randomUUID(),
                PessoaEditRequestCreator.createPessoaRequest()))
                .doesNotThrowAnyException();
    }
}