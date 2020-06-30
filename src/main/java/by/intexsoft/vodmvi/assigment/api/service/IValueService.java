package by.intexsoft.vodmvi.assigment.api.service;

import by.intexsoft.vodmvi.assigment.api.service.dto.ValueCreationDto;
import by.intexsoft.vodmvi.assigment.api.service.dto.ValueFullDto;
import by.intexsoft.vodmvi.assigment.api.service.dto.ValueSimpleDto;

import java.util.List;

public interface IValueService {
    List<ValueFullDto> getAllValues();

    List<ValueFullDto> getAllValues(int limit);

    List<ValueFullDto> getAllValues(int offset, int limit);

    ValueFullDto getValueById(Long id);

    List<ValueFullDto> getValuesByIds(Long... ids);

    List<ValueFullDto> getValuesByIds(int limit, Long... ids);

    List<ValueFullDto> getValuesByIds(int offset, int limit, Long... ids);

    List<ValueFullDto> getValuesByProductId(Long productId);

    List<ValueFullDto> getValuesByProductName(String productName);

    ValueFullDto createNewValue(ValueCreationDto dto);

    ValueFullDto updateValue(ValueSimpleDto dto);

    ValueFullDto updateValueIgnoreNull(ValueSimpleDto dto);

    Boolean deleteValueById(Long id);
}
