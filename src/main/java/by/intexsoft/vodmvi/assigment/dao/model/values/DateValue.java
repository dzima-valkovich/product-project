package by.intexsoft.vodmvi.assigment.dao.model.values;

import by.intexsoft.vodmvi.assigment.dao.model.Attribute;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ia_date_values")
public class DateValue extends Value<Date> {

    @Column(name = "value")
    private Date value;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Attribute attribute;

    @Override
    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
