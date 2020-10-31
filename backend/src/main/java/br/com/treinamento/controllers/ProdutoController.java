package br.com.treinamento.controllers;

import br.com.treinamento.dto.ProdutoDto;
import br.com.treinamento.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/controle")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/estoque")
    public ResponseEntity<List<ProdutoDto>> buscarTodos(Principal principal) {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

}
