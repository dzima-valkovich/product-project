package by.intexsoft.vodmvi.assigment.service.mapper;

import by.intexsoft.vodmvi.assigment.api.dao.model.AttributeDefinition;
import by.intexsoft.vodmvi.assigment.api.dao.model.Product;
import by.intexsoft.vodmvi.assigment.api.dao.model.Value;
import by.intexsoft.vodmvi.assigment.api.service.dto.*;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ValueMapper {
    ValueSimpleDto valueToSimpleDto(Value value);

    Value simpleDtoToValue(ValueSimpleDto dto);

    Value creationDtoToValue(ValueCreationDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Value updateValueFromSimpleDtoIgnoreNull(ValueSimpleDto dto, @MappingTarget Value value);

    List<ValueSimpleDto> valueToSimpleDto(List<Value> values);

    List<Value> simpleDtoToValue(List<ValueSimpleDto> dtos);


    ValueFullDto valueToFullDto(Value value);

    Value fullDtoToValue(ValueFullDto dto);

    List<ValueFullDto> valueToFullDto(List<Value> values);

    List<Value> fullDtoToValue(List<ValueFullDto> dtos);


    AttributeDefinitionSimpleDto attributeDefinitionToSimpleDto(AttributeDefinition attributeDefinition);

    AttributeDefinition simpleDtoToAttributeDefinition(AttributeDefinitionSimpleDto dto);

    ProductSimpleDto productToSimpleDto(Product product);

    Product simpleDtoToProduct(ProductSimpleDto dto);
}
