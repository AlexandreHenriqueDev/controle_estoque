package br.com.treinamento.entity;

import br.com.treinamento.dto.ProdutoDto;
import br.com.treinamento.mapper.GenericMapper;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "controle_estoque", name = "produto")
@Data
public class Produto {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "preco")
    private Double preco;

    @Column(name = "quantidade", columnDefinition = "int default 0")
    private Integer quantidade;

    public ProdutoDto toDto() {
        return GenericMapper.INSTANCE.produtoDto(this);
    }

}

