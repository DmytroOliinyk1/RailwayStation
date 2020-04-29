package com.epam.dao.crud;

import com.epam.dao.builder.InstanceBuilder;

import java.util.List;

public interface DaoReadI<TEntity> {
    /**
     * Method gets object type of TEntity from database
     * by id
     *
     * @param builder
     * @param id
     * @return object type of TEntity
     */
    TEntity getById(InstanceBuilder<TEntity> builder, Long id);

    /**
     * Method gets object type of TEntity from database
     * by fields
     *
     * @param builder
     * @param fields
     * @return
     */
    List<TEntity> getByFields(InstanceBuilder<TEntity> builder, Object... fields);

    /**
     * Method gets list objects type of TEntity from database
     * by parameters
     *
     * @param builder
     * @param params
     * @return list objects type of TEntity
     */
    List<TEntity> getAll(InstanceBuilder<TEntity> builder, Object... params);

}