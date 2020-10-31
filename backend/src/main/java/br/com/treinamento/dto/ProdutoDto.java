package br.com.treinamento.dto;

import lombok.Data;

@Data
public class ProdutoDto {

    private String nome;
    private String codigo;
    private Double preco;
    private Integer quantidade;

}
