package com.epam.dao.crud;

import com.epam.dao.builder.InstanceBuilder;

import java.util.List;

public interface DaoReadI<TEntity> {

    TEntity getById(InstanceBuilder<TEntity> builder, Long id);

    List<TEntity> getByFields(InstanceBuilder<TEntity> builder, Object... fields);

    List<TEntity> getAll(InstanceBuilder<TEntity> builder, Object... params);

}