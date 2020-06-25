package by.intexsoft.vodmvi.assigment.controller;

import by.intexsoft.vodmvi.assigment.api.service.IAttributeDefinitionService;
import by.intexsoft.vodmvi.assigment.api.service.dto.AttributeDefinitionSimpleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attributeDefinitions")
public class AttributeDefinitionController {
    private IAttributeDefinitionService attributeDefinitionService;

    @GetMapping("{id}")
    public AttributeDefinitionSimpleDto getAttributeDefinitionById(@PathVariable Long id) {
        return attributeDefinitionService.getAttributeDefinitionById(id);
    }

    @GetMapping("ids/{ids}")
    public List<AttributeDefinitionSimpleDto> getAttributeDefinitionsByIds(@PathVariable Long[] ids,
                                                                           @RequestParam(defaultValue = "0") Integer offset,
                                                                           @RequestParam(defaultValue = "10") Integer limit) {
        return attributeDefinitionService.getAttributeDefinitionByIds(offset, limit, ids);
    }

    @GetMapping
    public List<AttributeDefinitionSimpleDto> getAllAttributeDefinitions(@RequestParam(defaultValue = "0") Integer offset,
                                                                         @RequestParam(defaultValue = "10") Integer limit) {
        return attributeDefinitionService.getAllAttributeDefinitions(offset, limit);
    }

    @GetMapping("byName")
    public AttributeDefinitionSimpleDto getAttributeDefinitionsByName(@RequestParam(required = false) String name) {
        return attributeDefinitionService.getAttributeDefinitionByName(name);
    }

    @GetMapping("byProductName")
    public List<AttributeDefinitionSimpleDto> getAttributeDefinitionsByProductName(@RequestParam(required = false) String name) {
        return attributeDefinitionService.getAttributeDefinitionsByProductName(name);
    }

    @PostMapping
    public AttributeDefinitionSimpleDto createNewAttributeDefinition(@RequestBody AttributeDefinitionSimpleDto dto) {
        return attributeDefinitionService.createNewAttributeDefinition(dto);
    }

    @PutMapping
    public AttributeDefinitionSimpleDto updateAttributeDefinition(@RequestBody AttributeDefinitionSimpleDto dto) {
        return attributeDefinitionService.updateAttributeDefinition(dto);
    }

    @PatchMapping
    public AttributeDefinitionSimpleDto updateAttributeDefinitionIgnoreNull(@RequestBody AttributeDefinitionSimpleDto dto) {
        return attributeDefinitionService.updateAttributeDefinitionIgnoreNull(dto);
    }

    @DeleteMapping("{id}")
    public Boolean deleteAttributeDefinitionById(@PathVariable Long id) {
        return attributeDefinitionService.deleteAttributeDefinitionById(id);
    }

    @Autowired
    public void setAttributeDefinitionService(IAttributeDefinitionService attributeDefinitionService) {
        this.attributeDefinitionService = attributeDefinitionService;
    }
}
