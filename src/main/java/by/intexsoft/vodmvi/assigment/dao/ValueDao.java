package by.intexsoft.vodmvi.assigment.dao;

import by.intexsoft.vodmvi.assigment.api.dao.IValueDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ValueDao extends GenericDao<Value> implements IValueDao {

    public ValueDao() {
        setClass(Value.class);
    }

    @Override
    public List<Value> getByProductId(Long productId) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Value> criteriaQuery = criteriaBuilder.createQuery(Value.class);
        Root<Value> root = criteriaQuery.from(Value.class);
        criteriaQuery.select(root);
        criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("attributeDefinition").get("id"), productId));

        return em.createQuery(criteriaQuery).getResultList();
    }
}
