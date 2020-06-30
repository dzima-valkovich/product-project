package by.intexsoft.vodmvi.assigment.controller;

import by.intexsoft.vodmvi.assigment.api.service.IValueService;
import by.intexsoft.vodmvi.assigment.api.service.dto.ValueCreationDto;
import by.intexsoft.vodmvi.assigment.api.service.dto.ValueFullDto;
import by.intexsoft.vodmvi.assigment.api.service.dto.ValueSimpleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/values")
public class ValueController {
    private IValueService valueService;

    @GetMapping("{id}")
    public ValueFullDto getValueById(@PathVariable Long id) {
        return valueService.getValueById(id);
    }

    @GetMapping("ids/{ids}")
    public List<ValueFullDto> getValuesByIds(@PathVariable Long[] ids,
                                             @RequestParam(defaultValue = "0") Integer offset,
                                             @RequestParam(defaultValue = "10") Integer limit) {
        return valueService.getValuesByIds(offset, limit, ids);
    }

    @GetMapping
    public List<ValueFullDto> getAllValues(@RequestParam(defaultValue = "0") Integer offset,
                                           @RequestParam(defaultValue = "10") Integer limit) {
        return valueService.getAllValues(offset, limit);
    }

    @GetMapping("/product/{productId}")
    public List<ValueFullDto> getValuesByProductId(@PathVariable Long productId) {
        return valueService.getValuesByProductId(productId);
    }

    @GetMapping("/product/name/{productName}")
    public List<ValueFullDto> getValuesByProductName(@PathVariable String productName) {
        return valueService.getValuesByProductName(productName);
    }

    @PostMapping
    public ValueFullDto createNewValue(@RequestBody ValueCreationDto dto) {
        return valueService.createNewValue(dto);
    }

    @PutMapping
    public ValueFullDto updateValue(@RequestBody ValueSimpleDto dto) {
        return valueService.updateValue(dto);
    }

    @PatchMapping
    public ValueFullDto updateValueIgnoreNull(@RequestBody ValueSimpleDto dto) {
        return valueService.updateValueIgnoreNull(dto);
    }

    @DeleteMapping("{id}")
    public Boolean deleteValueById(@PathVariable Long id) {
        return valueService.deleteValueById(id);
    }

    @Autowired
    public void setValueService(IValueService valueService) {
        this.valueService = valueService;
    }
}
