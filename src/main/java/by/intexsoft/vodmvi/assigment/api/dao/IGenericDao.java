package by.intexsoft.vodmvi.assigment.api.dao;

import by.intexsoft.vodmvi.assigment.model.IAEntity;

import java.util.List;

public interface IGenericDao<T extends IAEntity> {
    List<T> getAll();

    List<T> getAll(int limit);

    List<T> getAll(int offset, int limit);

    T getById(Long id);

    List<T> getByIds(Long... ids);

    List<T> getByIds(int limit, Long... ids);

    List<T> getByIds(int offset, int limit, Long... ids);

    T save(T entity);

    T update(T entity);

    Boolean deleteById(Long id);
}
