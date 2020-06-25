package by.intexsoft.vodmvi.assigment.api.dao;

import by.intexsoft.vodmvi.assigment.api.dao.model.Product;

import java.util.List;

public interface IProductDao extends IGenericDao<Product> {
    List<Product> getByName(String name);
}
