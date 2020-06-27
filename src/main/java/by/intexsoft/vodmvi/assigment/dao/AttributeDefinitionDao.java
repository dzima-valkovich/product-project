package by.intexsoft.vodmvi.assigment.dao;

import by.intexsoft.vodmvi.assigment.api.dao.IAttributeDefinitionDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.*;
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

        List<AttributeDefinition> list = em.createQuery(query.where(criteriaBuilder.equal(root.get(AttributeDefinition_.NAME), name))).getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<AttributeDefinition> getByProductName(String name) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<AttributeDefinition> query = criteriaBuilder.createQuery(AttributeDefinition.class);
        Root<AttributeDefinition> root = query.from(AttributeDefinition.class);
        Join<AttributeDefinition, Value> values = root.join(AttributeDefinition_.VALUES);
        Join<Value, Product> products = values.join(Value_.PRODUCT);
        return em.createQuery(query.where(criteriaBuilder.equal(products.get(Product_.NAME), name)).distinct(true)).getResultList();
    }
}
