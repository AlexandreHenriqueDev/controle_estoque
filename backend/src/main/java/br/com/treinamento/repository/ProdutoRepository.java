package br.com.treinamento.repository;

import br.com.treinamento.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, String> {
}
