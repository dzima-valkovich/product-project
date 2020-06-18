package by.intexsoft.vodmvi.assigment.service.mapper;

import by.intexsoft.vodmvi.assigment.api.dao.model.AttributeDefinition;
import by.intexsoft.vodmvi.assigment.api.service.dto.AttributeDefinitionSimpleDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttributeDefinitionMapper {
    AttributeDefinitionSimpleDto attributeDefinitionToSimpleDto(AttributeDefinition attributeDefinition);

    AttributeDefinition simpleDtoToAttributeDefinition(AttributeDefinitionSimpleDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AttributeDefinition updateAttributeDefinitionFromSimpleDtoIgnoreNull(AttributeDefinitionSimpleDto dto, @MappingTarget AttributeDefinition attributeDefinition);

    List<AttributeDefinitionSimpleDto> attributeDefinitionToSimpleDto(List<AttributeDefinition> attributeDefinitions);

    List<AttributeDefinition> simpleDtoToAttributeDefinition(List<AttributeDefinitionSimpleDto> dtos);
}
