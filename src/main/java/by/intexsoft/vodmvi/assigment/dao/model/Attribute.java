package by.intexsoft.vodmvi.assigment.dao.model;

import by.intexsoft.vodmvi.assigment.dao.model.values.Value;

import javax.persistence.*;

@Entity
@Table(name = "ia_attributes")
public class Attribute extends IAEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AttributeType type;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    //TODO
    private Value value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttributeType getType() {
        return type;
    }

    public void setType(AttributeType type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
