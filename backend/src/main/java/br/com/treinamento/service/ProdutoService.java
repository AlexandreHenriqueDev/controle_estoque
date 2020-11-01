package br.com.treinamento.service;

import br.com.treinamento.dto.ProdutoDto;
import br.com.treinamento.entity.Produto;
import br.com.treinamento.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDto> buscarTodos() {
        return repository.findAll().stream().map(produto -> produto.toDto()).collect(Collectors.toList());
    }

    public List<ProdutoDto> inserirProduto(ProdutoDto produtoDto) {

        if(
            produtoDto != null
            && produtoDto.getNome() == null
            || produtoDto.getNome().isBlank()
            || produtoDto.getCodigo() == null
            || produtoDto.getCodigo().isBlank()
            || produtoDto.getPreco() == null
            || produtoDto.getPreco().isNaN()
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
        }

        if(repository.findByCodigo(produtoDto.getCodigo()) != null && !repository.findByCodigo(produtoDto.getCodigo()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um produto com o código informado");
        }

        Produto produto = new Produto();
        produto.setCodigo(produtoDto.getCodigo());
        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade() != null ? produtoDto.getQuantidade() : 0);

        repository.save(produto);
        return repository.findAll().stream().map(p -> p.toDto()).collect(Collectors.toList());
    }

    public List<ProdutoDto> editarProduto(ProdutoDto produtoDto) {

        if(
            produtoDto != null
            && produtoDto.getNome() == null
            || produtoDto.getNome().isBlank()
            || produtoDto.getCodigo() == null
            || produtoDto.getCodigo().isBlank()
            || produtoDto.getPreco() == null
            || produtoDto.getPreco().isNaN()
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
        }

        List<Produto> produtos = repository.findByCodigo(produtoDto.getCodigo());

        Produto produto = produtos != null && !produtos.isEmpty() ? produtos.get(0) : null;

        if(produto == null) {
            throw new ResponseStatusException(HttpStatus.OK, "Produto não encontrado");
        }

        produto.setCodigo(produtoDto.getCodigo());
        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade() != null ? produtoDto.getQuantidade() : produto.getQuantidade());

        repository.save(produto);
        return repository.findAll().stream().map(p -> p.toDto()).collect(Collectors.toList());

    }

    public List<ProdutoDto> removerProduto(ProdutoDto produtoDto) {

        if(
            produtoDto != null
            && produtoDto.getCodigo() == null
            || produtoDto.getCodigo().isBlank()
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
        }

        List<Produto> produtos = repository.findByCodigo(produtoDto.getCodigo());

        Produto produto = produtos != null && !produtos.isEmpty() ? produtos.get(0) : null;

        if(produto == null) {
            throw new ResponseStatusException(HttpStatus.OK, "Produto não encontrado");
        }

        repository.delete(produto);
        return repository.findAll().stream().map(p -> p.toDto()).collect(Collectors.toList());

    }

}
