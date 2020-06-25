package by.intexsoft.vodmvi.assigment.dao;

import by.intexsoft.vodmvi.assigment.api.dao.IProductDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class ProductDao extends GenericDao<Product> implements IProductDao {

    public ProductDao() {
        setClass(Product.class);
    }

    @Override
    public Product getByName(String name) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        return em.createQuery(query.where(criteriaBuilder.equal(root.get("name"), name))).getResultList().get(0);
    }
}
