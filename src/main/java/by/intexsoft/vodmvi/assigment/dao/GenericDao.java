package by.intexsoft.vodmvi.assigment.dao;

import by.intexsoft.vodmvi.assigment.api.dao.IGenericDao;
import by.intexsoft.vodmvi.assigment.api.dao.model.IAEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public abstract class GenericDao<T extends IAEntity> implements IGenericDao<T> {
    private static final String ID_FIELD_NAME = "id";

    private Class<T> clazz;
    @PersistenceContext
    protected EntityManager em;

    protected Class<T> getClazz() {
        return clazz;
    }

    protected void setClass(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<T> getAll() {
        return em.createQuery(getCriteriaSelectQuery()).getResultList();
    }

    @Override
    public List<T> getAll(int limit) {
        return em.createQuery(getCriteriaSelectQuery()).setMaxResults(limit).getResultList();
    }

    @Override
    public List<T> getAll(int offset, int limit) {
        return em.createQuery(getCriteriaSelectQuery()).setFirstResult(offset)
                .setMaxResults(limit).getResultList();
    }

    @Override
    public T getById(Long id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> getByIds(Long... ids) {
        return em.createQuery(getCriteriaSelectQueryInIds(ids)).getResultList();
    }

    @Override
    public List<T> getByIds(int limit, Long... ids) {
        return em.createQuery(getCriteriaSelectQueryInIds(ids)).setMaxResults(limit).getResultList();
    }

    @Override
    public List<T> getByIds(int offset, int limit, Long... ids) {
        return em.createQuery(getCriteriaSelectQueryInIds(ids)).setFirstResult(offset)
                .setMaxResults(limit).getResultList();
    }

    @Override
    public T save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Argument of Dao save method can not be null. ");
        }
        em.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Argument of Dao update method can not be null. ");
        }
        return em.merge(entity);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Argument of Dao deleteById method can not be null. ");
        }
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaDelete<T> deleteQuery = criteriaBuilder.createCriteriaDelete(clazz);
        Root<T> root = deleteQuery.from(clazz);
        deleteQuery.where(criteriaBuilder.equal(root.get(ID_FIELD_NAME), id));
        return em.createQuery(deleteQuery).executeUpdate() > 0;
    }

    private CriteriaQuery<T> getCriteriaSelectQuery() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        return query.select(root);
    }

    private CriteriaQuery<T> getCriteriaSelectQueryInIds(Long... ids) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        CriteriaBuilder.In<Long> inClause = criteriaBuilder.in(root.get(ID_FIELD_NAME));
        for (Long id : ids) {
            inClause.value(id);
        }

        return query.select(root).where(inClause);
    }
}
