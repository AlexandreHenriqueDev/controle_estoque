package br.com.treinamento.controllers;

import br.com.treinamento.dto.ProdutoDto;
import br.com.treinamento.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(value = "/estoque/novo")
    public ResponseEntity<List<ProdutoDto>> inserirProduto(@RequestBody ProdutoDto produtoDto) {
        return ResponseEntity.ok().body(service.inserirProduto(produtoDto));
    }

    @PostMapping(value = "/estoque/editar")
    public ResponseEntity<List<ProdutoDto>> editarProduto(@Valid @RequestBody ProdutoDto produtoDto, Principal principal) {
        return ResponseEntity.ok().body(service.editarProduto(produtoDto));
    }

    @PostMapping(value = "/estoque/remover")
    public ResponseEntity<List<ProdutoDto>> removerProduto(@Valid @RequestBody ProdutoDto produtoDto, Principal principal) {
        return ResponseEntity.ok().body(service.removerProduto(produtoDto));
    }

}
