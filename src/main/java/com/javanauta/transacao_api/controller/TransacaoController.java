package com.javanauta.transacao_api.controller;

import com.javanauta.transacao_api.business.services.TransacaoService;
import com.javanauta.transacao_api.controller.dtos.TransacaoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping
    @Operation(description = "Edpoint responsável por adicionar transacões")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação gravada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Campos não atendem os requisitos da transação"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto){
        transacaoService.adicionarTransacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping@Operation(description = "Edpoint responsável por deletar transacões")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transação deletadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> deletarTransacoes(){
        transacaoService.limparTransacoes();
        return ResponseEntity.ok().build();
    }

}
