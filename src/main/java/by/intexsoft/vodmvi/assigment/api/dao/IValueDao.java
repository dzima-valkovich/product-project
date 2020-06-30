package by.intexsoft.vodmvi.assigment.api.dao;

import by.intexsoft.vodmvi.assigment.api.dao.model.Value;

import java.util.List;

public interface IValueDao extends IGenericDao<Value> {

    List<Value> getByProductId(Long productId);

    List<Value> getByProductName(String productName);
}
