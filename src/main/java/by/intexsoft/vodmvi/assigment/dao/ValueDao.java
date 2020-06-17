package by.intexsoft.vodmvi.assigment.dao;

import by.intexsoft.vodmvi.assigment.api.dao.IValueDao;
import by.intexsoft.vodmvi.assigment.model.Value;
import org.springframework.stereotype.Repository;

@Repository
public class ValueDao extends GenericDao<Value> implements IValueDao {

    public ValueDao() {
        setClass(Value.class);
    }
}
