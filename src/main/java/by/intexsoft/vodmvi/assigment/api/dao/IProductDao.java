package by.intexsoft.vodmvi.assigment.api.dao;

import by.intexsoft.vodmvi.assigment.api.dao.model.Product;

public interface IProductDao extends IGenericDao<Product> {
    Product getByName(String name);
}
