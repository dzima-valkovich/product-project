package by.intexsoft.vodmvi.assigment.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ia_attribute_definitions")
public class AttributeDefinition extends IAEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AttributeDefinitionType type;
    @OneToMany(mappedBy = "attributeDefinition")
    private List<Value> values;

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

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }
}

