package by.intexsoft.vodmvi.assigment.api.dao.model;

import javax.persistence.*;

@MappedSuperclass
public class IAEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
