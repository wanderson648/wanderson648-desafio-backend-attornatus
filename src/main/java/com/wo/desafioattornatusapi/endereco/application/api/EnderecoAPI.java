package com.wo.desafioattornatusapi.endereco.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/pessoa/{idPessoa}/endereco")
public interface EnderecoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EnderecoResponse postEndereco(@PathVariable UUID idPessoa,
                                  @Valid @RequestBody EnderecoRequest endereco);
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EnderecoPessoaListResponse> getEnderecoDaPessoaComId(@PathVariable UUID idPessoa);

    @GetMapping("/principal")
    @ResponseStatus(code = HttpStatus.OK)
    EnderecoPrincipalDetalhado getEnderecoPrincipalDaPessoa(@RequestParam Boolean principal,
                                                            @PathVariable UUID idPessoa);
}
