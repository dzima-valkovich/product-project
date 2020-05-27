package by.intexsoft.vodmvi.assigment.dao.model.values;

import by.intexsoft.vodmvi.assigment.dao.model.IAEntity;

public abstract class Value<T> extends IAEntity {

    protected abstract T getValue();

    public String getStringValue() {
        return this.getValue().toString();
    }
}
