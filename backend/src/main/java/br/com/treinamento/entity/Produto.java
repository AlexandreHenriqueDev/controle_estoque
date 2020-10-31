package br.com.treinamento.entity;

import br.com.treinamento.dto.ProdutoDto;
import br.com.treinamento.mapper.GenericMapper;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(schema = "controle_estoque", name = "produto")
@Data
public class Produto {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "quantidade")
    private Integer quantidade;

    public ProdutoDto toDto() {
        return GenericMapper.INSTANCE.produtoDto(this);
    }

}

