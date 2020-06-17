package by.intexsoft.vodmvi.assigment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ia_products")
public class Product extends IAEntity {

    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "product")
    private List<Value> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }
}
