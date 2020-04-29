package com.epam.dao.crud;

public interface DaoCrudI <TEntity> extends DaoReadI<TEntity> {

    boolean insert(TEntity object);

    boolean updateById(Object... args);

    boolean updateByFields(Object... fieldsValues);

    boolean deleteById(Long id);

    boolean deleteByFields(Object... fieldsValues);
}