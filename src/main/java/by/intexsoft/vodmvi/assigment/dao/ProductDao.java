package by.intexsoft.vodmvi.assigment.dao;

import by.intexsoft.vodmvi.assigment.api.dao.IProductDao;
import by.intexsoft.vodmvi.assigment.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends GenericDao<Product> implements IProductDao {

    public ProductDao() {
        setClass(Product.class);
    }
}
