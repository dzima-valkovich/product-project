package by.intexsoft.vodmvi.assigment.dao.model.values;

import by.intexsoft.vodmvi.assigment.dao.model.Attribute;

import javax.persistence.*;

@Entity
@Table(name = "ia_boolean_values")
public class BooleanValue extends Value<Boolean> {

    @Column(name = "value")
    private Boolean value;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Attribute attribute;

    @Override
    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
