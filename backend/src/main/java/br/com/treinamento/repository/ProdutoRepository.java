package br.com.treinamento.repository;

import br.com.treinamento.entity.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, String> {

    List<Produto> findAll();

    List<Produto> findByCodigo(String codigo);

}
