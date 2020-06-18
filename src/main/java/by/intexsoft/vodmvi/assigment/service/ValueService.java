package by.intexsoft.vodmvi.assigment.service;

import by.intexsoft.vodmvi.assigment.api.dao.IValueDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.Value;
import by.intexsoft.vodmvi.assigment.api.service.IValueService;
import by.intexsoft.vodmvi.assigment.api.service.dto.ValueCreationDto;
import by.intexsoft.vodmvi.assigment.api.service.dto.ValueFullDto;
import by.intexsoft.vodmvi.assigment.api.service.dto.ValueSimpleDto;
import by.intexsoft.vodmvi.assigment.service.mapper.ValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ValueService implements IValueService {
    private IValueDao valueDao;
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
    public ValueFullDto createNewValue(ValueCreationDto dto) {
        return valueMapper.valueToFullDto(valueDao.save(valueMapper.creationDtoToValue(dto)));
    }

    @Override
    public ValueFullDto updateValue(ValueSimpleDto dto) {
        return valueMapper.valueToFullDto(valueDao.update(valueMapper.simpleDtoToValue(dto)));
    }

    @Override
    public ValueFullDto updateValueIgnoreNull(ValueSimpleDto dto) {
        Value value = valueDao.getById(dto.getId());
        value = valueMapper.updateValueFromSimpleDtoIgnoreNull(dto, value);
        return valueMapper.valueToFullDto(valueDao.update(value));
    }

    @Override
    public Boolean deleteValueById(Long id) {
        return valueDao.deleteById(id);
    }

    @Autowired
    public void setValueDao(IValueDao valueDao) {
        this.valueDao = valueDao;
    }

    @Autowired
    public void setValueMapper(ValueMapper valueMapper) {
        this.valueMapper = valueMapper;
    }
}
