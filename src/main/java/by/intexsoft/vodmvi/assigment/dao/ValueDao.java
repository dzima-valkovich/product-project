package by.intexsoft.vodmvi.assigment.dao;

import by.intexsoft.vodmvi.assigment.api.dao.IValueDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.Product;
import by.intexsoft.vodmvi.assigment.api.dao.model.Product_;
import by.intexsoft.vodmvi.assigment.api.dao.model.Value;
import by.intexsoft.vodmvi.assigment.api.dao.model.Value_;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
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
        criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get(Value_.PRODUCT).get(Product_.ID), productId));

        return em.createQuery(criteriaQuery).getResultList();
    }


    @Override
    public List<Value> getByProductName(String productName) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Value> criteriaQuery = criteriaBuilder.createQuery(Value.class);
        Root<Value> root = criteriaQuery.from(Value.class);
        Join<Value, Product> join = root.join(Value_.PRODUCT);
        criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(join.get(Product_.NAME), productName));

        return em.createQuery(criteriaQuery).getResultList();
    }
}
