package by.intexsoft.vodmvi.assigment.service;

import by.intexsoft.vodmvi.assigment.api.dao.IAttributeDefinitionDao;
import by.intexsoft.vodmvi.assigment.api.dao.IProductDao;
import by.intexsoft.vodmvi.assigment.api.dao.IValueDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.Value;
import by.intexsoft.vodmvi.assigment.api.service.IValueService;
import by.intexsoft.vodmvi.assigment.api.service.dto.ValueCreationDto;
import by.intexsoft.vodmvi.assigment.api.service.dto.ValueFullDto;
import by.intexsoft.vodmvi.assigment.api.service.dto.ValueSimpleDto;
import by.intexsoft.vodmvi.assigment.service.mapper.ValueMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ValueService implements IValueService {
    private static final Logger logger = LoggerFactory.getLogger(ValueService.class);
    private static final String VALUE_CREATION_MESSAGE = "New Value has bean created. id = %s.";
    private static final String VALUE_UPDATE_MESSAGE = "Value has bean updated. id = %s.";
    private static final String VALUE_DELETE_MESSAGE = "Value has bean deleted. id = %s.";

    private IValueDao valueDao;
    private IProductDao productDao;
    private IAttributeDefinitionDao attributeDefinitionDao;
    private ValueMapper valueMapper;

    @Override
    public List<ValueFullDto> getAllValues() {
        return valueMapper.valueToFullDto(valueDao.getAll());
    }

    @Override
    public List<ValueFullDto> getAllValues(int limit) {
        return valueMapper.valueToFullDto(valueDao.getAll(limit));
    }

    @Override
    public List<ValueFullDto> getAllValues(int offset, int limit) {
        return valueMapper.valueToFullDto(valueDao.getAll(offset, limit));
    }

    @Override
    public ValueFullDto getValueById(Long id) {
        return valueMapper.valueToFullDto(valueDao.getById(id));
    }

    @Override
    public List<ValueFullDto> getValuesByIds(Long... ids) {
        return valueMapper.valueToFullDto(valueDao.getByIds(ids));
    }

    @Override
    public List<ValueFullDto> getValuesByIds(int limit, Long... ids) {
        return valueMapper.valueToFullDto(valueDao.getByIds(limit, ids));
    }

    @Override
    public List<ValueFullDto> getValuesByIds(int offset, int limit, Long... ids) {
        return valueMapper.valueToFullDto(valueDao.getByIds(offset, limit, ids));
    }

    @Override
    public List<ValueFullDto> getValuesByProductId(Long productId) {
        return valueMapper.valueToFullDto(valueDao.getByProductId(productId));
    }

    @Override
    public List<ValueFullDto> getValuesByProductName(String productName) {
        return valueMapper.valueToFullDto(valueDao.getByProductName(productName));
    }

    @Override
    public ValueFullDto createNewValue(ValueCreationDto dto) {
        Value value = valueMapper.creationDtoToValue(dto);
        value.setProduct(productDao.getByName(dto.getProduct().getName()));
        value.setAttributeDefinition(attributeDefinitionDao.getByName(dto.getAttributeDefinition().getName()));

        ValueFullDto newDto = valueMapper.valueToFullDto(valueDao.save(value));
        logger.info(String.format(VALUE_CREATION_MESSAGE, newDto.getId()));
        return newDto;
    }

    @Override
    public ValueFullDto updateValue(ValueSimpleDto dto) {
        Value value = valueDao.getById(dto.getId());
        value = valueMapper.updateValueFromSimpleDto(dto, value);
        ValueFullDto newDto = valueMapper.valueToFullDto(valueDao.update(value));

        logger.info(String.format(VALUE_UPDATE_MESSAGE, newDto.getId()));
        return newDto;
    }

    @Override
    public ValueFullDto updateValueIgnoreNull(ValueSimpleDto dto) {
        Value value = valueDao.getById(dto.getId());
        value = valueMapper.updateValueFromSimpleDtoIgnoreNull(dto, value);
        ValueFullDto newDto = valueMapper.valueToFullDto(valueDao.update(value));

        logger.info(String.format(VALUE_UPDATE_MESSAGE, newDto.getId()));
        return newDto;
    }

    @Override
    public Boolean deleteValueById(Long id) {
        Boolean result = valueDao.deleteById(id);

        if (result) {
            logger.info(String.format(VALUE_DELETE_MESSAGE, id));
        }
        return result;
    }

    @Autowired
    public void setValueDao(IValueDao valueDao) {
        this.valueDao = valueDao;
    }

    @Autowired
    public void setProductDao(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    public void setAttributeDefinitionDao(IAttributeDefinitionDao attributeDefinitionDao) {
        this.attributeDefinitionDao = attributeDefinitionDao;
    }

    @Autowired
    public void setValueMapper(ValueMapper valueMapper) {
        this.valueMapper = valueMapper;
    }
}
