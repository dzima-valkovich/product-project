package by.intexsoft.vodmvi.assigment.service;

import by.intexsoft.vodmvi.assigment.api.dao.IAttributeDefinitionDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.AttributeDefinition;
import by.intexsoft.vodmvi.assigment.api.service.IAttributeDefinitionService;
import by.intexsoft.vodmvi.assigment.api.service.dto.AttributeDefinitionSimpleDto;
import by.intexsoft.vodmvi.assigment.service.mapper.AttributeDefinitionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AttributeDefinitionService implements IAttributeDefinitionService {
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
    public List<AttributeDefinitionSimpleDto> getAttributeDefinitionsByName(String name) {
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
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinition);
    }

    @Override
    public AttributeDefinitionSimpleDto updateAttributeDefinition(AttributeDefinitionSimpleDto dto) {
        AttributeDefinition attributeDefinition = attributeDefinitionDao.update(attributeDefinitionMapper.simpleDtoToAttributeDefinition(dto));
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinition);
    }

    @Override
    public AttributeDefinitionSimpleDto updateAttributeDefinitionIgnoreNull(AttributeDefinitionSimpleDto dto) {
        AttributeDefinition attributeDefinition = attributeDefinitionDao.getById(dto.getId());
        attributeDefinition = attributeDefinitionDao.update(attributeDefinitionMapper.updateAttributeDefinitionFromSimpleDtoIgnoreNull(dto, attributeDefinition));
        return attributeDefinitionMapper.attributeDefinitionToSimpleDto(attributeDefinition);
    }

    @Override
    public Boolean deleteAttributeDefinitionById(Long id) {
        return attributeDefinitionDao.deleteById(id);
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
