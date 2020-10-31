package br.com.treinamento.mapper;

import br.com.treinamento.dto.ProdutoDto;
import br.com.treinamento.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenericMapper {

    GenericMapper INSTANCE = Mappers.getMapper(GenericMapper.class);

    ProdutoDto produtoDto(Produto produto);
}
