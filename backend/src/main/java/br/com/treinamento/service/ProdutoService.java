package br.com.treinamento.service;

import br.com.treinamento.dto.ProdutoDto;
import br.com.treinamento.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDto> buscarTodos() {
        return repository.findAll().stream().map(produto -> produto.toDto()).collect(Collectors.toList());
    }

}
