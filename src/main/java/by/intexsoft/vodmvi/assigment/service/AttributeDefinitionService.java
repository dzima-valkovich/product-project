package by.intexsoft.vodmvi.assigment.service;

import by.intexsoft.vodmvi.assigment.api.dao.IAttributeDefinitionDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.AttributeDefinition;
import by.intexsoft.vodmvi.assigment.api.service.IAttributeDefinitionService;
import by.intexsoft.vodmvi.assigment.api.service.dto.AttributeDefinitionSimpleDto;
import by.intexsoft.vodmvi.assigment.service.mapper.AttributeDefinitionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AttributeDefinitionService implements IAttributeDefinitionService {
    private static final Logger logger = LoggerFactory.getLogger(AttributeDefinitionService.class);
    private static final String ATTRIBUTE_DEFINITION_CREATION_MESSAGE = "New AttributeDefinition has bean created. id = %s.";
    private static final String ATTRIBUTE_DEFINITION_UPDATE_MESSAGE = "AttributeDefinition has bean updated. id = %s.";
    private static final String ATTRIBUTE_DEFINITION_DELETE_MESSAGE = "AttributeDefinition has bean deleted. id = %s.";

    private IAttributeDefinitionDao attributeDefinitionDao;
    private AttributeDefinitionMapper attributeDefinitionMapper;

    @Override
    public List<AttributeDefinitionSimpleDto> getAllAttributeDefinitions() {
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinitionDao.getAll());
    }

    @Override
    public List<AttributeDefinitionSimpleDto> getAllAttributeDefinitions(int limit) {
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinitionDao.getAll(limit));
    }

    @Override
    public List<AttributeDefinitionSimpleDto> getAllAttributeDefinitions(int offset, int limit) {
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinitionDao.getAll(offset, limit));
    }

    @Override
    public AttributeDefinitionSimpleDto getAttributeDefinitionById(Long id) {
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinitionDao.getById(id));
    }

    @Override
    public List<AttributeDefinitionSimpleDto> getAttributeDefinitionByIds(Long... ids) {
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinitionDao.getByIds(ids));
    }

    @Override
    public List<AttributeDefinitionSimpleDto> getAttributeDefinitionByIds(int limit, Long... ids) {
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinitionDao.getByIds(limit, ids));
    }

    @Override
    public AttributeDefinitionSimpleDto getAttributeDefinitionByName(String name) {
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinitionDao.getByName(name));
    }

    @Override
    public List<AttributeDefinitionSimpleDto> getAttributeDefinitionsByProductName(String name) {
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinitionDao.getByProductName(name));
    }

    @Override
    public List<AttributeDefinitionSimpleDto> getAttributeDefinitionByIds(int offset, int limit, Long... ids) {
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinitionDao.getByIds(offset, limit, ids));
    }

    @Override
    public AttributeDefinitionSimpleDto createNewAttributeDefinition(AttributeDefinitionSimpleDto dto) {
        AttributeDefinition attributeDefinition = attributeDefinitionDao.save(attributeDefinitionMapper.simpleDtoToAttributeDefinition(dto));
        AttributeDefinitionSimpleDto newDto = attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinition);

        logger.info(String.format(ATTRIBUTE_DEFINITION_CREATION_MESSAGE, attributeDefinition.getId()));
        return newDto;
    }

    @Override
    public AttributeDefinitionSimpleDto updateAttributeDefinition(AttributeDefinitionSimpleDto dto) {
        AttributeDefinition attributeDefinition = attributeDefinitionDao.update(attributeDefinitionMapper.simpleDtoToAttributeDefinition(dto));
        AttributeDefinitionSimpleDto newDto = attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinition);

        logger.info(String.format(ATTRIBUTE_DEFINITION_UPDATE_MESSAGE, attributeDefinition.getId()));
        return newDto;
    }

    @Override
    public AttributeDefinitionSimpleDto updateAttributeDefinitionIgnoreNull(AttributeDefinitionSimpleDto dto) {
        AttributeDefinition attributeDefinition = attributeDefinitionDao.getById(dto.getId());
        attributeDefinition = attributeDefinitionDao.update(attributeDefinitionMapper.updateAttributeDefinitionFromSimpleDtoIgnoreNull(dto, attributeDefinition));
        AttributeDefinitionSimpleDto newDto = attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinition);

        logger.info(String.format(ATTRIBUTE_DEFINITION_UPDATE_MESSAGE, attributeDefinition.getId()));
        return newDto;
    }

    @Override
    public Boolean deleteAttributeDefinitionById(Long id) {
        Boolean result = attributeDefinitionDao.deleteById(id);

        if (result) {
            logger.info(String.format(ATTRIBUTE_DEFINITION_DELETE_MESSAGE, id));
        }
        return result;
    }

    @Autowired
    public void setAttributeDefinitionDao(IAttributeDefinitionDao attributeDefinitionDao) {
        this.attributeDefinitionDao = attributeDefinitionDao;
    }

    @Autowired
    public void setAttributeDefinitionMapper(AttributeDefinitionMapper attributeDefinitionMapper) {
        this.attributeDefinitionMapper = attributeDefinitionMapper;
    }
}
