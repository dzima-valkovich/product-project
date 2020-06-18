package by.intexsoft.vodmvi.assigment.service.mapper;

import by.intexsoft.vodmvi.assigment.api.dao.model.Product;
import by.intexsoft.vodmvi.assigment.api.service.dto.ProductSimpleDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductSimpleDto productToSimpleDto(Product product);

    Product simpleDtoToProduct(ProductSimpleDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product updateProductFromSimpleDtoIgnoreNull(ProductSimpleDto dto, @MappingTarget Product product);

    List<ProductSimpleDto> productToSimpleDto(List<Product> products);

    List<Product> simpleDtoToProduct(List<ProductSimpleDto> dtos);
}
