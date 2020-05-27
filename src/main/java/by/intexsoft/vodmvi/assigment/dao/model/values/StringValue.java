package by.intexsoft.vodmvi.assigment.dao.model.values;

import by.intexsoft.vodmvi.assigment.dao.model.Attribute;

import javax.persistence.*;

@Entity
@Table(name = "ia_string_values")
public class StringValue extends Value<String> {

    @Column(name = "value")
    private String value;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Attribute attribute;

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
