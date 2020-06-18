package by.intexsoft.vodmvi.assigment.api.service.dto;

import java.util.Date;

public class ValueCreationDto {
    private Long id;
    private String stringValue;
    private Long longValue;
    private Boolean booleanValue;
    private Date dateValue;

    private ProductSimpleDto product;
    private AttributeDefinitionSimpleDto attributeDefinition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public ProductSimpleDto getProduct() {
        return product;
    }

    public void setProduct(ProductSimpleDto product) {
        this.product = product;
    }

    public AttributeDefinitionSimpleDto getAttributeDefinition() {
        return attributeDefinition;
    }

    public void setAttributeDefinition(AttributeDefinitionSimpleDto attributeDefinition) {
        this.attributeDefinition = attributeDefinition;
    }
}
