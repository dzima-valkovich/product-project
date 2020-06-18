package by.intexsoft.vodmvi.assigment.dao;

import by.intexsoft.vodmvi.assigment.api.dao.IAttributeDefinitionDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.AttributeDefinition;
import org.springframework.stereotype.Repository;

@Repository
public class AttributeDefinitionDao extends GenericDao<AttributeDefinition> implements IAttributeDefinitionDao {

    public AttributeDefinitionDao() {
        setClass(AttributeDefinition.class);
    }
}
