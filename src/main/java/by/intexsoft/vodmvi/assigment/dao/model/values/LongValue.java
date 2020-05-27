package by.intexsoft.vodmvi.assigment.dao.model.values;

import by.intexsoft.vodmvi.assigment.dao.model.Attribute;

import javax.persistence.*;

@Entity
@Table(name = "ia_long_values")
public class LongValue extends Value<Long> {

    @Column(name = "value")
    private Long value;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Attribute attribute;

    @Override
    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
