package by.intexsoft.vodmvi.assigment.api.service.dto;

import by.intexsoft.vodmvi.assigment.api.dao.model.AttributeDefinitionType;

public class AttributeDefinitionSimpleDto {
    private String name;
    private AttributeDefinitionType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttributeDefinitionType getType() {
        return type;
    }

    public void setType(AttributeDefinitionType type) {
        this.type = type;
    }
}
