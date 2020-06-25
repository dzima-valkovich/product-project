package by.intexsoft.vodmvi.assigment.api.dao;

import by.intexsoft.vodmvi.assigment.api.dao.model.AttributeDefinition;

import java.util.List;

public interface IAttributeDefinitionDao extends IGenericDao<AttributeDefinition> {

    AttributeDefinition getByName(String name);

    List<AttributeDefinition> getByProductName(String name);
}
