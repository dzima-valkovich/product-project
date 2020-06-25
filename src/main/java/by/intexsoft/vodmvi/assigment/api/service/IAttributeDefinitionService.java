package by.intexsoft.vodmvi.assigment.api.service;

import by.intexsoft.vodmvi.assigment.api.service.dto.AttributeDefinitionSimpleDto;

import java.util.List;

public interface IAttributeDefinitionService {
    List<AttributeDefinitionSimpleDto> getAllAttributeDefinitions();

    List<AttributeDefinitionSimpleDto> getAllAttributeDefinitions(int limit);

    List<AttributeDefinitionSimpleDto> getAllAttributeDefinitions(int offset, int limit);

    AttributeDefinitionSimpleDto getAttributeDefinitionById(Long id);

    List<AttributeDefinitionSimpleDto> getAttributeDefinitionByIds(Long... ids);

    List<AttributeDefinitionSimpleDto> getAttributeDefinitionByIds(int limit, Long... ids);

    List<AttributeDefinitionSimpleDto> getAttributeDefinitionsByProductName(String name);

    List<AttributeDefinitionSimpleDto> getAttributeDefinitionByIds(int offset, int limit, Long... ids);

    AttributeDefinitionSimpleDto getAttributeDefinitionByName(String name);

    AttributeDefinitionSimpleDto createNewAttributeDefinition(AttributeDefinitionSimpleDto dto);

    AttributeDefinitionSimpleDto updateAttributeDefinition(AttributeDefinitionSimpleDto dto);

    AttributeDefinitionSimpleDto updateAttributeDefinitionIgnoreNull(AttributeDefinitionSimpleDto dto);

    Boolean deleteAttributeDefinitionById(Long id);
}
