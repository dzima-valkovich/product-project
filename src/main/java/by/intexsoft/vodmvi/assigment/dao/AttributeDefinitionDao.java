package by.intexsoft.vodmvi.assigment.dao;

import by.intexsoft.vodmvi.assigment.api.dao.IAttributeDefinitionDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.AttributeDefinition;
import by.intexsoft.vodmvi.assigment.api.dao.model.Product;
import by.intexsoft.vodmvi.assigment.api.dao.model.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AttributeDefinitionDao extends GenericDao<AttributeDefinition> implements IAttributeDefinitionDao {

    public AttributeDefinitionDao() {
        setClass(AttributeDefinition.class);
    }

    @Override
    public AttributeDefinition getByName(String name) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<AttributeDefinition> query = criteriaBuilder.createQuery(AttributeDefinition.class);
        Root<AttributeDefinition> root = query.from(AttributeDefinition.class);
        return em.createQuery(query.where(criteriaBuilder.equal(root.get("name"), name))).getResultList().get(0);
    }

    @Override
    public List<AttributeDefinition> getByProductName(String name) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<AttributeDefinition> query = criteriaBuilder.createQuery(AttributeDefinition.class);
        Root<AttributeDefinition> root = query.from(AttributeDefinition.class);
        Join<AttributeDefinition, Value> values = root.join("values");
        Join<Value, Product> products = values.join("product");
        return em.createQuery(query.where(criteriaBuilder.equal(products.get("name"), name)).distinct(true)).getResultList();
    }
}
